package com.oukingtim.config

import com.baomidou.mybatisplus.enums.DBType
import com.baomidou.mybatisplus.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by oukingtim
 */
@Configuration
@MapperScan("com.oukingtim.mapper*")
class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br></br>
     * 文档：http://mp.baomidou.com<br></br>
     */
    @Bean
    fun paginationInterceptor(): PaginationInterceptor {
        val paginationInterceptor = PaginationInterceptor()
        paginationInterceptor.setDialectType(DBType.MYSQL.db)
        //        paginationInterceptor.setOptimizeType(Optimize.JSQLPARSER.getOptimize());
        return paginationInterceptor
    }
}