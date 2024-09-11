package mada.alain.mobiliari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import mada.alain.mobiliari.db.AppDatabase
import mada.alain.mobiliari.db.MeubleRepository
import mada.alain.mobiliari.db.MeubleViewModel
import mada.alain.mobiliari.db.UserRepository
import mada.alain.mobiliari.db.UserViewModel
import mada.alain.mobiliari.ui.ar.ArScreen
import mada.alain.mobiliari.ui.theme.MobiliariTheme
//import io.github.sceneview.sample.SceneviewTheme

private const val kModelFile = "models/damaged_helmet.glb"
private const val kMaxModelInstances = 10

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)

        val userDao = db.userDao()
        val userRepository = UserRepository(userDao)
        val userViewModel = UserViewModel(userRepository)

        val meubleDao = db.meubleDao()
        val meubleRepository = MeubleRepository(meubleDao)
        val meubleViewModel = MeubleViewModel(meubleRepository)

        setContent {
            MobiliariTheme {

                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    appScreen(
                        modifier = Modifier,
                        viewModel = meubleViewModel
                    )
                }



//                  MeubleForm(
//                      viewModel = meubleViewModel
//                  )


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

//                  UserListScreen(
//                      viewModel = userViewModel,
//                      viewModel2 = meubleViewModel
//               )
//                ArScreen()

//                    navController = navC
//                    MeubleForm(
//                        viewModel = meubleViewModel
//                    )
//                  LogScreen(viewModel = userViewModel)

            }
        }
    }
}
