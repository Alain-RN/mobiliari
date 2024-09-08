package mada.alain.mobiliari.ui.app

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Profile","Log")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person, Icons.Filled.Create) // Icônes respectives

    BottomNavigation(
        backgroundColor = Color.Yellow
    ) {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(icons[index], contentDescription = item) // Utilisation de l'icône respective
                },
//                label = { Text(item) },
                selected = currentDestination == item,
                onClick = { navController.navigate(item) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray
            )
        }
    }
}
