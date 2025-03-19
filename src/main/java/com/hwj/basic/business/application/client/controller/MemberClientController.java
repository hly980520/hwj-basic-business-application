package com.hwj.basic.business.application.client.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.common.member.domain.Member;
import com.hwj.basic.common.member.service.MemberReadService;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 11:00:44
 */
@RestController
@RequestMapping("/client/member")
public class MemberClientController {

    private static final Logger logger = LoggerFactory.getLogger(MemberClientController.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

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

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hwj:test-key","11111",1L, TimeUnit.MINUTES);

        String cacheValue = ops.get("hwj:test-key");
        logger.info("StringRedisTemplate value ===>> {}", cacheValue);

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("hwj:test-member",new Member(),1L, TimeUnit.MINUTES);

        Member member = (Member) opsForValue.get("hwj:test-member");
        logger.info("RedisTemplate value ===>> {}", member);


        Thread.sleep(300000);
        System.out.println("config value: " + configValue);
    }
}
