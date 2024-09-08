package mada.alain.mobiliari.ui.connexion

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility

@Composable
fun textFied(
    icon : ImageVector,
    label : String,
    value : String,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }
        TextField(
            value = value,
            onValueChange = { newText ->
                onTextChange(newText) // Mise à jour de l'état
            },
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPassword) {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 12.dp),
                    tint = Color(0xFF8E59F0)
                    )
            },
            label = {
                Text(
                    text = label,
                    color = Color(0xFFA2A2A2),
                    fontSize = 12.sp
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFEDEFF1),
                cursorColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent, // Pas de ligne quand sélectionné
                unfocusedIndicatorColor = Color.Transparent, // Pas de ligne quand non sélectionné
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp,Color(0xFFB39DDB)), RoundedCornerShape(10.dp)),
        )

        Spacer(modifier = Modifier.height(24.dp))

}