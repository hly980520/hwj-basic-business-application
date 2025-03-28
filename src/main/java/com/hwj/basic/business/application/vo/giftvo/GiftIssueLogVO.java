package com.hwj.basic.business.application.vo.giftvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户礼品发放流水
public class GiftIssueLogVO implements Serializable {
    private static final long serialVersionUID = 8545910345226151002L;

    private Long id;

    private Long memberId;

    //用户号
    private String loginAccount;

    //礼品名称
    private String giftName;

    //发放数量
    private Integer sendNum;

    private Integer sourceType;

    private Long sourceId;

    //发放状态
    private Integer sendStatus;

    private String createdDate;

    //发放时间
    private String sendTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GiftIssueLogVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId='" + memberId)
                .add("loginAccount=" + loginAccount + "'")
                .add("giftName=" + giftName)
                .add("sendNum=" + sendNum)
                .add("sourceType=" + sourceType)
                .add("sourceId=" + sourceId)
                .add("sendStatus=" + sendStatus)
                .add("createdDate=" + createdDate + "'")
                .add("sendTime='" + sendTime + "'")
                .toString();
    }

}
