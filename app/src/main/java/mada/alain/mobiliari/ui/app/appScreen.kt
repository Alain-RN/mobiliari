package mada.alain.mobiliari.ui.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.lifecycle.viewmodel.compose.viewModel
import mada.alain.mobiliari.db.UserViewModel
import mada.alain.mobiliari.ui.connexion.connexionScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun appScreen(
    modifier: Modifier,
    viewModel: UserViewModel = viewModel()
) {
    val bg = 0xFFF5F3FF
    Surface(
        color = Color(bg),
        modifier = Modifier
            .fillMaxSize()
    ) {
        connexionScreen(
            viewModel = viewModel
        )
//        val navController = rememberNavController()
//
//        Scaffold(
//            bottomBar = { BottomNavigationBar(navController) } // Barre de navigation en bas
//        ) { innerPadding ->
//            NavHost(
//                navController = navController,
//                startDestination = "Log", // Page de démarrage
//                modifier = Modifier.padding(innerPadding)
//            ) {
//                composable("home") { HomeScreen()}
//                composable("search") { SearchScreen() }
//                composable("profile") { ProfileScreen() }
//            }
//        }
        //Simulation chargement(A venir)
    }

}