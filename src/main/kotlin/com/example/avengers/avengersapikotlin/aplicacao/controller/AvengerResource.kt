package com.example.avengers.avengersapikotlin.aplicacao.controller

import com.example.avengers.avengersapikotlin.domain.dto.AvengerRequest
import com.example.avengers.avengersapikotlin.domain.dto.AvengerResponse
import com.example.avengers.avengersapikotlin.domain.ports.repositories.AvengerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


private const val API_PATH = "/v1/api/avenger"
@RestController
@RequestMapping(API_PATH)
class AvengerResource(
        @Autowired private val repository: AvengerRepository
) {

    @GetMapping
    fun getAvengers() = repository.getAvengers()
            .map { AvengerResponse.from(it) }
            .let { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun getAvengerDetails(@PathVariable("id") id: Long) =
            repository.getDetail(id)
                    .let { ResponseEntity.ok(AvengerResponse.from(it)) }

    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) =
            request.toAvenger().run {
                repository.save(this)
            }.let {
                ResponseEntity.created(URI("${API_PATH}/${it.id}")).body(AvengerResponse.from(it))
            }

    @PutMapping("/{id}")
    fun updateAvenger(@Valid @RequestBody request: AvengerRequest, @PathVariable("id") id: Long) =
            repository.getDetail(id).let {
                AvengerRequest.to(it.id, request).apply {
                    repository.update(this)
                }.let { avenger ->
                    ResponseEntity.ok(AvengerResponse.from(avenger))
                }
            }

    @DeleteMapping("/{id}")
    fun deleteAvenger(@PathVariable("id") id: Long) =
            repository.delete(id).let {
                ResponseEntity.ok()
            }

}