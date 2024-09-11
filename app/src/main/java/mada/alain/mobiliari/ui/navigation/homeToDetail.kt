package mada.alain.mobiliari.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mada.alain.mobiliari.ui.details.FurnitureDetailScreen
import mada.alain.mobiliari.ui.home.HomeScreen

//@Composable
//fun HomeDetailNavHost() {
//    val navControllerHomeDetail = rememberNavController()
//
//    NavHost(navController = navControllerHomeDetail, startDestination = "home") {
//        composable("list") { HomeScreen(navControllerHomeToDetail = navControllerHomeDetail) }
//        composable("detail/{meubleId}") {
//            FurnitureDetailScreen(
//                navControllerHomeToDetail = navControllerHomeDetail,
//                meubleId = it.arguments?.getString("meubleId")
//            )
//        }
//    }
//}