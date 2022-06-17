package com.godamy.logincompose.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
            var validationMessage by remember { mutableStateOf("") }
            val buttonEnable = user.isNotEmpty() && password.isNotEmpty()
            val isError = validationMessage.isNotBlank()

            val login = { validationMessage = validateLogin(user, password) }

            UserField(value = user, onValueChange = { user = it }, isError)
            PasswordField(value = password, onValueChange = { password = it }, isError, login)
            AnimatedVisibility(
                visible = validationMessage.isNotEmpty(),
                enter = slideInHorizontally(initialOffsetX = { 2 * it })
            ) {
                Text(text = validationMessage, color = MaterialTheme.colors.error)
            }
            AnimatedVisibility(visible = buttonEnable) {
                LoginButton(buttonEnable, onclick)
            }
        }
    }
}

private fun validateLogin(user: String, password: String): String =
    when {
        !user.contains("@") -> "User must be a valid email"
        password.length < 5 -> "Password must have at least 5 characters"
        else -> ""
    }
