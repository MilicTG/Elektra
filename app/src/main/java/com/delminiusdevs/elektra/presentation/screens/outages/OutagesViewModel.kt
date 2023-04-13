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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OutagesViewModel @Inject constructor(
    private val outagesUseCases: OutagesUseCases
): ViewModel() {
    var state by mutableStateOf(OutagesState())


    init {
        getDatesForThreeDays()
        getOutagesForThreeDays()
    }

    private fun getOutagesForThreeDays() {
        viewModelScope.launch {
            val firstDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "firstDate")
            )

            val secondDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "secondDate")
            )

            val thirdDayResponse = outagesUseCases.getAllPowerOutagesUseCase(
                date = getDateOrDayForSpecificDay(day = "thirdDate")
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
                            isLoading = result.isLoading
                        )
                    }
                }
            }

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
                            isLoading = result.isLoading
                        )
                    }
                }
            }

            thirdDayResponse.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { outages ->
                            state = state.copy(
                                thirdDayOutages = outages
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
                            isLoading = result.isLoading
                        )
                    }
                }
            }
        }
    }

    private fun getDatesForThreeDays() {
        state = state.copy(
            firstDayDate = getDateOrDayForSpecificDay(day = "firstDate"),
            secondDayDate = getDateOrDayForSpecificDay(day = "secondDate"),
            thirdDayDate = getDateOrDayForSpecificDay(day = "thirdDate")
        )
    }

    private fun resetState() {
        state = state.copy(
            firstDayOutages = emptyList(),
            secondDayOutages = emptyList(),
            thirdDayOutages = emptyList(),
            isLoading = false,
            isError = false
        )
    }

}