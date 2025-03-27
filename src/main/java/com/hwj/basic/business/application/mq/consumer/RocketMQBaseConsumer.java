package com.hwj.basic.business.application.mq.consumer;

import com.alibaba.fastjson2.JSON;
import com.hwj.basic.rocketmq.dto.RocketMessageDTO;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RocketMQBaseConsumer implements RocketMQListener<String> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(String s) {
        logger.info("On Message --- {}", s);
        try {
            RocketMessageDTO rocketMessageDTO = JSON.parseObject(s, RocketMessageDTO.class);
            this.handleMessage(rocketMessageDTO);
        }catch (Exception e) {
            logger.error("On Message Exception --- {} {} ", s, e.getMessage(), e);
        }
    }

    protected abstract void handleMessage(RocketMessageDTO rocketMessageDTO);
}
