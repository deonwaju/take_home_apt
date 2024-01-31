package com.example.take_home_apt.data.repo

import com.example.take_home_apt.data.models.ShippingItems
import com.example.take_home_apt.data.models.searchItemData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl: ISearchRepository {
    override fun getSearchData(): Flow<List<ShippingItems>> = flow {
        emit(searchItemData())
    }

    override fun searchShipmentData(query: String): Flow<List<ShippingItems>> = flow{
        val searchData = searchItemData().takeIf { query.isNotEmpty() }
            ?.filter { it.name.contains(query, ignoreCase = true) }
            ?: searchItemData()
        emit(searchData)
    }
}