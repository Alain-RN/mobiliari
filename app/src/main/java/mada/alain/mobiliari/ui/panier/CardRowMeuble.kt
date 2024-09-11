package mada.alain.mobiliari.ui.panier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Furniture(
    val imageResId: Int,
    val name: String,
    val price: String
)
@Composable
fun CardRowMeubleTrash(
    furniturePanier: Furniture,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable {
            }
            .padding(horizontal = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = MaterialTheme.shapes.medium
            )
            .background(Color(0xFFF9F9FB))
            .height(140.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp)), // Coins arrondis,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = furniturePanier.imageResId),
                contentDescription = furniturePanier.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(110.dp)
                    .fillMaxHeight() // Taille fixe pour l'image
                    .clip(RoundedCornerShape(6.dp)) // Coins arrondis

            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(
                modifier = Modifier
                    .weight(1f) // Prend le reste de l'espace disponible
                    .fillMaxHeight()
            ) {
                Text(
                    text = furniturePanier.name,
                    fontSize = 16.sp,
                    color = Color(0xFF3A496C)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = furniturePanier.price,
                    fontSize = 16.sp,
                    color = Color(0xFF4A4A4A),
                    fontWeight = FontWeight.Bold
                )
            }
            // suppr de l'enregistrement
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(alignment = Alignment.Top)
                    .padding(top = 2.dp, end = 4.dp)
                    .size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Supprimer",
                    tint = Color(0xFF6E5EAC)
                )
            }
        }
    }
}