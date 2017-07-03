package com.oukingtim.web.vm;

import java.io.Serializable;

/**
 * Created by oukingtim
 */
public class SmartPageVM<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private SmartPagination pagination;

    private T search;

    private SmartSort sort;

    public SmartPagination getPagination() {
        return pagination;
    }

    public void setPagination(SmartPagination pagination) {
        this.pagination = pagination;
    }

    public T getSearch() {
        return search;
    }

    public void setSearch(T search) {
        this.search = search;
    }

    public SmartSort getSort() {
        return sort;
    }

    public void setSort(SmartSort sort) {
        this.sort = sort;
    }
}
