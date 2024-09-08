package mada.alain.mobiliari.db


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    // Appel de la fonction pour charger les utilisateurs
    viewModel.getAllUsers()

    // Récupérer l'état des utilisateurs
    val users = viewModel.users.collectAsState()

    Column {
        // Affichage des utilisateurs
        LazyColumn {
            items(users.value) { user ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 12.dp)

                ){
                    Text(
                        text = "User: ${user.username}, E: ${user.email}",
                        modifier = Modifier
                            .weight(1f)
                        )
                    IconButton(onClick = {
                        viewModel.deleteUser(user.id)
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.Red)
                    }
                }

            }

        }
    }
}
