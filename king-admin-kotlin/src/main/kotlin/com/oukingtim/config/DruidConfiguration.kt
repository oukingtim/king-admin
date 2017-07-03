package com.oukingtim.config

import com.alibaba.druid.support.http.StatViewServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by oukingtim
 */
@Configuration
class DruidConfiguration {
    @Bean
    fun druidServlet(): ServletRegistrationBean {
        val servletRegistrationBean = ServletRegistrationBean()
        servletRegistrationBean.setServlet(StatViewServlet())
        servletRegistrationBean.addUrlMappings("/druid/*")
        return servletRegistrationBean
    }
}