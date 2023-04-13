package com.delminiusdevs.elektra.domain.model

data class Outages(
    val branchOfficeId: Int,
    val branchOfficeName: String,
    val timeFrom: String,
    val timeTo: String,
    val location: String,
    val id: Int
)
