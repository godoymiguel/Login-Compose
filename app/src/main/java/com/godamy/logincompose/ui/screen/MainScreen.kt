package com.godamy.logincompose.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Up
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun Main() {
    Screen {
        var count by remember { mutableStateOf(0) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Main Screen",
                style = MaterialTheme.typography.h5
            )
            
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                            slideOutVertically { fullHeight -> fullHeight } + fadeOut()
                }
            ) {
                Text(text = "Num of clicks: $count")
            }

            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    slideIntoContainer(Up) + fadeIn() with
                            slideOutOfContainer(Up) + fadeOut()
                }
            ) {
                Text(text = "Num of clicks: $count")
            }
            
            Button(onClick = { count++ }) {
                Text(text = "Count")
            }
            
        }

    }
}
