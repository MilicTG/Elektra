package com.delminiusdevs.elektra.data.mappers

import com.delminiusdevs.elektra.data.model.OutagesDto
import com.delminiusdevs.elektra.domain.model.Outages
import com.delminiusdevs.elektra.util.getDayFromDateString

fun OutagesDto.toOutages(): Outages {
    return Outages(
        branchOfficeId = branchOfficeId,
        branchOfficeName = branchOfficeName,
        timeFrom = getDayFromDateString(dateFrom),
        timeTo = getDayFromDateString(dateTo),
        id = id,
        location = location
    )
}