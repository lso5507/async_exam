package com.async.exam.config

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync

@Configuration
@EnableAsync
class AsyncConfig : AsyncConfigurer {

    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler {
        return CustomAsyncExceptionHandler()
    }
}
