package com.example.take_home_apt.presentation.screens.search

import com.example.take_home_apt.data.models.ShippingItems
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val searchItems: Flow<List<ShippingItems>>? = null
)