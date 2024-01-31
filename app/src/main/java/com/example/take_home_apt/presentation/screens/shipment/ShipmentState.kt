package com.example.take_home_apt.presentation.screens.shipment

import com.example.take_home_apt.data.models.ShipmentHistory

data class ShipmentState(
    val shipmentHistory: List<ShipmentHistory> = emptyList()
)
