package com.hwj.basic.business.application.client.controller;

import com.hwj.basic.business.application.BaseTest;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.common.member.domain.Member;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


class MemberControllerTest extends BaseTest {

    @Resource
    private MemberController memberController;

    @Test
    void info() {
        ApiResult<Member> info = memberController.info(1L);
        logger.info("{}", info);
    }
}