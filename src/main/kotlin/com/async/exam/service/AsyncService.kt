package com.async.exam.service

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AsyncService(private val restTemplate: RestTemplate) {

    private val log = LoggerFactory.getLogger(javaClass)
    var testValue = 0
    @Async
    fun callExternalApi() {
        log.info("Calling external API")
        try {
            val response = restTemplate.getForEntity("http://localhost:8080/external/error", String::class.java)
            log.info("Response: ${response.body}")
            testValue = 200
        } catch (e: Exception) {
            log.error("Error while calling external API", e)
            testValue = 500
            throw e
        }
    }
}
