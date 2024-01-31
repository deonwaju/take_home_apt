package com.example.take_home_apt.presentation.screens.search

import com.example.take_home_apt.data.models.ShippingItems

data class SearchState(
    val searchQuery: String = "",
    val searchItems: List<ShippingItems> = emptyList(),
)