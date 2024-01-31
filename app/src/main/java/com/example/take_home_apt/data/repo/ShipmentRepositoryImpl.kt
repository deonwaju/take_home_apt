package com.example.take_home_apt.data.repo

import com.example.take_home_apt.data.models.ShipmentHistory
import com.example.take_home_apt.data.models.shipmentHistoryData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ShipmentRepositoryImpl: IShipmentRepository {
    override fun getShipmentData(): Flow<List<ShipmentHistory>> = flow{
        emit(shipmentHistoryData())
    }
}