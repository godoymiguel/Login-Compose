package com.godamy.logincompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.godamy.logincompose.ui.common.ICON_REVEAL_TEXT_TEST_TAG
import com.godamy.logincompose.ui.common.PASS_TEXT_FIELD_TEST_TAG
import com.godamy.logincompose.ui.common.PasswordField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        composeTestRule.setContent {
            var state by remember { mutableStateOf("") }
            PasswordField(value = state, onValueChange = { state = it }) {}
        }
    }

    @Test
    fun revealIconShowsPassword(): Unit = with(composeTestRule) {
        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).performTextInput("pass")

        onRoot().printToLog("password")
        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).assertTextContains("••••")

        onNodeWithTag(ICON_REVEAL_TEXT_TEST_TAG).performClick()

        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).assertTextContains("pass")

        onNodeWithContentDescription(ctx.getString(R.string.show_password)).assertExists()
    }
}
