package com.hwj.basic.business.application.vo;

import com.hwj.basic.mybatis.DataPage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 21:38:14
 */
public class PageVO<T> implements Serializable {

    private static final long serialVersionUID = -231867493887372034L;

    /**
     * 数据列表
     */
    private List<T> data;

    /**
     * 总数量
     */
    private Long total;

    public static <T> PageVO<T> toPageVO(DataPage<T> dataPage) {
        return of(dataPage.getDataList(), dataPage.getTotalCount());
    }

    public static <T> PageVO<T> toEmptyPageVO() {
        return of(Collections.emptyList(), 0L);
    }

    public static <T> PageVO<T> of(List<T> data, Long total) {
        PageVO<T> vo = new PageVO<>();
        vo.setData(data);
        vo.setTotal(total);
        return vo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageVO.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("total=" + total)
                .toString();
    }
}
