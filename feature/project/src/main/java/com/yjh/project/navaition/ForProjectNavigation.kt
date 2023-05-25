package com.yjh.project.navaition

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yjh.project.ProjectScreen


const val forProjectNavigationRoute = "for_project_route"


fun NavController.navigateToForProject(navOptions: NavOptions? = null) {
    this.navigate(forProjectNavigationRoute, navOptions)
}

fun NavGraphBuilder.forProjectScreen() {
    composable(
        route = forProjectNavigationRoute
    ) {
        ProjectScreen()
    }
}