package com.hwj.basic.business.application.vo.giftvo;

import com.hwj.basic.common.gift.dto.GiftDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

//礼品中心
public class GiftVO implements Serializable {

    private static final long serialVersionUID = 8850850986226902941L;

    private Long id;

    private String giftName;

    private Integer giftType;

    //发放数量
    private Integer quantity;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;

    public static GiftVO of(GiftDTO giftDTO) {
        if (Objects.isNull(giftDTO)) {
            return null;
        }

        GiftVO giftVO = new GiftVO();
        giftVO.setId(giftDTO.getId());
        giftVO.setGiftName(giftDTO.getName());
        giftDTO.setGiftType(giftVO.getGiftType());
        giftVO.setQuantity(giftDTO.getQuantity());
        giftVO.setCreatedDate(giftDTO.getCreatedDate());
        giftVO.setCreatedBy(giftDTO.getCreatedBy());
        giftVO.setUpdatedDate(giftDTO.getUpdatedDate());
        giftVO.setUpdatedBy(giftDTO.getUpdatedBy());
        return giftVO;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GiftVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("giftName='" + giftName + "'")
                .add("giftType=" + giftType)
                .add("quantity=" + quantity)
                .add("createdDate='" + createdDate + "'")
                .add("createdBy='" + createdBy + "'")
                .add("updatedDate='" + updatedDate + "'")
                .add("updatedBy='" + updatedBy + "'")
                .toString();
    }
}
