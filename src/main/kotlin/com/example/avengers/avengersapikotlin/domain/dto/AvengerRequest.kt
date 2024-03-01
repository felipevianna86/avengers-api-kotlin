package com.example.avengers.avengersapikotlin.domain.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvengerRequest(
        @field:NotNull
        @field:NotBlank
        @field:NotEmpty
        var nickname: String,
        @field:NotNull
        @field:NotBlank
        @field:NotEmpty
        var person: String,
        var description: String? = "",
        var history: String? = ""
)
