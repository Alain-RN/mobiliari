package mada.alain.mobiliari.ui.saved

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.R


data class Furniture(
    val imageResId: Int,
    val name: String,
    val price: String
)


@Composable
fun RowMeubleCard(furniture: Furniture, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = furniture.imageResId),
                contentDescription = furniture.name,
                modifier = Modifier
                    .size(100.dp) // Taille fixe pour l'image
                    .padding(end = 16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f) // Prend le reste de l'espace disponible
                    .fillMaxHeight()
            ) {
                Text(
                    text = furniture.name,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = furniture.price,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFurnitureCard() {
    RowMeubleCard(
        furniture = Furniture(
            imageResId = R.drawable.horloge,
            name = "Chair",
            price = "$49.99"
        )
    )
}
