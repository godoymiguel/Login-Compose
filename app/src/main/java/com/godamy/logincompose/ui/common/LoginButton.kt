package com.godamy.logincompose.ui.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginButton(enable: Boolean, onclick: () -> Unit) {
    Button(
        onClick = onclick,
        enabled = enable
    ) {
        Text(text = "Login")
    }
}
