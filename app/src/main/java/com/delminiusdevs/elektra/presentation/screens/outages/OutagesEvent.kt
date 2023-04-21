package com.delminiusdevs.elektra.presentation.screens.outages

sealed class OutagesEvent {
    object OnRefreshTap : OutagesEvent()
}