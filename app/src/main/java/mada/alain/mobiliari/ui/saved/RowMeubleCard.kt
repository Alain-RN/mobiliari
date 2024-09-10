package mada.alain.mobiliari.ui.saved

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
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mada.alain.mobiliari.R


data class Furniture(
    val imageResId: Int,
    val name: String,
    val price: String
)

@Composable
fun RowMeubleCard(
    furniture: Furniture,
    modifier: Modifier = Modifier,
    onClickDetail : (String) -> Unit
    ) {
    Card(
        modifier = modifier
            .clickable {
                onClickDetail(furniture.name)
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
                painter = painterResource(id = furniture.imageResId),
                contentDescription = furniture.name,
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
                    text = furniture.name,
                    fontSize = 16.sp,
                    color = Color(0xFF3A496C)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = furniture.price,
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
                    .size(18.dp)
            ) {
              Image(
                  painter = painterResource(id = R.drawable.close),
                  contentDescription = "close")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewFurnitureCard() {
//    Column {
//        RowMeubleCard(
//            furniture = Furniture(
//                imageResId = R.drawable.horloge,
//                name = "Chair",
//                price = "$49.99"
//            )
//        )
//        RowMeubleCard(
//            furniture = Furniture(
//                imageResId = R.drawable.horloge,
//                name = "Chair",
//                price = "$49.99"
//            )
//        )
//        RowMeubleCard(
//            furniture = Furniture(
//                imageResId = R.drawable.table,
//                name = "Chair",
//                price = "$49.99"
//            )
//        )
//    }
//
//}
