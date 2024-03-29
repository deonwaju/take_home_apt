package com.example.take_home_apt.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.components.navGraph.Route
import com.example.take_home_apt.presentation.screens.AmountEstimationScreen
import com.example.take_home_apt.presentation.screens.CalculateScreen
import com.example.take_home_apt.presentation.screens.HomeScreen
import com.example.take_home_apt.presentation.screens.search.SearchScreen
import com.example.take_home_apt.presentation.screens.search.SearchViewmodel
import com.example.take_home_apt.presentation.screens.shipment.ShipmentScreen
import com.example.take_home_apt.presentation.screens.shipment.ShipmentViewmodel

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
        backStackState?.destination?.route == Route.HomeScreen.route
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                ShipmentBottomNavigation(
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
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
        ) {
            composable(
                route = Route.HomeScreen.route,
            ) { backStackEntry ->
                HomeScreen(
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    }
                )
            }
            composable(
                route = Route.CalculateScreen.route,
                enterTransition = { -> slideInHorizontally(animationSpec = tween(500)) },
                exitTransition = { -> slideOutHorizontally(animationSpec = tween(500)) }
            ) {
                OnBackClickStateSaver(navController = navController)
                CalculateScreen(
                    onClick = {
                        navController.popBackStack()
                    },
                    navigateToEstimationScreen = {
                        navigateTo(
                            navController = navController,
                            route = Route.AmountEstimationScreen.route,
                        )
                    }
                )
            }
            composable(
                route = Route.ShipmentScreen.route,
                enterTransition = { ->
                    scaleIn(
                        initialScale = 0.5f,
                        animationSpec = tween(500)
                    )
                },
                exitTransition = { -> shrinkOut(animationSpec = tween(500)) }
            ) {
                OnBackClickStateSaver(navController = navController)
                val viewModel: ShipmentViewmodel = hiltViewModel()
                ShipmentScreen(
                    state = viewModel.state,
                    onClick = {
                        navController.popBackStack()
                    },
                )
            }
            composable(
                route = Route.SearchScreen.route,
                enterTransition = {
                    scaleIn(initialScale = 0.5f)
                },
                exitTransition = { ->
                    scaleOut(targetScale = 0.5f)
                }
            ) {
                val viewModel: SearchViewmodel = hiltViewModel()

                OnBackClickStateSaver(navController = navController)
                SearchScreen(
                    searchState = viewModel.state.value,
                    onClick = {
                        navController.popBackStack()
                    },
                    event = viewModel::onEvent,
                )
            }
            composable(
                route = Route.AmountEstimationScreen.route,
                enterTransition = { ->
                    fadeIn(initialAlpha = 0.5f)
                },
                exitTransition = { ->
                    fadeOut(targetAlpha = 0.5f)
                }
            ) {
                OnBackClickStateSaver(navController = navController)
                AmountEstimationScreen(
                    onClick = {
                        navController.popBackStack()
                    }
                )
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


private fun navigateTo(
    navController: NavController,
    route: String,
    key: String? = null,
    data: Any? = null
) {
    navController.currentBackStackEntry?.savedStateHandle?.set(key.toString(), data)
    navController.navigate(route)
}