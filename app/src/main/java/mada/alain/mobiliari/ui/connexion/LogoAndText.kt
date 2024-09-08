package mada.alain.mobiliari.ui.connexion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mada.alain.mobiliari.R

@Composable
fun LogoAndText(Title : String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.mobiliari2),
                contentDescription = "mobiliari",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(1.dp, 42.dp)

            )
            Spacer(modifier = Modifier.height(62.dp))
            Text(
                textAlign = TextAlign.Center,
                text = Title,
                fontSize = 40.sp,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}