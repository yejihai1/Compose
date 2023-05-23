package com.yjh.compose

import androidx.compose.foundation.background
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
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yjh.main.MainScreen
import com.yjh.mine.MineScreen
import com.yjh.navigation.NavigationScreen
import com.yjh.official.OfficialAccountScreen
import com.yjh.project.ProjectScreen

val title = listOf("主页", "项目", "导航", "公众号", "我的")
val ROUTE_MAIN = "route_main"
val ROUTE_PROJECT = "route_project"
val ROUTE_NAVIGATION = "route_navigation"
val ROUTE_OFFICIAL = "route_official"
val ROUTE_MINE = "route_mine"


//@Composable
//fun Navigation(modifier: Modifier) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = ROUTE_MAIN, modifier) {
//        composable(ROUTE_MAIN) {
//            MainScreen()
//        }
//
//        composable(ROUTE_PROJECT) {
//            ProjectScreen()
//        }
//
//        composable(ROUTE_NAVIGATION) {
//            NavigationScreen()
//        }
//
//        composable(ROUTE_OFFICIAL) {
//            OfficialAccountScreen()
//        }
//
//        composable(ROUTE_MINE) {
//            MineScreen()
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    val curIndex = remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = HomeScreenBottom(title, curIndex)
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)
        when (curIndex.value) {
            0 -> {
                MainScreen()
            }

            1 -> {
                ProjectScreen()
            }

            2 -> {
                NavigationScreen()
            }

            3 -> {
                OfficialAccountScreen()
            }

            4 -> {
                MineScreen()
            }

        }
//        Navigation(Modifier.padding(paddingValues))
    }

}

@Composable
fun HomeScreenBottom(
    title: List<String>,
    curIndex: MutableState<Int>
): @Composable () -> Unit = {
    NavigationBar(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        title.forEachIndexed { index, name ->
            NavigationBarItem(
                selected = curIndex.value == index,
                icon = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = name)
                    }
                },
                onClick = {
                    curIndex.value = index
                })
        }
    }
}

