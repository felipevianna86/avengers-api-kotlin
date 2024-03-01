package com.example.avengers.avengersapikotlin.domain.dto

import com.example.avengers.avengersapikotlin.domain.Avenger
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
){
        fun toAvenger() = Avenger(
                nickname = nickname,
                person = person,
                description = description,
                history = history
        )

        companion object{
                fun to(id: Long?, request: AvengerRequest) = Avenger(
                        id = id,
                        nickname = request.nickname,
                        person = request.person,
                        description = request.description,
                        history = request.history
                )
        }
}
