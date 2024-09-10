package mada.alain.mobiliari.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mada.alain.mobiliari.R


data class itemList(val name : String, val price : String, val imgId : Int)
@Composable
fun SearchScreen(
    navController: NavHostController,
){
    var searchQuery by remember {
        mutableStateOf("")
    }

    val itemList = listOf(
        itemList("Amen", "200", R.drawable.table),
        itemList("Amen", "200", R.drawable.table),
        itemList("Amen", "200", R.drawable.table),
        itemList("Amen", "200", R.drawable.horloge),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = Modifier
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 14.dp, start = 8.dp)
            ) {
                // retour
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color(0xFF6E5EAC),
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
                // barre de recherche
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(text = "Rechercher des meubles")
                    },

                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Effacer",
                                    tint = Color(0xFF6E5EAC)
                                )
                            }
                        }
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0xFFE3E7F1),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
//                        .background(Color.White, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(28.dp)), // Coins arrondis,
                )

            }

            // filtre
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Ouvre filtre de prix */ },
                ) { Text("Prix") }
                Button(
                    onClick = { /* Ouvre filtre de couleurs */ }
                ) { Text("Couleur") }
                Button(
                    onClick = { /* Ouvre filtre de catégories */ }
                ) { Text("Catégories") }
            }

            // Liste de recherche
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemList) { item ->
                    Card(
                        backgroundColor = Color(0xFFF9F9FB),
                        modifier = Modifier
                            // Va dans le details
                            .clickable {

                            }
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp)), // Coins arrondis,
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = item.imgId),
                                contentDescription = "Meuble",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Column(
                                modifier = Modifier.weight(1f).padding(start = 16.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = item.name,
                                    fontSize = 16.sp,
                                    color = Color(0xFF3A496C)
                                )
                                Text(
                                    text = "${item.price} €",
                                    fontSize = 16.sp,
                                    color = Color(0xFF4A4A4A),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }


        }
    }
}