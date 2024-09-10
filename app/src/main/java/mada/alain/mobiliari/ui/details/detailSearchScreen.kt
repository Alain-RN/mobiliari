package mada.alain.mobiliari.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ViewInAr
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mada.alain.mobiliari.R

@Composable
fun FurnitureDetailScreen(
    furnitureName: String,
    furniturePrice: String,
    furnitureDescription: String,
    furnitureHeight: String, // Hauteur du meuble
    furnitureWidth: String, // Largeur
    furnitureImageRes: Int,  // Image resource ID
    onAddToCartClick: () -> Unit,
    onSaveClick: () -> Unit,
    onARClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image du meuble
        Image(
            painter = painterResource(id = furnitureImageRes),
            contentDescription = "Furniture Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Détails du meuble (nom et description)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = furnitureName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "By Sotu",
                fontSize = 14.sp,
                color = Color(0xFF777777)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Prix du meuble
        Text(
            text = "€ $furniturePrice",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF333333)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Ajout des dimensions du meuble
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Hauteur : $furnitureHeight cm",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
            Text(
                text = "Largeur : $furnitureWidth cm",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Description du meuble
        Text(
            text = furnitureDescription,
            fontSize = 14.sp,
            color = Color(0xFF666666),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Espace vide pour pousser les boutons vers le bas

        // Boutons en bas de l'écran
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Bouton AR (icône uniquement, en cercle)
            Button(
                onClick = onARClick,
                modifier = Modifier
                    .size(60.dp), // Taille augmentée pour cercle
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Vert
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Outlined.ViewInAr,
                    contentDescription = "Voir en AR",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp) // Taille de l'icône augmentée
                )
            }

            // Bouton Enregistrer (icône uniquement, en cercle)
            Button(
                onClick = onSaveClick,
                modifier = Modifier
                    .size(60.dp), // Taille augmentée pour cercle
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)), // Jaune
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.Bookmark,
                    contentDescription = "Enregistrer",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp) // Taille de l'icône augmentée
                )
            }

            // Bouton Acheter (avec texte et icône)
            Button(
                onClick = onAddToCartClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)), // Bleu
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Ajouter au panier",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Acheter",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DetailPreview() {
        FurnitureDetailScreen(
            furnitureName = "Canapé moderne",
            furniturePrice = "799 €",
            furnitureDescription = "Un canapé moderne au design élégant qui s'intègre parfaitement dans n'importe quel intérieur minimaliste.",
            furnitureHeight = "80",  // Hauteur en cm
            furnitureWidth = "45",
            furnitureImageRes = R.drawable.table,  // Remplacer par une ressource réelle
            onAddToCartClick = { /* Ajouter au panier action */ },
            onSaveClick = { /* Enregistrer action */ },
            onARClick = {}
        )
}