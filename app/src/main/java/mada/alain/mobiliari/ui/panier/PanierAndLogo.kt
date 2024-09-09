package mada.alain.mobiliari.ui.panier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.R

@Composable
fun TopAppBarWithCartAndLogo() {
    TopAppBar(
        modifier = Modifier
            .height(68.dp),
        backgroundColor = Color(0xFFDDE6F2),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Logo de l'application
                Image(
                    painter = painterResource(id = R.drawable.mobiliari2), // Remplace avec ton logo
                    contentDescription = "Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(42.dp)
                        .padding(start = 4.dp)
                )

                // Titre ou autre texte
                // Bouton panier
                IconButton(onClick = {
                    // Action quand on clique sur le panier
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.cart), // Remplace avec ton icône de panier
                        contentDescription = "Panier",
                        modifier = Modifier.size(28.dp),
                        tint = Color(0xFF6E5EAC),
                    )
                }
            }
        }
    )
}