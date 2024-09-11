package mada.alain.mobiliari.ui.panier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mada.alain.mobiliari.R

@Composable
fun PanierScreen(
    navController: NavHostController,
) {
    val meubles = listOf(
        Furniture(R.drawable.table, "Alainfgj  fgj", "200"),
        Furniture(R.drawable.horloge, "Alajfgjf fjin", "200"),
        Furniture(R.drawable.table, "Ala cfgfin", "200"),
        Furniture(R.drawable.table, "Alan", "200"),
        Furniture(R.drawable.horloge, "Alai  gfjfn", "200")
    )

    Column {
        Box(
            modifier = Modifier
                .height(68.dp)
                .fillMaxWidth()
                .background(Color(0xFFDDE6F2))
                .padding(horizontal = 2.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Bouton de retour
                IconButton(onClick = {
                    navController.navigate("home")
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Retour",
                        tint = Color(0xFF6E5EAC),
                        modifier = Modifier.size(30.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.mobiliari2), // Remplacez par votre logo
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(start = 74.dp)
                        .width(140.dp) // Ajuste la taille du logo

                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
                .padding(horizontal = 8.dp)
        ) {
            LazyColumn {

                items(meubles) { item ->
                    CardRowMeubleTrash(furniturePanier = item)
                    Spacer(modifier = Modifier.height(4.dp))
                }

            }
        }
    }
}

//@Preview
//@Composable
//fun prev() {
//    PanierScreen()
//}
