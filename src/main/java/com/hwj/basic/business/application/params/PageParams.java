package com.hwj.basic.business.application.params;

import com.hwj.basic.mybatis.DataPage;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description: 分页请求参数
 * @author: peng.huang
 * @since: 2025-03-18 21:25:34
 */
public class PageParams<T> implements Serializable {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页数据量
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方向
     */
    private String order;

    public DataPage<T> toDataPage() {
        if (Objects.isNull(this.pageNo)) {
            this.pageNo = 1;
        }

        if (Objects.isNull(this.pageSize)) {
            this.pageSize = 20;
        }
        DataPage<T> dataPage = new DataPage<>();
        dataPage.setPageNo(this.pageNo);
        dataPage.setPageSize(this.pageSize);
        dataPage.setOrderBy(this.order);
        dataPage.setOrder(this.sort);
        return dataPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageParams.class.getSimpleName() + "[", "]")
                .add("pageNo=" + pageNo)
                .add("pageSize=" + pageSize)
                .add("sort='" + sort + "'")
                .add("order='" + order + "'")
                .toString();
    }
}
