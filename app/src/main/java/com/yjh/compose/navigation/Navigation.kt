package com.yjh.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.yjh.main.navaition.forMainNavigationRoute
import com.yjh.main.navaition.forMainScreen
import com.yjh.mine.navaition.forMineScreen
import com.yjh.navigation.navaition.forNavigationScreen
import com.yjh.official.navaition.forOfficialAccountScreen
import com.yjh.project.navaition.forProjectScreen


@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, forMainNavigationRoute) {
        forMainScreen()
        forMineScreen()
        forOfficialAccountScreen()
        forProjectScreen()
        forNavigationScreen()
    }
}