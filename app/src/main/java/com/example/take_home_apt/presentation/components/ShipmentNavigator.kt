package com.example.take_home_apt.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.components.navGraph.Route
import com.example.take_home_apt.presentation.home.CalculateScreen
import com.example.take_home_apt.presentation.home.HomeScreen
import com.example.take_home_apt.presentation.home.ShipmentScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShipmentNavigator() {
    val bottomNavigationItem = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_calculate, text = "Calculate"),
            BottomNavigationItem(icon = R.drawable.ic_loading, text = "Shipment"),
            BottomNavigationItem(icon = R.drawable.ic_profile, text = "Profile")
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.CalculateScreen.route -> 1
        Route.ShipmentScreen.route -> 2
        else -> 0
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.CalculateScreen.route ||
                backStackState?.destination?.route == Route.ShipmentScreen.route
    }


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            NewsBottomNavigation(
                items = bottomNavigationItem,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.CalculateScreen.route
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.ShipmentScreen.route
                        )
                        3 -> println("Coming soon...")
                    }
                }
            )
        }
    }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) { backStackEntry ->
                HomeScreen(
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    }
                )
            }
            composable(route = Route.CalculateScreen.route) {
                OnBackClickStateSaver(navController = navController)
                CalculateScreen()
            }
            composable(route = Route.ShipmentScreen.route) {
                OnBackClickStateSaver(navController = navController)
                ShipmentScreen()
            }
        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

//private fun navigateToDetails(navController: NavController, article: Article) {
//    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
//    navController.navigate(
//        route = Route.DetailsScreen.route
//    )
//}