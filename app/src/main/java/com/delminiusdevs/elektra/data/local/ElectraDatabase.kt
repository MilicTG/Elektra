package com.delminiusdevs.elektra.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delminiusdevs.elektra.data.model.BranchOfficeDto

@Database(
    entities = [
        BranchOfficeDto::class,
    ],
    version = 1
)
abstract class ElectraDatabase : RoomDatabase() {
    abstract val branchOfficeDao: BranchOfficeDao
}