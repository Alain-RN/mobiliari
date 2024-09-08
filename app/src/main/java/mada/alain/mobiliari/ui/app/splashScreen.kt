package mada.alain.mobiliari.ui.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mada.alain.mobiliari.R
import mada.alain.mobiliari.ui.theme.MobiliariTheme

@Composable
fun SplashScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.mobiliari_removebg_preview),
            contentDescription = "mobiliari",
            modifier = Modifier
                .size(320.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    MobiliariTheme {
        SplashScreen(modifier = Modifier)
    }
}