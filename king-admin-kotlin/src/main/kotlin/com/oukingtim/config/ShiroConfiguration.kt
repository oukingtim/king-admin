package com.oukingtim.config

import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.session.mgt.SessionManager
import org.apache.shiro.spring.LifecycleBeanPostProcessor
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.LinkedHashMap

/**
 * Created by oukingtim
 */
@Configuration
class ShiroConfiguration {

    @Bean(name = arrayOf("sessionManager"))
    fun sessionManager(): SessionManager {
        val sessionManager = DefaultWebSessionManager()
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.globalSessionTimeout = (60 * 60 * 1000).toLong()
        sessionManager.isSessionValidationSchedulerEnabled = true

        return sessionManager
    }

    @Bean(name = arrayOf("securityManager"))
    fun securityManager(shiroRealm: ShiroRealm, sessionManager: SessionManager): SecurityManager {
        val securityManager = DefaultWebSecurityManager()
        securityManager.setRealm(shiroRealm)
        securityManager.sessionManager = sessionManager

        return securityManager
    }

    @Bean
    fun shirFilter(securityManager: SecurityManager): ShiroFilterFactoryBean {
        val shiroFilter = ShiroFilterFactoryBean()
        shiroFilter.securityManager = securityManager
        shiroFilter.loginUrl = "/auth.html"
        shiroFilter.unauthorizedUrl = "/404.html"

        val filterMap = LinkedHashMap<String, String>()

        filterMap.put("/api/**", "anon")
        filterMap.put("/assets/**", "anon")
        filterMap.put("/fonts/**", "anon")
        filterMap.put("/maps/**", "anon")
        filterMap.put("/scripts/**", "anon")
        filterMap.put("/styles/**", "anon")
        filterMap.put("/auth.html", "anon")
        filterMap.put("/index.html", "anon")
        filterMap.put("/**", "authc")
        shiroFilter.filterChainDefinitionMap = filterMap

        return shiroFilter
    }

    @Bean(name = arrayOf("lifecycleBeanPostProcessor"))
    fun lifecycleBeanPostProcessor(): LifecycleBeanPostProcessor {
        return LifecycleBeanPostProcessor()
    }

    @Bean
    fun defaultAdvisorAutoProxyCreator(): DefaultAdvisorAutoProxyCreator {
        val proxyCreator = DefaultAdvisorAutoProxyCreator()
        proxyCreator.isProxyTargetClass = true
        return proxyCreator
    }

    @Bean
    fun authorizationAttributeSourceAdvisor(securityManager: SecurityManager): AuthorizationAttributeSourceAdvisor {
        val advisor = AuthorizationAttributeSourceAdvisor()
        advisor.securityManager = securityManager
        return advisor
    }

}