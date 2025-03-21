package com.hwj.basic.business.application.mq.receiver;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-21 17:52:01
 */
public class RocketMQReceiver implements BeanPostProcessor, ApplicationListener<ContextRefreshedEvent> {

    /**
     * 是否刚启动
     */
    private boolean isStarted = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
