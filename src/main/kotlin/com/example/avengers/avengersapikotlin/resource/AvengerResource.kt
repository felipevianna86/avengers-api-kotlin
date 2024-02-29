package com.example.avengers.avengersapikotlin.resource

import com.example.avengers.avengersapikotlin.request.AvengerRequest
import com.example.avengers.avengersapikotlin.response.AvengerResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/avenger")
class AvengerResource {

    @GetMapping
    fun getAvengers() = ResponseEntity.ok(emptyList<AvengerResponse>())

    @GetMapping("/{id}")
    fun getAvengerDetails(@PathVariable("id") id: Long) = ResponseEntity.ok().build<AvengerResponse>()

    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) = ResponseEntity.status(HttpStatus.CREATED)
            .build<AvengerResponse>()
}