package mada.alain.mobiliari.ui.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mada.alain.mobiliari.db.MeubleViewModel
import mada.alain.mobiliari.db.UserViewModel
import mada.alain.mobiliari.ui.ar.ArScreen
import mada.alain.mobiliari.ui.connexion.connexionScreen
import mada.alain.mobiliari.ui.details.FurnitureDetailScreen
import mada.alain.mobiliari.ui.home.HomeScreen
import mada.alain.mobiliari.ui.panier.TopAppBarWithCartAndLogo
import mada.alain.mobiliari.ui.profile.ProfileScreen
import mada.alain.mobiliari.ui.saved.SavedScreen
import mada.alain.mobiliari.ui.search.SearchScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun appScreen(
    modifier: Modifier,
    viewModel: MeubleViewModel = viewModel()
) {
    val bg = 0xFFF5F3FF
    Surface(
        color = Color(bg),
        modifier = Modifier
            .fillMaxSize()
    ) {

//        connexionScreen(
//            viewModel = viewModel
//        )

        val navController = rememberNavController()

        var showBottomBar by remember { mutableStateOf(true) }
        var showTopBar by remember { mutableStateOf(true) }

        LaunchedEffect(navController) {
            navController.currentBackStackEntryFlow.collect { backStackEntry ->
                showBottomBar = when (backStackEntry.destination.route) {
                    "search" -> false
                    "ar" -> false
                    "detail/{meubleId}" -> false
                    else -> true
                }
            }
        }
        LaunchedEffect(navController) {
            navController.currentBackStackEntryFlow.collect { backStackEntry ->
                showTopBar = when (backStackEntry.destination.route) {
                    "home" -> true
                    "saved" -> true
                    else -> false
                }
            }
        }

        Scaffold(
            modifier = Modifier,
            topBar = {
                if(showTopBar){
                    TopAppBarWithCartAndLogo()
                }
            },
            bottomBar = {
                if(showBottomBar) {
                    BottomNavigationBar(navController=navController)
                }
            }// Barre de navigation en bas
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home", // Page de démarrage
                modifier = Modifier
                    .padding(innerPadding)
                    .background(color = Color(0xFFF5F3FF)),
            ) {
                composable("home") {
                    HomeScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable("detail/{meubleId}") {
                    FurnitureDetailScreen(
                        navController = navController,
                        viewModel = viewModel,
                        meubleId = it.arguments?.getString("meubleId")
                    )
                }
                composable("saved") {
                    SavedScreen()
                }
                composable("ar") {
                    ArScreen( navController = navController )
                }
                composable("search") {
                    SearchScreen( navController = navController )
                }
                composable("profile") {
                    ProfileScreen()
                }
            }
        }
//        Simulation chargement(A venir)
    }

}