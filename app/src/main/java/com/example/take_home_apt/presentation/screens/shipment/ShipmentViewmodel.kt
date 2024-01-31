package com.example.take_home_apt.presentation.screens.shipment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.take_home_apt.data.repo.IShipmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipmentViewmodel @Inject constructor(
    private var shipmentRepo: IShipmentRepository
) : ViewModel() {

    var state by mutableStateOf(ShipmentState())

    init {
        getShipmentData()
    }

    private fun getShipmentData() {
        viewModelScope.launch {
            shipmentRepo.getShipmentData().collect { data ->
                state = state.copy(shipmentHistory = data)
            }
        }
    }

}