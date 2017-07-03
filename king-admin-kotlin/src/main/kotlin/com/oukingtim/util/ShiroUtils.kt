package com.oukingtim.util

import com.oukingtim.domain.SysUser
import org.apache.shiro.SecurityUtils
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject

/**
 * Created by oukingtim
 */
object ShiroUtils {

    fun getSession(): Session {
        return SecurityUtils.getSubject().session
    }

    fun getSubject(): Subject {
        return SecurityUtils.getSubject()
    }

    fun getUser(): SysUser {
        return SecurityUtils.getSubject().principal as SysUser
    }

    fun getUserId(): String {
        return getUser().id!!
    }

    fun setSessionAttribute(key: Any, value: Any) {
        getSession().setAttribute(key, value)
    }

    fun getSessionAttribute(key: Any): Any {
        return getSession().getAttribute(key)
    }

    fun isLogin(): Boolean {
        return SecurityUtils.getSubject().principal != null
    }

    fun logout() {
        SecurityUtils.getSubject().logout()
    }

    fun getKaptcha(key: String): String {
        val kaptcha = getSessionAttribute(key).toString()
        getSession().removeAttribute(key)
        return kaptcha
    }
}