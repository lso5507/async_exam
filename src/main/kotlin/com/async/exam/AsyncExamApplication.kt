package com.async.exam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AsyncExamApplication

fun main(args: Array<String>) {
    runApplication<AsyncExamApplication>(*args)
}
