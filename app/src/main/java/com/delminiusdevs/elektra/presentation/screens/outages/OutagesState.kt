package com.delminiusdevs.elektra.presentation.screens.outages

import com.delminiusdevs.elektra.domain.model.Outages

data class OutagesState(
    val firstDayOutages: List<Outages> = emptyList(),
    val secondDayOutages: List<Outages> = emptyList(),
    val thirdDayOutages: List<Outages> = emptyList(),
    val firstDayDate: String = "",
    val secondDayDate: String = "",
    val thirdDayDate: String = "",
    val errorMessage: String = "Dogodila je se greška!",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
