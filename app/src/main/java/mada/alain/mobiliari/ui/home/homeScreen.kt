package mada.alain.mobiliari.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.R
import mada.alain.mobiliari.R.drawable.table


@Composable
fun HomeScreen(
){
    data class Furniture(val title: String,val prix: String,val img: Int)
    var furnitureList = listOf(
        Furniture(title = "Table en bois", prix = "$450", img = table),
        Furniture(title = "Lampe moderne", prix = "$120", img = table),
        Furniture(title = "Chaiseurs", prix = "$30", img = R.drawable.horloge),
        Furniture(title = "Canapé en cuir", prix = "$950", img = table),
        Furniture(title = "Chaiseurs", prix = "$30", img = R.drawable.table),
        Furniture(title = "Chaise en velours", prix = "$320", img = R.drawable.horloge),
    )
    val listState1 = rememberLazyListState()
    val listState2 = rememberLazyListState()

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(listState1.firstVisibleItemScrollOffset) {
        listState2.scrollToItem(listState1.firstVisibleItemIndex, listState1.firstVisibleItemScrollOffset)
    }

    LaunchedEffect(listState2.firstVisibleItemScrollOffset) {
        listState1.scrollToItem(listState2.firstVisibleItemIndex, listState2.firstVisibleItemScrollOffset)
    }

    var Paire = furnitureList.filterIndexed { index, _ -> index % 2 == 0}
    var Impaire = furnitureList.filterIndexed { index, _ -> index % 2 != 0}

    var nomClick by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier =  Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
        ){
                LazyColumn(
                    state = listState1,
                ) {
                    items(Paire) { item ->
                        SmallFurnitureCard(
                            item.title, item.prix + nomClick, item.img
                        ){ e ->
                            nomClick = e
                        }
                    }
                }

                LazyColumn(
                    state = listState2,
                ) {
                    items(Impaire) { item ->
                        SmallFurnitureCard(
                            item.title, item.prix+ nomClick, item.img
                        ){ e ->
                            nomClick = e
                        }
                    }
                }

        }
    }

}

