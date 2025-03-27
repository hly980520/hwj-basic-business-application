package com.hwj.basic.business.application.mq.consumer;

import com.hwj.basic.rocketmq.constant.TopicConst;
import com.hwj.basic.rocketmq.dto.RocketMessageDTO;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Component;

/**
 * 消费用户注册消息
 * @author penghuang
 */
@Component
@RocketMQMessageListener(topic = TopicConst.MEMBER_REGISTER,consumerGroup = "hwj-basic-business-application")
public class MemberRegisterConsumer extends RocketMQBaseConsumer{
    @Override
    protected void handleMessage(RocketMessageDTO rocketMessageDTO) {
        //TODO 执行注册消息消费逻辑
    }
}
