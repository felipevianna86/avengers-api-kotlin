package com.example.avengers.avengersapikotlin.domain

data class Avenger(
        var id: Long? = null,
        var nickname: String,
        var person: String,
        var description: String?,
        var history: String?
)
