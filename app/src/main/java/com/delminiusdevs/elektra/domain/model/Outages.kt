package com.delminiusdevs.elektra.domain.model

data class Outages(
    val branchOfficeId: Int,
    val branchOfficeName: String,
    val dayOfOutage: String?,
    val dateOfOutage: String?,
    val timeFrom: String,
    val timeTo: String,
    val location: String,
    val id: Int
)
