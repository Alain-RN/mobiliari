package mada.alain.mobiliari.ui.connexion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mada.alain.mobiliari.db.UserViewModel

@Composable
fun connexionScreen(
    viewModel: UserViewModel = viewModel()
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LogScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("signup") {
            SignScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    connexionScreen()
//}