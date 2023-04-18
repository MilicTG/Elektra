package com.delminiusdevs.elektra.domain.use_cases.outages_use_cases

import com.delminiusdevs.elektra.domain.repository.PowerOutagesRepository

class GetAllPowerOutagesUseCase(
    private val powerOutagesRepository: PowerOutagesRepository,
) {
    suspend operator fun invoke(date: String, dateCode: String) =
        powerOutagesRepository.getPowerCutDataForSpecificDate(date = date, dateCode = dateCode)
}