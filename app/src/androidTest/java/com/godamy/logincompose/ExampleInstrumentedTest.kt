package com.godamy.logincompose

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.godamy.logincompose", appContext.packageName)
    }

    @Test
    fun sampleTest(): Unit = with(composeTestRule) {
        setContent {
            var text by remember { mutableStateOf("Hello") }
            Button(onClick = { text = "Word" }) {
                Text(text = text)
            }
        }

        onRoot().printToLog("sampleTest")

        onRoot(useUnmergedTree = true).printToLog("sampleTestUnmerged")

        onNodeWithText("Hello").performClick()

        onRoot().printToLog("sampleTest")

        onNodeWithText("Word").assertExists()
    }
}
