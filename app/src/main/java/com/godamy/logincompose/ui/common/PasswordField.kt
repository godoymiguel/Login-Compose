package com.godamy.logincompose.ui.common

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    login: () -> Unit
) {
    var passVisible by remember { mutableStateOf(false) }
    val visualPass = if (passVisible) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Password") },
        visualTransformation = visualPass,
        trailingIcon = {
            IconToggleButton(
                checked = passVisible,
                onCheckedChange = { passVisible = it }
            ) {
                Crossfade(
                    targetState = passVisible,
                    animationSpec = tween(1000)
                ) {
                    val icon =
                        if (it) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    Icon(
                        imageVector = icon,
                        contentDescription = "Show Password"
                    )
                }
            }
        },
        isError = isError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,

        ),
        keyboardActions = KeyboardActions { login() }
    )
}
