package com.delminiusdevs.elektra.presentation.screens.outages

import com.delminiusdevs.elektra.domain.model.Outages

data class OutagesState(
    val firstDayOutages: List<Outages> = emptyList(),
    val secondDayOutages: List<Outages> = emptyList(),
    val thirdDayOutages: List<Outages> = emptyList(),
    val outagesComplete: List<Outages> = emptyList(),
    val errorMessage: String = "Dogodila je se greška!",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
