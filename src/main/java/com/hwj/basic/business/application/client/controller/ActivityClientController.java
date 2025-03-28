package com.hwj.basic.business.application.client.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.vo.activityvo.ActivityVO;
import com.hwj.basic.common.activity.service.ActivityReadService;
import com.hwj.basic.common.activity.service.ActivityWriteService;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/client/activity")
public class ActivityClientController {

    private static final Logger logger = LoggerFactory.getLogger(ActivityClientController.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityReadService activityReadService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityWriteService activityWriteService;

    @GetMapping("/list")
    public RpcResult<ActivityVO> list(){

        return RpcResult.success();
    }


}
