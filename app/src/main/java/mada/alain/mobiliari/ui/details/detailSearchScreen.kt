package mada.alain.mobiliari.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ViewInAr
import androidx.compose.material3.AlertDialogDefaults.containerColor
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import mada.alain.mobiliari.R
import mada.alain.mobiliari.db.MeubleViewModel

@Composable
fun FurnitureDetailScreen(
//    furnitureName: String,
//    furniturePrice: String,
//    furnitureDescription: String,
//    furnitureHeight: String, // Hauteur du meuble
//    furnitureWidth: String, // Largeur
//    furnitureImageRes: Int,  // Image resource ID
//    onAddToCartClick: () -> Unit,
//    onSaveClick: () -> Unit,
//    onARClick: () -> Unit,
    viewModel: MeubleViewModel = viewModel(),
    meubleId: String?,
    navController: NavController
)
{
    viewModel.getMeuble(meubleId!!.toInt())
    val meuble = viewModel.meuble.value

//    Column {
//        Button(onClick = {
//            navController.navigate("home") {
//                popUpTo(0)
//            }
//        }) {
//            Text(text = "Back")
//        }
//        Text(text = "Détails du meuble: ${meuble?.nomMeuble}")
//    }
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
                androidx.compose.material.IconButton(onClick = {
                    navController.navigate("home") {
                        popUpTo(0)
                    }
                }) {
                    androidx.compose.material.Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Retour",
                        tint =  Color(0xFF6E5EAC),
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .padding(horizontal = 16.dp)
        ) {
            // Image du meuble
            if (meuble != null) {
                Image(
                    painter = painterResource(id = meuble.imageUri.toInt()),
                    contentDescription = "Furniture Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Détails du meuble (nom et description)
            Column(
                modifier = Modifier
            ) {
                    androidx.compose.material.Text(
                        text = "${meuble?.nomMeuble}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333)
                    )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Prix du meuble
                androidx.compose.material.Text(
                    text = "€ ${meuble?.prix?.toInt()}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier,
                    color = Color(0xFF333333)
                )


            Spacer(modifier = Modifier.height(8.dp))

            // Ajout des dimensions du meuble
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                    androidx.compose.material.Text(
                        text = "Hauteur : ${meuble?.hauteur?.toInt()} cm",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                    androidx.compose.material.Text(
                        text = "Largeur : ${meuble?.largeur?.toInt()} cm",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Description du meuble avec texte plus grand
                androidx.compose.material.Text(
                    text = "${meuble?.description}",
                    fontSize = 14.sp, // Taille du texte augmentée pour une meilleure visibilité
                    color = Color(0xFF666666),
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                )


            Spacer(modifier = Modifier.weight(1f)) // Espace vide pour pousser les boutons vers le bas

        // Boutons en bas de l'écran
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            ) {

                // Bouton AR (icône uniquement, en cercle)
                androidx.compose.material.Button(
                    onClick = {},
                    modifier = Modifier
                        .size(60.dp), // Taille augmentée pour cercle
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = Color(
                        0xFF24A51A
                    )
                    ),
                    shape = CircleShape
                ) {
                    androidx.compose.material.Icon(
                        imageVector = Icons.Outlined.ViewInAr,
                        contentDescription = "Voir en AR",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp) // Taille de l'icône augmentée
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Bouton Enregistrer (icône uniquement, en cercle)
                androidx.compose.material.Button(
                    onClick = {},
                    modifier = Modifier
                        .size(60.dp), // Taille augmentée pour cercle
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)), // Jaune
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Filled.Bookmark,
                        contentDescription = "Enregistrer",
                        tint = Color.White,
                        modifier = Modifier.size(60.dp) // Taille de l'icône augmentée
                    )
                }
            }


                // Bouton Acheter (avec texte et icône), ajusté pour avoir une largeur plus petite
                androidx.compose.material.Button(
                    onClick = {/*onAddToCartClick*/},
                    modifier = Modifier
                        .width(140.dp) // Réduction de la largeur du bouton
                        .height(50.dp),
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E88E5)), // Bleu
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Ajouter au panier",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    androidx.compose.material.Text(
                        text = "Panier",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

}
