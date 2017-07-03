package com.oukingtim.domain

import com.baomidou.mybatisplus.enums.SqlMethod
import com.baomidou.mybatisplus.exceptions.MybatisPlusException
import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.mapper.SqlHelper
import com.baomidou.mybatisplus.mapper.SqlRunner
import com.baomidou.mybatisplus.mapper.Wrapper
import com.baomidou.mybatisplus.plugins.Page
import com.baomidou.mybatisplus.toolkit.StringUtils
import com.oukingtim.util.ShiroUtils
import org.apache.ibatis.session.SqlSession
import org.springframework.transaction.annotation.Transactional
import java.io.Serializable
import java.util.*

/**
 * 通用实体（通用字段）
 * Created by oukingtim
 */
abstract class BaseModel<T> {

    val id: String? = null

    var createUserId: String? = null

    var createTime: Date? = null

    var updateUserId: String? = null

    var updateTime: Date? = null

    protected fun pkVal(): Serializable {
        // TODO Auto-generated method stub
        return id!!
    }
}