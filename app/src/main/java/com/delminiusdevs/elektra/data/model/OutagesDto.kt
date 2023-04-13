package com.delminiusdevs.elektra.data.model

data class OutagesDto(
    val branchOfficeId: Int,
    val branchOfficeName: String,
    val dateFrom: String,
    val dateTo: String,
    val id: Int,
    val location: String
)
