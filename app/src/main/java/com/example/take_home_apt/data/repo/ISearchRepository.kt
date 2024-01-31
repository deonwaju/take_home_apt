package com.example.take_home_apt.data.repo

import com.example.take_home_apt.data.models.ShippingItems
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {
    fun getSearchData(): Flow<List<ShippingItems>>
    fun searchShipmentData(query: String): Flow<List<ShippingItems>>
}