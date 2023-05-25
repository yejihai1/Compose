package com.yjh.official.navaition

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yjh.official.OfficialAccountScreen


const val forOfficialAccountNavigationRoute = "for_official_account_route"


fun NavController.navigateToForOfficialAccount(navOptions: NavOptions? = null) {
    this.navigate(forOfficialAccountNavigationRoute, navOptions)
}

fun NavGraphBuilder.forOfficialAccountScreen() {
    composable(
        route = forOfficialAccountNavigationRoute
    ) {
        OfficialAccountScreen()
    }
}