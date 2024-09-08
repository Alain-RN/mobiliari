package mada.alain.mobiliari.ui.connexion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import mada.alain.mobiliari.db.UserViewModel


@Composable
fun LogScreen(
    navController: NavHostController,
    viewModel: UserViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        LogoAndText(Title = "Connectez-vous !")
        textFied(
            icon = Icons.Filled.Email,
            label = "email",
            value = email ,
            keyboardType = KeyboardType.Email
        ) { e ->
           email = e
        }
        textFied(
            icon = Icons.Filled.Lock,
            label = "mot de passe",
            value = password,
            isPassword = true,
            keyboardType = KeyboardType.Password
        ) { e ->
            password = e
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8E59F0),  // Change la couleur de fond
                contentColor = Color.White    // Change la couleur du texte
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            onClick = {
                scope.launch {
                    viewModel.logIn(email = email, password = password)
                }
            }


        ) {
            Text(
                text = "Se connecter",
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        SignOrLog(
            route = "signup",
            text = "Pas encore de compte ? ",
            logOrSign = "Inscrivez-vous",
            navController = navController
        )
    }
}