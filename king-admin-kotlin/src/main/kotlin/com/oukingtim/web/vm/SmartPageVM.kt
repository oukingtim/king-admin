package com.oukingtim.web.vm

/**
 * Created by oukingtim
 */
class SmartPageVM<T> {
    var pagination: SmartPagination? = null

    var search: T? = null

    var sort: SmartSort? = null
}