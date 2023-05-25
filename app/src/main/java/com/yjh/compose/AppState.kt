package com.yjh.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.core.os.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.yjh.compose.navigation.TopLevelDestination
import com.yjh.main.navaition.forMainNavigationRoute
import com.yjh.main.navaition.navigateToForMain
import com.yjh.mine.navaition.forMineNavigationRoute
import com.yjh.mine.navaition.navigateToForMine
import com.yjh.navigation.navaition.forNavigationRoute
import com.yjh.navigation.navaition.navigateToForNavigation
import com.yjh.official.navaition.forOfficialAccountNavigationRoute
import com.yjh.official.navaition.navigateToForOfficialAccount
import com.yjh.project.navaition.forProjectNavigationRoute
import com.yjh.project.navaition.navigateToForProject


@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(
        navController
    ) {
        AppState(
            navController
        )
    }
}


@Stable
class AppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination


    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            forMainNavigationRoute -> TopLevelDestination.FOR_MAIN
            forProjectNavigationRoute -> TopLevelDestination.FOR_PROJECT
            forNavigationRoute -> TopLevelDestination.FOR_NAVIGATION
            forOfficialAccountNavigationRoute -> TopLevelDestination.FOR_OFFICIAL_ACCOUNT
            forMineNavigationRoute -> TopLevelDestination.FOR_MINE
            else -> null
        }


    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.FOR_MAIN -> navController.navigateToForMain(
                    topLevelNavOptions
                )

                TopLevelDestination.FOR_PROJECT -> navController.navigateToForProject(
                    topLevelNavOptions
                )

                TopLevelDestination.FOR_NAVIGATION -> navController.navigateToForNavigation(
                    topLevelNavOptions
                )

                TopLevelDestination.FOR_OFFICIAL_ACCOUNT -> navController.navigateToForOfficialAccount(
                    topLevelNavOptions
                )

                TopLevelDestination.FOR_MINE -> navController.navigateToForMine(
                    topLevelNavOptions
                )
            }
        }
    }


}