package com.example.avengers.avengersapikotlin.domain.dto

import com.example.avengers.avengersapikotlin.domain.Avenger

data class AvengerResponse(
        var id: Long?,
        var nickname: String,
        var person: String,
        var description: String?,
        var history: String?
){
    companion object{
        fun from(avenger: Avenger) = AvengerResponse(
                id = avenger.id,
                nickname = avenger.nickname,
                person = avenger.person,
                description = avenger.description,
                history = avenger.history
        )
    }
}
