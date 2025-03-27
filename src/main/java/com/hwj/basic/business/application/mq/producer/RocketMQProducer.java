package com.hwj.basic.business.application.mq.producer;

import com.hwj.basic.rocketmq.dto.RocketMessageDTO;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-21 16:27:58
 */
public class RocketMQProducer {

    private static final Logger log = LoggerFactory.getLogger(RocketMQProducer.class);

    /**
     * rocketMQ地址
     */
    private String nameAddr;

    /**
     * topic
     */
    private String topic;


    private RocketMQTemplate rocketMQTemplate;

    /**
     * 初始化函数
     */
    public void init() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        defaultMQProducer.setNamesrvAddr(nameAddr);
        defaultMQProducer.start();
        this.rocketMQTemplate = new RocketMQTemplate();
        this.rocketMQTemplate.setProducer(defaultMQProducer);
    }

    /**
     * 销毁函数
     */
    public void destroy() {
        if (Objects.isNull(this.rocketMQTemplate)) {
            return;
        }
        this.rocketMQTemplate.destroy();
    }

    public static RocketMQProducer build() {
        return new RocketMQProducer();
    }

    public RocketMQProducer nameAddr(String nameAddr) {
        this.nameAddr = nameAddr;
        return this;
    }

    public RocketMQProducer topic(String topic) {
        this.topic = topic;
        return this;
    }

    private RocketMQProducer() {
    }


    /**
     * 同步发送消息
     *
     * @param rocketMessageDTO 消息
     * @return true or false
     */
    public boolean sendMessage(RocketMessageDTO rocketMessageDTO) {
        try {
            SendResult sendResult = this.rocketMQTemplate.syncSend(topic, rocketMessageDTO.toString());
            return sendResult.getSendStatus() == SendStatus.SEND_OK;
        } catch (Exception e) {
            log.error("sendMessage error [{}] {} ", rocketMessageDTO, e.getMessage(), e);
            return false;
        }
    }

    /**
     * 同步发送消息
     *
     * @param topic      消息topic
     * @param rocketMessageDTO 消息
     * @return true or false
     */
    public boolean sendMessage(RocketMessageDTO rocketMessageDTO, String topic) {
        try {
            SendResult sendResult = this.rocketMQTemplate.syncSend(topic, rocketMessageDTO.toString());
            return sendResult.getSendStatus() == SendStatus.SEND_OK;
        } catch (Exception e) {
            log.error("sendMessage error [topic:{}] [{}] {} ", topic, rocketMessageDTO, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RocketMQProducer.class.getSimpleName() + "[", "]")
                .add("nameAddr='" + nameAddr + "'")
                .add("topic='" + topic + "'")
                .toString();
    }
}
