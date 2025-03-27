package com.hwj.basic.business.application.vo;

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

    private LocalDateTime createdDate;

    //发放时间
    private LocalDateTime sendTime;

    //操作
    private String operation;


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
                .add("createdDate=" + createdDate)
                .add("sendTime='" + sendTime + "'")
                .add("operation='" + operation + "'")
                .toString();
    }

}
