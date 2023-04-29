package com.delminiusdevs.elektra.presentation.screens.outages

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminiusdevs.elektra.domain.use_cases.outages_use_cases.OutagesUseCases
import com.delminiusdevs.elektra.util.Resource
import com.delminiusdevs.elektra.util.getDateOrDayForSpecificDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OutagesViewModel @Inject constructor(
    private val outagesUseCases: OutagesUseCases,
) : ViewModel() {

    var state by mutableStateOf(OutagesState())

    init {
        getOutagesForThreeDays()
    }

    fun onEvent(event: OutagesEvent) {
        when (event) {
            OutagesEvent.OnRefreshTap -> {
                getOutagesForThreeDays()
            }
        }
    }

    private fun getOutagesForThreeDays() {
        viewModelScope.launch {
            val firstDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "firstDate"),
                dateCode = "firstDate"
            )

            val secondDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "secondDate"),
                dateCode = "secondDate"
            )

            val thirdDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "thirdDate"),
                dateCode = "thirdDate"
            )

            firstDayResponse.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { outages ->
                            state = state.copy(
                                firstDayOutages = outages,
                            )
                        }
                    }

                    is Resource.Error -> {
                        result.message?.let { message ->
                            state = state.copy(
                                errorMessage = message,
                                isError = true,
                            )
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }

            delay(500)

            secondDayResponse.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { outages ->
                            state = state.copy(
                                secondDayOutages = outages,
                            )
                        }
                    }

                    is Resource.Error -> {
                        result.message?.let { message ->
                            state = state.copy(
                                errorMessage = message,
                                isError = true
                            )
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }

            delay(500)

            thirdDayResponse.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { outages ->
                            state = state.copy(
                                thirdDayOutages = outages,
                            )
                        }
                        completeTheOutagesList()
                    }

                    is Resource.Error -> {
                        result.message?.let { message ->
                            state = state.copy(
                                errorMessage = message,
                                isError = true
                            )
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = result.isLoading
                        )
                    }
                }
            }
        }
    }

    private fun completeTheOutagesList() {
        state = state.copy(
            outagesComplete = emptyList()
        )

        state = state.copy(
            outagesComplete = state.firstDayOutages + state.secondDayOutages + state.thirdDayOutages
        )
    }
}