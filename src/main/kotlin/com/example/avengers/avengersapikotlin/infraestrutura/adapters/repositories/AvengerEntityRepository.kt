package com.example.avengers.avengersapikotlin.infraestrutura.adapters.repositories

import com.example.avengers.avengersapikotlin.infraestrutura.adapters.entities.AvengerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AvengerEntityRepository  : JpaRepository<AvengerEntity, Long>