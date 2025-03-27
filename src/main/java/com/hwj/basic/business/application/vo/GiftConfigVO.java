package com.hwj.basic.business.application.vo;

import java.io.Serializable;
import java.util.StringJoiner;

//礼品配置
public class GiftConfigVO implements Serializable {
    private static final long serialVersionUID = 1252472206323075556L;

    private String giftName;

    private Integer giftType;

    //发放数量
    private Integer sendNum;

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getGiftType() {
        return giftType;
    }

    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GiftConfigVO.class.getSimpleName() + "[", "]")
                .add("giftName='" + giftName + "'")
                .add("giftType=" + giftType)
                .add("sendNum=" + sendNum)
                .toString();
    }
}
