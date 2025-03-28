package com.hwj.basic.business.application.vo.giftvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//礼品中心
public class GiftVO implements Serializable {

    private static final long serialVersionUID = 8850850986226902941L;
    private Long id;

    private String giftName;

    private Integer giftType;

    //发放数量
    private Integer issueCount;

    private String createdDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(Integer issueCount) {
        this.issueCount = issueCount;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GiftVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("giftName='" + giftName + "'")
                .add("giftType=" + giftType + "'")
                .add("issueCount=" + issueCount)
                .add("createdDate=" + createdDate)
                .add("createdBy=" + createdBy + "'")
                .add("updatedDate=" + updatedDate)
                .add("updatedBy='" + updatedBy + "'")
                .toString();
    }

}
