package com.example.take_home_apt.presentation.components.navGraph

sealed class Route(
    val route: String
) {
    data object HomeScreen: Route(route = "homeScreen")
    data object SearchScreen: Route(route = "searchScreen")
    data object CalculateScreen: Route(route = "calculateScreen")
    data object ShipmentScreen: Route(route = "shipmentScreen")
    data object DetailsScreen: Route(route = "detailsScreen")
    data object AppStartNavigation: Route(route = "appStartNavigation")
    data object ShipmentNavigation: Route(route = "shipmentNavigation")
}