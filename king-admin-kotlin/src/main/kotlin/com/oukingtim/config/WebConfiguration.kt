package com.oukingtim.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

/**
 * Created by oukingtim
 */
@Configuration
class WebConfiguration {

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        source.registerCorsConfiguration("/api/**", config)
        source.registerCorsConfiguration("/sys/**", config)
        source.registerCorsConfiguration("/druid/**", config)
        source.registerCorsConfiguration("/management/**", config)
        return CorsFilter(source)
    }
}