package mada.alain.mobiliari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mada.alain.mobiliari.db.AppDatabase
import mada.alain.mobiliari.db.UserRepository
import mada.alain.mobiliari.db.UserViewModel
import mada.alain.mobiliari.ui.app.appScreen
import mada.alain.mobiliari.ui.theme.MobiliariTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)
        val userDao = db.userDao()
        val userRepository = UserRepository(userDao)
        val userViewModel = UserViewModel(userRepository)

        setContent {
            MobiliariTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                  appScreen(
                      modifier = Modifier,
                      viewModel = userViewModel
                  )
//
//
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "sign") {
//                        composable("sign") {
//                            UserRegistrationScreen(
//                                navController = navController,
//                                viewModel = userViewModel
//                            )
//                        }
//                        composable("log") {
//                            LogScreen(
//                                navController = navController,
//                                viewModel = userViewModel
//                            )
//                        }
//                    }


//                  UserRegistrationScreen(viewModel = userViewModel)
//                  UserListScreen(viewModel = userViewModel)
//                  LogScreen(viewModel = userViewModel)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiliariTheme {
        appScreen(modifier = Modifier)
    }
}