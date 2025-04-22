package com.hwj.basic.business.application.admin.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.params.PageParams;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.business.application.vo.giftvo.GiftCreateVO;
import com.hwj.basic.business.application.vo.giftvo.GiftUpdateVO;
import com.hwj.basic.business.application.vo.giftvo.GiftVO;
import com.hwj.basic.business.application.vo.PageVO;
import com.hwj.basic.common.gift.dto.GiftDTO;
import com.hwj.basic.common.gift.service.GiftReadService;
import com.hwj.basic.common.gift.service.GiftWriteService;
import com.hwj.basic.mybatis.DataPage;
import com.hwj.basic.result.RpcResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/gifts")
public class GiftAdminController {

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private GiftReadService giftReadService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private GiftWriteService giftWriteService;

    // 分页查询礼品列
    @PostMapping("/page")
    public ApiResult<PageVO<GiftVO>> page(
            @ModelAttribute PageParams<GiftDTO> pageParams,
            @ModelAttribute GiftDTO queryParams) {

        RpcResult<DataPage<GiftDTO>> rpcResult =
                giftReadService.queryPage(pageParams.toDataPage(), queryParams);

        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }

        // 转换VO
        DataPage<GiftDTO> dataPage = rpcResult.getData();
        List<GiftVO> voList = dataPage.getDataList().stream()
                .map(GiftVO::of)
                .collect(Collectors.toList());

        PageVO<GiftVO> pageVO = new PageVO<>();
        pageVO.setData(voList);
        pageVO.setTotal(dataPage.getTotalCount());

        return ApiResult.success(pageVO);
    }

    @PostMapping("/save")
    public ApiResult<Object> saveGift(@RequestBody GiftCreateVO vo){
        // 必填字段
        if (StringUtils.isBlank(vo.getGiftName())) {
            return ApiResult.failed("PARAM_MISS", "礼品名称不能为空");
        }
        if (Objects.isNull(vo.getGiftType())) {
            return ApiResult.failed("PARAM_MISS", "礼品类型不能为空");
        }

        GiftDTO dto = vo.toGiftDTO();
        dto.setCreatedBy("wenjing.huang");
        dto.setUpdatedBy("wenjing.huang");
        RpcResult<GiftDTO> result = giftWriteService.create(dto);
        if (!result.isSuccess()) {
            return ApiResult.failed(result.getCode(), result.getMsg());
        }
        return ApiResult.success();
    }

    @PostMapping("/update")
    public ApiResult<Object> updateGift(@RequestBody GiftUpdateVO vo){

        if (Objects.isNull(vo.getId())) {
            return ApiResult.failed("PARAM_MISS", "礼品ID不能为空");
        }

        RpcResult<GiftDTO> existingGiftResult = giftReadService.queryById(vo.getId());
        if (!existingGiftResult.isSuccess()) {
            return ApiResult.failed(existingGiftResult.getCode(), existingGiftResult.getMsg());
        }

        if (Objects.isNull(existingGiftResult.getData())) {
            return ApiResult.failed("DATA_NOT_FOUND", "数据不存在");
        }

        GiftDTO dto = vo.toGiftDTO();
        dto.setUpdatedBy("wenjing.huang");

        RpcResult<GiftDTO> updateResult = giftWriteService.update(dto);
        if (!updateResult.isSuccess()) {
            return ApiResult.failed(updateResult.getCode(), updateResult.getMsg());
        }

        return ApiResult.success();

    }


    @PostMapping("/info")
    public ApiResult<GiftVO> queryinfo(@RequestParam Long id) {

        RpcResult<GiftDTO> rpcResult = giftReadService.queryById(id);

        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }

        GiftVO giftVO = GiftVO.of(rpcResult.getData());
        if (Objects.isNull(giftVO)) {
            return ApiResult.failed("DATA_NOT_FOUND", "数据不存在");
        }

        return ApiResult.success(giftVO);
    }
}
