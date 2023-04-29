package com.delminiusdevs.elektra.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "branch_offices")
data class BranchOfficeDto(
    @PrimaryKey
    val id: Int,
    val name: String
)
