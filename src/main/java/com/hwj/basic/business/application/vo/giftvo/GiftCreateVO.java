package com.hwj.basic.business.application.vo.giftvo;

import com.hwj.basic.common.gift.dto.GiftDTO;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description: 礼品创建VO
 * @author: wenjing.huang
 * @since: 2025-04-22 15:58:52
 */
public class GiftCreateVO implements Serializable {
    private static final long serialVersionUID = 2549639476055064922L;

    private String giftName;

    private Integer giftType;

    /**
     * 发放数量
     */
    private Integer quantity;

    public GiftDTO toGiftDTO() {
        GiftDTO giftDTO = new GiftDTO();
        giftDTO.setName(giftName);
        giftDTO.setGiftType(giftType);
        giftDTO.setQuantity(quantity);
        return giftDTO;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GiftCreateVO.class.getSimpleName() + "[", "]")
                .add("giftName='" + giftName + "'")
                .add("giftType=" + giftType)
                .add("quantity=" + quantity)
                .toString();
    }
}
