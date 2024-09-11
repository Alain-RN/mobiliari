package mada.alain.mobiliari

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.db.AppDatabase
import mada.alain.mobiliari.db.MeubleRepository
import mada.alain.mobiliari.db.MeubleViewModel
import mada.alain.mobiliari.db.UserListScreen
import mada.alain.mobiliari.db.UserRepository
import mada.alain.mobiliari.db.UserViewModel
import mada.alain.mobiliari.ui.ajouterFichier.MeubleForm
import mada.alain.mobiliari.ui.app.appScreen
import mada.alain.mobiliari.ui.connexion.LogScreen
import mada.alain.mobiliari.ui.theme.MobiliariTheme
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

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
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                  appScreen(
                      modifier = Modifier,
                      viewModel = meubleViewModel
                  )
//                  MeubleForm(
//                      viewModel = meubleViewModel
//                  )
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

//                  UserListScreen(
//                      viewModel = userViewModel,
//                      viewModel2 = meubleViewModel
//                  )
//                    MeubleForm(
//                        viewModel = meubleViewModel
//                    )
//                  LogScreen(viewModel = userViewModel)

                }
            }
        }
    }
}
