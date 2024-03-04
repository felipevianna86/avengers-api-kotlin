package com.example.avengers.avengersapikotlin.infraestrutura.adapters.entities

import com.example.avengers.avengersapikotlin.domain.Avenger
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class AvengerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(nullable = false)
        val nickname: String,
        @Column(nullable = false)
        val person: String,
        val description: String?,
        val history: String?
){
    fun toAvenger() = Avenger(id, nickname, person, description, history)

    companion object {
        fun from(avenger: Avenger) = AvengerEntity(
                id = avenger.id,
                nickname = avenger.nickname,
                person = avenger.person,
                description = avenger.description,
                history = avenger.history
        )
    }
}
