package com.example.take_home_apt.data.models

import com.example.take_home_apt.R

fun shipmentHistoryData(): List<ShipmentHistory> {
    // Hardcoded data for demonstration
    val shipmentItems = listOf(
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "completed",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.check_circle_24px,
            R.color.green,
            R.color.green
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "In progress",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "loading",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.lightBlue,
            R.color.lightBlue
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
        ShipmentHistory(
            "pending",
            "$1400 USD",
            "Sep 20, 2024",
            R.drawable.ic_loading,
            R.color.orange,
            R.color.orange
        ),
    )
    return shipmentItems
}

fun searchItemData(): List<ShippingItems> {
    // Hardcoded data for demonstration
    val data = listOf(
        ShippingItems(
            name = "Macbook pro M2",
            code = "#NE43857340857904",
            cityFrom = "Paris",
            cityTo = "Morocco",
            icon = R.drawable.box_crop
        ),
        ShippingItems(
            "Summer linen jacket",
            "#NE20089934122231",
            "Barcelona",
            "Paris",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Tapered fit jeans AW",
            "#NE438343340857904",
            "Colombia",
            "Paris",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Slim fit jeans AW",
            "#NE848467357904",
            "Bogota",
            "Dhaka",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Office setup desk",
            "#NEHJKD57340857904",
            "Dubai",
            "Dublin",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Macbook air M2",
            "#NE4334GHJD40857904",
            "Lagos",
            "Accra",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Dell Alien ware",
            "#NE43857340857904",
            "Bali",
            "Seychelles",
            R.drawable.box_crop
        ),
        ShippingItems(
            "Hp Elite book",
            "#NE43857340857904",
            "Paris",
            "Morocco",
            R.drawable.box_crop
        )
    )
    return data
}

val availableVehicles = listOf(
    AvailableVehicle("Ocean freight", "International", R.drawable.ship),
    AvailableVehicle("Cargo freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Air freight", "International", R.drawable.ship),
    AvailableVehicle("Road freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Ocean freight", "International", R.drawable.ship),
    AvailableVehicle("Cargo freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Air freight", "International", R.drawable.ship),
    AvailableVehicle("Road freight", "Reliable", R.drawable.trailer)
)
