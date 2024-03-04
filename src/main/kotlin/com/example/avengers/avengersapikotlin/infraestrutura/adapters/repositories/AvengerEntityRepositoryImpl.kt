package com.example.avengers.avengersapikotlin.infraestrutura.adapters.repositories

import com.example.avengers.avengersapikotlin.domain.Avenger
import com.example.avengers.avengersapikotlin.domain.ports.repositories.AvengerRepository
import com.example.avengers.avengersapikotlin.infraestrutura.adapters.entities.AvengerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerEntityRepositoryImpl(
        @Autowired private val avengerEntityRepository: AvengerEntityRepository
) : AvengerRepository{

    override fun getDetail(id: Long): Avenger? =
            avengerEntityRepository.findByIdOrNull(id)?.toAvenger()

    override fun getAvengers(): List<Avenger> =
            avengerEntityRepository.findAll().map { it.toAvenger() }

    override fun save(avenger: Avenger): Avenger =
            avengerEntityRepository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun delete(id: Long) =
            avengerEntityRepository.deleteById(id)

    override fun update(avenger: Avenger): Avenger =
            avengerEntityRepository.save(AvengerEntity.from(avenger)).toAvenger()
}