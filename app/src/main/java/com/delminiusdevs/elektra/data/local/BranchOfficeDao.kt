package com.delminiusdevs.elektra.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delminiusdevs.elektra.data.model.BranchOfficeDto
import com.delminiusdevs.elektra.domain.model.BranchOffice

@Dao
interface BranchOfficeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBranchOfficeInDatabase(branchOffice: BranchOfficeDto)

    @Query(value = "SELECT * FROM branch_offices")
    suspend fun getAllSavedBranchOffices(): List<BranchOffice>

}