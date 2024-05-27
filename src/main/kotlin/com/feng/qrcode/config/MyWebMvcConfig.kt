package com.feng.qrcode.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MyWebMvcConfig : WebMvcConfigurer {
    @Value("\${web.qrpath}")
     val QR_PATH: String? = null
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        // 将/static/**访问映射到classpath:/mystatic/
        println(QR_PATH)
        registry.addResourceHandler("/qrcode/**").addResourceLocations("file:"+QR_PATH+"/")
    }
}