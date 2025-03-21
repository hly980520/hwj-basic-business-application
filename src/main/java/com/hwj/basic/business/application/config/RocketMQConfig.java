package com.hwj.basic.business.application.config;

import com.hwj.basic.business.application.mq.producer.RocketMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-21 16:23:54
 */
@Configuration
public class RocketMQConfig {

    @Resource
    private Environment env;

    @Bean(name = "rocketMQProducer", initMethod = "init", destroyMethod = "destroy")
    public RocketMQProducer rocketMQProducer() {
        return RocketMQProducer.build()
                .nameAddr(env.getRequiredProperty("hwj.rocketmq.name-server"))
                .producer(env.getRequiredProperty("hwj.rocketmq.producer.group"));
    }
}
