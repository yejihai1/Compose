package com.yjh.main.navaition

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yjh.main.MainScreen

const val forMainNavigationRoute = "for_main_route"


fun NavController.navigateToForMain(navOptions: NavOptions? = null) {
    this.navigate(forMainNavigationRoute, navOptions)
}

fun NavGraphBuilder.forMainScreen() {
    composable(
        route = forMainNavigationRoute
    ) {
        MainScreen()
    }
}