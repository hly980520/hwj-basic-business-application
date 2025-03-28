package com.hwj.basic.business.application.vo.membergiftvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户礼品
public class MemberGiftVO implements Serializable {
    private static final long serialVersionUID = -3036439961429517540L;

    private Long id;

    private Long memberId;

    //用户号
    private String loginAccount;

    //礼品名称
    private String giftName;

    private Long sourceId;

    private Integer status;

    //发放时间
    private LocalDateTime sendTime;

    private LocalDateTime updatedDate;

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

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MemberGiftVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId='" + memberId)
                .add("loginAccount=" + loginAccount + "'")
                .add("giftName=" + giftName)
                .add("sourceId=" + sourceId)
                .add("status=" + status)
                .add("sendTime=" + sendTime)
                .add("updatedDate='" + updatedDate + "'")
                .toString();
    }

}
