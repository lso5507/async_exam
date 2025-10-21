package com.async.exam.config

import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import java.lang.reflect.Method

class CustomAsyncExceptionHandler : AsyncUncaughtExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        @JvmStatic
        var exceptionHandled = false
    }

    override fun handleUncaughtException(ex: Throwable, method: Method, vararg params: Any?) {
        log.error("Exception message - " + ex.message)
        log.error("Method name - " + method.name)
        for (param in params) {
            log.error("Parameter value - " + param)
        }
        exceptionHandled = true
    }

}
