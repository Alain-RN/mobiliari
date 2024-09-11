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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mada.alain.mobiliari.R


@Composable
fun UserListScreen(
    viewModel: UserViewModel = viewModel(),
    viewModel2 : MeubleViewModel = viewModel()
)
{
    // Appel de la fonction pour charger les utilisateurs
    viewModel.getAllUsers()
    viewModel2.getAllMeubles()

    // Récupérer l'état des utilisateurs
    val users = viewModel.users.collectAsState()
    val meubles = viewModel2.meubles.collectAsState()
    Column {
        // Affichage des utilisateurs
        LazyColumn {
            items(meubles.value) { user ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 12.dp)

                ){
                    androidx.compose.material.Text(
                        text = "User: ${user.nomID}, E: ${user.prix}",
                        modifier = Modifier
                            .weight(1f)
                        )
                    androidx.compose.material.IconButton(onClick = {
                        viewModel2.delete(user.nomID)
                    }) {
                        val i = R.drawable.close.toString()
                        Icon(
                            painter = painterResource(id = i.toInt()),
                            contentDescription = ""
                        )
                    }
                }

            }

        }
    }
}
