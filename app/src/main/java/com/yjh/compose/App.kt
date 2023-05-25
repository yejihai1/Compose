package com.yjh.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.yjh.compose.navigation.NavigationHost
import com.yjh.compose.navigation.TopLevelDestination

val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App(appState: AppState = rememberAppState()) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = AppBottom(
            topLevelDestinations,
            appState::navigateToTopLevelDestination,
            appState.currentDestination
        )
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)
        NavigationHost(appState.navController)
    }

}

@Composable
fun AppBottom(
    title: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
): @Composable () -> Unit = {
    NavigationBar(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        title.forEach { destination ->

            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            NavigationBarItem(
                selected = selected,
                icon = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = destination.title)
                    }
                },
                onClick = {
                    onNavigateToDestination(destination)
                })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

