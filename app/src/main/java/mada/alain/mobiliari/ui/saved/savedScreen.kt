package mada.alain.mobiliari.ui.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.R

@Composable
fun SavedScreen(
){
    val meubles = listOf(
        Furniture(R.drawable.table,"Alainfgj  fgj", "200"),
        Furniture(R.drawable.horloge,"Alajfgjf fjin", "200"),
        Furniture(R.drawable.table,"Ala cfgfin", "200"),
        Furniture(R.drawable.table,"Alan", "200"),
        Furniture(R.drawable.horloge,"Alai  gfjfn", "200")
    )
    var meuble by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)
            .padding(horizontal = 8.dp)
    ) {
    LazyColumn {
        items(meubles){ item ->
            RowMeubleCard(furniture = item){
                e -> meuble = e
            }
            Spacer(modifier = Modifier.height(4.dp))
        }

    }
    }
}