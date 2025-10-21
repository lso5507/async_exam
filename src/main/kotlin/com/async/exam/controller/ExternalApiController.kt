package com.async.exam.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/external")
class ExternalApiController {

    @GetMapping("/error")
    fun alwaysError(): ResponseEntity<String> {
        Thread.sleep(5000)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sever Error")
    }
}
