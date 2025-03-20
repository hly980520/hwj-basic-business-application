package com.hwj.basic.business.application.client.controller;


import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.common.member.domain.Member;
import com.hwj.basic.common.member.service.MemberReadService;
import com.hwj.basic.common.member.service.MemberWriteService;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;


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

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private MemberWriteService memberWriteService;

    @PostMapping("/info")
    public ApiResult<Member> info(@RequestParam Long memberId) {
        RpcResult<Member> rpcResult = memberReadService.queryById(memberId);
        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }
        return ApiResult.success(rpcResult.getData());
    }

    //用户修改个人信息
    @PostMapping("/update")
    public ApiResult<Member> update(@RequestBody Member member){
        RpcResult<Member> rpcResult = memberWriteService.update(member);
        if (!rpcResult.isSuccess()){
            return ApiResult.failed(rpcResult);
        }
        return ApiResult.success(rpcResult.getData());
    }

    //用户注册
    @PostMapping("/signup")
    public ApiResult<Member> signup(@RequestBody Member member){
        RpcResult<Member> rpcResult = memberWriteService.create(member);
        if (!rpcResult.isSuccess()){
            return ApiResult.failed(rpcResult);
        }
        return ApiResult.success(rpcResult.getData());
    }

    //用户登录
    @PostMapping("/login")
    public ApiResult<Member> login(@RequestParam String loginAccount,@RequestParam String loginPassword){
        RpcResult<Member> userResult = memberReadService.queryByLoginAccount(loginAccount);
        if (!userResult.isSuccess()){
            return ApiResult.failed(userResult);
        }
        Member member = userResult.getData();
        boolean isPasswordValid = BCrypt.checkpw(loginPassword, member.getLoginPassword());
        if (!isPasswordValid) {
            return ApiResult.failed("409","密码错误");
        }
        member.setLoginPassword(null);
        return ApiResult.success(member);
    }

}
