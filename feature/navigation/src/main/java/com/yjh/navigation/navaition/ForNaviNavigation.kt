package com.yjh.navigation.navaition

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yjh.navigation.NavigationScreen


const val forNavigationRoute = "for_navigation_route"


fun NavController.navigateToForNavigation(navOptions: NavOptions? = null) {
    this.navigate(forNavigationRoute, navOptions)
}

fun NavGraphBuilder.forNavigationScreen() {
    composable(
        route = forNavigationRoute
    ) {
        NavigationScreen()
    }
}