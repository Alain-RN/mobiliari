package mada.alain.mobiliari.ui.ajouterFichier

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mada.alain.mobiliari.R
import mada.alain.mobiliari.db.Meuble
import mada.alain.mobiliari.db.MeubleViewModel

@Composable
fun MeubleForm(
    viewModel: MeubleViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf("") }
    var model3DUri by remember { mutableStateOf("") }

//    val launcherImage = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent()
//    ) { uri: Uri? -> imageUri = uri }
//
//    val launcherModel3D = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent()
//    ) { uri: Uri? -> model3DUri = uri }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nom du meuble") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Prix") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))

//        TextField(
//            value = description,
//            onValueChange = { description = it },
//            label = { Text("Description") }
//        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Hauteur") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = width,
            onValueChange = { width = it },
            label = { Text("Largeur") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = imageUri,
//            onValueChange = { imageUri = it },
//            label = { Text("Largeur") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = model3DUri,
//            onValueChange = { model3DUri = it },
//            label = { Text("Largeur") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )

//        Button(onClick = { launcherImage.launch("image/*") }) {
//            Text(text = "Sélectionner une image")
//        }
//        imageUri?.let {
//            Text(text = "Image sélectionnée: ${it.path}")
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Button(onClick = { launcherModel3D.launch("image/*") }) {
//            Text(text = "Sélectionner un modèle 3D")
//        }
//        model3DUri?.let {
//            Text(text = "Modèle 3D sélectionné: ${it.path}")
//        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
                viewModel.insert(meuble = Meuble(
                    nomMeuble = name,
                    prix = price.toDouble(),
                    description = "Une table pour les 3/6 ans à associer avec la version mini de la chaise Luxembourg. Pratique, elle se déplace sans difficulté d’un coin à l’autre de la maison, se faisant tour à tour coin bureau dans une chambre d’enfant, espace goûter à la cuisine, atelier coloriage au jardin. Kid dit mieux ?",
                    hauteur = height.toDouble(),
                    largeur = width.toDouble(),
                    imageUri = R.drawable.luxembour_table_kid.toString(),
                    modele3DUri = "luxembour_table_kid"
                    )
                )
        }) {
            Text(text = "Ajouter le meuble")
        }
    }
}


