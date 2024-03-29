package com.example.take_home_apt.presentation.screens.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    data object SearchShipmentData: SearchEvent()
}