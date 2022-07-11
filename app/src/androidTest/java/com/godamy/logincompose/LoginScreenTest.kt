package com.godamy.logincompose

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.godamy.logincompose.ui.screen.LoginForm
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            LoginForm {}
        }
    }

    @Test
    fun loginButtonNotShow(): Unit = with(composeTestRule) {
        onNodeWithText("User").performClick().performTextInput("user@mail.com")
        onNodeWithText("Login").assertDoesNotExist()
    }

    @Test
    fun loginButtonEnable(): Unit = with(composeTestRule) {
        onNodeWithText("User").performClick().performTextInput("user@mail.com")
        onNodeWithText("Password").performClick().performTextInput("pass")
        onNodeWithText("Login").assertIsEnabled().performClick()
    }
}
