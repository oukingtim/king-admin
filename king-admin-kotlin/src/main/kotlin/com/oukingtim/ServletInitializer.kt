package com.oukingtim

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

/**
 * Created by oukingtim
 */
class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.sources(KingAdminKotlinApplication::class.java!!)
    }
}