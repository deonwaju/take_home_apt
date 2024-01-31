package com.example.take_home_apt.data.repo

import com.example.take_home_apt.data.models.ShipmentHistory
import kotlinx.coroutines.flow.Flow

interface IShipmentRepository {

    fun getShipmentData(): Flow<List<ShipmentHistory>>
}