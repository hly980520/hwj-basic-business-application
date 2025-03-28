package com.hwj.basic.business.application.admin.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.converter.giftconverter.GiftVOConverter;
import com.hwj.basic.business.application.params.PageParams;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.business.application.vo.giftvo.GiftVO;
import com.hwj.basic.business.application.vo.PageVO;
import com.hwj.basic.common.gift.dto.GiftDTO;
import com.hwj.basic.common.gift.service.GiftReadService;
import com.hwj.basic.common.gift.service.GiftWriteService;
import com.hwj.basic.common.giftissueconfig.service.GiftIssueReadService;
import com.hwj.basic.mybatis.DataPage;
import com.hwj.basic.result.RpcResult;
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

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private GiftIssueReadService giftIssueReadService;

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

        // 转换VO并注入发放数量
        DataPage<GiftDTO> dataPage = rpcResult.getData();
        List<GiftVO> voList = dataPage.getDataList().stream()
                .map(dto -> {
                    // 根据礼品ID查询发放数量
                    RpcResult<Integer> countResult =
                            giftIssueReadService.countByGiftId(dto.getId());
                    Integer issueCount = countResult.isSuccess() ? countResult.getData() : 0;
                    return GiftVOConverter.dtoToVo(dto, issueCount);
                })
                .collect(Collectors.toList());

        PageVO<GiftVO> pageVO = new PageVO<>();
        pageVO.setData(voList);
        pageVO.setTotal(dataPage.getTotalCount());

        return ApiResult.success(pageVO);
    }

    @PostMapping("/save")
    public ApiResult<Long> saveGift(@RequestBody GiftVO vo){
        // 必填字段
        if (vo.getGiftName() == null || vo.getGiftName().isEmpty()) {
            return ApiResult.failed("PARAM_MISS", "礼品名称不能为空");
        }
        if (vo.getGiftType() == null) {
            return ApiResult.failed("PARAM_MISS", "礼品类型不能为空");
        }

        GiftDTO dto = GiftVOConverter.voToDto(vo);

        RpcResult<GiftDTO> rpcResult;

        RpcResult<GiftDTO> checkExists = giftReadService.queryByName(vo.getGiftName());
        if (Objects.nonNull(checkExists)){
            return ApiResult.failed(checkExists.getCode(), checkExists.getMsg());
        }
        RpcResult<GiftDTO> result = giftWriteService.create(dto);
        if (!result.isSuccess()) {
            return ApiResult.failed(result.getCode(), result.getMsg());
        }
        return ApiResult.success(result.getData().getId());
    }

    @PostMapping("/update")
    public ApiResult<Long> updateGift(@RequestBody GiftVO vo){

        if (vo.getId() == null){
            return ApiResult.failed("PARAM_MISS", "礼品ID不能为空");
        }

        RpcResult<GiftDTO> existingGiftResult = giftReadService.queryById(vo.getId());
        if (!existingGiftResult.isSuccess() || existingGiftResult.getData() == null) {
            return ApiResult.failed(existingGiftResult.getCode(), existingGiftResult.getMsg());
        }

        if (vo.getGiftName() != null) {
            RpcResult<GiftDTO> nameCheckResult = giftReadService.queryByName(vo.getGiftName());
            if (nameCheckResult.isSuccess() && nameCheckResult.getData() != null
                    && !nameCheckResult.getData().getId().equals(vo.getId())) {
                return ApiResult.failed(nameCheckResult.getCode(), nameCheckResult.getMsg());
            }
        }

        GiftDTO dto = GiftVOConverter.voToDto(vo);
        RpcResult<GiftDTO> updateResult = giftWriteService.update(dto);
        if (!updateResult.isSuccess()) {
            return ApiResult.failed(updateResult.getCode(), updateResult.getMsg());
        }

        return ApiResult.success(updateResult.getData().getId());

    }

}
