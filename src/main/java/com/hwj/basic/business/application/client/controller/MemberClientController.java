package com.hwj.basic.business.application.client.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.common.member.domain.Member;
import com.hwj.basic.common.member.service.MemberReadService;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 11:00:44
 */
@RestController
@RequestMapping("/client/member")
public class MemberClientController {

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private MemberReadService memberReadService;

    @PostMapping("/info")
    public ApiResult<Member> info(@RequestParam Long memberId) {
        RpcResult<Member> rpcResult = memberReadService.queryById(memberId);
        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }
        return ApiResult.success(rpcResult.getData());
    }

    @NacosValue("${dubbo.application.name}")
    private String configValue;

    @PostConstruct
    public void testNacos() throws InterruptedException {
        Thread.sleep(300000);
        System.out.println("config value: " + configValue);
    }
}
