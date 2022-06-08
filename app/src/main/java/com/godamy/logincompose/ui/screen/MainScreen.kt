package com.godamy.logincompose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun Main() {
    Screen {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Main Screen",
                style = MaterialTheme.typography.h5
            )
        }
    }
}
