package com.async.exam.service

import com.async.exam.config.CustomAsyncExceptionHandler
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.TimeUnit

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AsyncServiceTest {

    private val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var asyncService: AsyncService

    @BeforeEach
    fun setUp() {
        CustomAsyncExceptionHandler.exceptionHandled = false
    }

    @Test
    fun `test async exception handling`() {
        log.info("Running test: test async exception handling")
        asyncService.callExternalApi()

        // Since the method is async, we need to wait for it to complete
        // and for the exception handler to be called.
        TimeUnit.SECONDS.sleep(2)

        assertTrue(asyncService.testValue != 200 && asyncService.testValue != 500 )
    }
}
