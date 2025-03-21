package com.hwj.basic.business.application.mq.utils;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-21 17:20:53
 */
public class TopicUtils {

    private TopicUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 构建topic
     * @param producer 消息生产者
     * @param messageType 消息类型
     * @return String
     */
    public static String buildTopic(String producer, int messageType) {
        return String.format("%s_%s", producer, messageType);
    }
}
