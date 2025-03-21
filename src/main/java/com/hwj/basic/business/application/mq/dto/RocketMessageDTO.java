package com.hwj.basic.business.application.mq.dto;

import com.alibaba.fastjson2.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-21 16:45:19
 */
public class RocketMessageDTO implements Serializable {

    private static final long serialVersionUID = 5424810224687391970L;

    /**
     * 消息id -- 默认为时间戳
     */
    private long messageId = System.currentTimeMillis();

    /**
     * 消息类型, 由生产者定义
     */
    private int messageType = 0;

    /**
     * 消息子类型<br>
     * 从属与消息类型的二级类型, 由生产者定义
     */
    private int messageSubType = 0;

    /**
     * 业务数据
     */
    private final JSONObject data = new JSONObject();

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getMessageSubType() {
        return messageSubType;
    }

    public void setMessageSubType(int messageSubType) {
        this.messageSubType = messageSubType;
    }

    public JSONObject getData() {
        return data;
    }

    public <T> T getDataValue(String key, Class<T> type) {
        return this.data.getObject(key, type);
    }

    public <T> List<T> getDataValueList(String key, Class<T> type) {
        return this.data.getList(key, type);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RocketMessageDTO.class.getSimpleName() + "[", "]")
                .add("messageId=" + messageId)
                .add("messageType=" + messageType)
                .add("messageSubType=" + messageSubType)
                .add("data=" + data)
                .toString();
    }
}
