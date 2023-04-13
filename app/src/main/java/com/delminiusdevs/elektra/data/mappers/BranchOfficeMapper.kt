package com.delminiusdevs.elektra.data.mappers

import com.delminiusdevs.elektra.data.model.BranchOfficeDto
import com.delminiusdevs.elektra.domain.model.BranchOffice

fun BranchOfficeDto.toBranchOffice(): BranchOffice {
    return BranchOffice(
        id = id,
        name = name
    )
}