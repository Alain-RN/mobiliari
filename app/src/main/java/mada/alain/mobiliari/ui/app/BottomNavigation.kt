package mada.alain.mobiliari.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import mada.alain.mobiliari.R

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        "home",
        "saved",
        "ar",
        "search",
        "profile",
        )
//    val icons = listOf(Icons.Filled.Home, Icons.Filled.SavePage, Icons.Filled.Person, Icons.Filled.Create) // Icônes respectives
    val icons = listOf(
        R.drawable.home,
        R.drawable.save,
        R.drawable.camra,
        R.drawable.search,
        R.drawable.user,
    )
    Surface(
        color = Color(0xFFF5F3FF),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        BottomNavigation(
            backgroundColor = Color(0xFFDDE6F2),
            modifier = Modifier
                .padding(bottom = 8.dp, start = 13.dp, end = 13.dp)
                .height(68.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center, // Centre horizontalement les éléments
                verticalAlignment = Alignment.CenterVertically
            ) {
                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = icons[index]),
                                tint = Color(0xFF6E5EAC),
                                contentDescription = item,
                                modifier = Modifier
                                    .weight(1f)
                                    .size(
                                        if (index == 2) {
                                            52.dp
                                        } else {
                                            26.dp
                                        }
                                    )
                            )// Utilisation de l'icône respective
                        },
                        selected = currentDestination == item,

                        onClick = {
                            navController.navigate(item)
                        },
//                        selectedContentColor = Color.Blue,
//                        unselectedContentColor = Color.Gray
                    )
                }
            }
        }
    }

}
