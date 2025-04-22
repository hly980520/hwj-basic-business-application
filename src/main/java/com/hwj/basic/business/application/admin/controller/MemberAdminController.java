package com.hwj.basic.business.application.admin.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.params.PageParams;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.business.application.vo.PageVO;
import com.hwj.basic.business.application.vo.membervo.MemberVO;
import com.hwj.basic.common.member.domain.Member;
import com.hwj.basic.common.member.params.MemberQuery;
import com.hwj.basic.common.member.service.MemberReadService;
import com.hwj.basic.mybatis.DataPage;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 21:17:38
 */
@RestController
@RequestMapping("/admin/member")
public class MemberAdminController {

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private MemberReadService memberReadService;

    @PostMapping("/page")
    public ApiResult<PageVO<MemberVO>> page(@ModelAttribute PageParams<Member> pageParams, @ModelAttribute MemberQuery queryParams) {
        RpcResult<DataPage<Member>> rpcResult = memberReadService.queryPage(pageParams.toDataPage(), queryParams);
        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }
        DataPage<Member> dataPage = rpcResult.getData();

        List<MemberVO> dataList = dataPage.getDataList()
                .stream()
                .map(MemberVO::of)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return ApiResult.success(PageVO.of(dataList, dataPage.getTotalCount()));
    }

}
