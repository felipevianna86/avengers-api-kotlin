package com.example.avengers.avengersapikotlin.domain.ports.repositories

import com.example.avengers.avengersapikotlin.domain.Avenger

interface AvengerRepository {
    fun getDetail(id: Long): Avenger
    fun getAvengers(): List<Avenger>
    fun save(avenger: Avenger): Avenger
    fun delete(id: Long)

    fun update(avenger: Avenger): Avenger
}