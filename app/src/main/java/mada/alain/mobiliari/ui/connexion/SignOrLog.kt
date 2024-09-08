package mada.alain.mobiliari.ui.connexion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SignOrLog(
    route : String,
    text : String,
    logOrSign:String,
    navController: NavHostController
) {
    Column {

        OrSeparator()

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
        ){
            Text(
                text = text,
                color = Color.Black,
                fontSize = 14.sp
            )
            Text(
                text = logOrSign+" ici",
                color = Color(0xFF8E59F0),
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navController.navigate(route)
                },
            )
        }
    }
}