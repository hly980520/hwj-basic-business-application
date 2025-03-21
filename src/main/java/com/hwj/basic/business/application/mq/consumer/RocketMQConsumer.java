package com.hwj.basic.business.application.mq.consumer;

import com.hwj.basic.business.application.mq.dto.RocketMessageDTO;

import java.time.LocalDateTime;

public interface RocketMQConsumer {

    /**
     * 获取消息类型
     * @return int
     */
    int getMessageType();

    /**
     * handle中按需对messageSubType做过滤
     * @param rocketMessageDTO 消息
     */
    void handle(RocketMessageDTO rocketMessageDTO);

    /**
     * 指定消费者从什么时候开始消费(第一次上线的时候才会有意义，后续就没关系了)；
     * consumeFromTime 之前的发送的消息会被忽略；
     * 当生产者先启动,或者增加新的消费组，为了避免消费新消费者上线前产生的消息，必须指定一个消费时间，该时间之前的消息不处理
     *
     * 老项目现在要强制实现（返回个null就行），主要防止新的消费者忘记去实现
     *
     * 建议设置时间点为功能上线时间
     *
     * @return LocalDateTime or null
     */
    LocalDateTime getConsumeFromTime();
}
