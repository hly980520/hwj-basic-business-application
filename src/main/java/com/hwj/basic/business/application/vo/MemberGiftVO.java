package com.hwj.basic.business.application.vo;

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

    //操作
    private String operation;

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
                .add("operation='" + operation + "'")
                .toString();
    }

}
