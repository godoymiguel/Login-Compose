package com.godamy.logincompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.godamy.logincompose.ui.common.LoginButton
import com.godamy.logincompose.ui.common.PasswordField
import com.godamy.logincompose.ui.common.UserField

@Composable
fun LoginForm(onclick: () -> Unit) {
    Screen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            var user by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val buttonEnable = user.isNotEmpty() && password.isNotEmpty()

            UserField(value = user, onValueChange = { user = it })
            PasswordField(value = password, onValueChange = { password = it })
            LoginButton(buttonEnable, onclick)
        }
    }
}
