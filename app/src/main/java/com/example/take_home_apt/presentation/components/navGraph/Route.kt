package com.example.take_home_apt.presentation.components.navGraph

sealed class Route(
    val route: String
) {
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object CalculateScreen: Route(route = "calculateScreen")
    object ShipmentScreen: Route(route = "shipmentScreen")
    object DetailsScreen: Route(route = "detailsScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object ShipmentNavigation: Route(route = "shipmentNavigation")
}