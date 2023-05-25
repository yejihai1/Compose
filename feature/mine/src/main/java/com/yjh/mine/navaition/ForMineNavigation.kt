package com.yjh.mine.navaition

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yjh.mine.MineScreen


const val forMineNavigationRoute = "for_mine_route"


fun NavController.navigateToForMine(navOptions: NavOptions? = null) {
    this.navigate(forMineNavigationRoute, navOptions)
}

fun NavGraphBuilder.forMineScreen() {
    composable(
        route = forMineNavigationRoute
    ) {
        MineScreen()
    }
}