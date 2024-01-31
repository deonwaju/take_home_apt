package com.example.take_home_apt.presentation.screens.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.take_home_apt.data.repo.ISearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewmodel @Inject constructor(
    private val searchRepository: ISearchRepository
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    init {
        getSearchData()
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchShipmentData -> {
                searchShipmentData()
            }
        }
    }

    private fun getSearchData() {
        viewModelScope.launch {
            searchRepository.getSearchData().collect { data ->
                _state.value = state.value.copy(searchItems = data)
            }
        }
    }

    private fun searchShipmentData() {
        viewModelScope.launch {
            searchRepository.searchShipmentData(query = _state.value.searchQuery).collect { data ->
                _state.value = _state.value.copy(searchItems = data)
            }
        }
    }
}