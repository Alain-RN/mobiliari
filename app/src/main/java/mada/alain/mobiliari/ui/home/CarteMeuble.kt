package mada.alain.mobiliari.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mada.alain.mobiliari.R

@Composable
fun SmallFurnitureCard(
    nomMeuble: String,
    prixMeuble: String,
    imageMeuble: Int,
//    navController: NavController, // Navigation Controller
    onClickDetail: () -> Unit // Action on click
) {
    val a = ImageBitmap.imageResource(id = imageMeuble)

    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = Modifier

            .clickable {
                onClickDetail()
            }

            .width(182.dp) // Largeur fixe pour les cartes
            .wrapContentHeight() // Hauteur s'adapte au contenu
            .padding(1.dp),
        shape = RoundedCornerShape(8.dp),
    ) {

        Column(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFE0E0E0),
                    shape = MaterialTheme.shapes.medium
                )
                .background(Color(0xFFF9F9FB))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageMeuble),
                contentDescription = null,
                modifier = Modifier
                    .height((a.height/4.5).dp)
                     // L'image occupe toute la largeur de la carte
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = nomMeuble,
                color = Color(0xFF3A496C)
//                modifier = Modifier.padding(horizontal = 4.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = prixMeuble,
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A),
                fontWeight = FontWeight.Bold

//                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//@OptIn(ExperimentalLayoutApi::class)
//@Preview(showBackground = true)
//@Composable
//fun SmallFurnitureCardPreview() {
//    FlowRow(
//        Modifier.fillMaxSize()
//    ){
//        Column {
//            SmallFurnitureCard(
//                "Table B", "$150", R.drawable.table,
//                // Remplacer par une image
//            ){}
//            SmallFurnitureCard(
//                "Table A", "$50", R.drawable.horloge,
//                // Remplacer par une image
//            )
//        }
//        Column {
//            SmallFurnitureCard(
//                "Table A", "$50", R.drawable.horloge,
//                // Remplacer par une image
//            )
//            SmallFurnitureCard(
//                "Table A", "$50", R.drawable.table,
//                // Remplacer par une image
//            )
//        }
//    }
//
//}