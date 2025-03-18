package com.hwj.basic.business.application.client.controller;

import com.hwj.basic.business.application.BaseTest;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.common.member.domain.Member;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


class MemberClientControllerTest extends BaseTest {

    @Resource
    private MemberClientController memberClientController;

    @Test
    void info() {
        ApiResult<Member> info = memberClientController.info(1L);
        logger.info("{}", info);
    }
}