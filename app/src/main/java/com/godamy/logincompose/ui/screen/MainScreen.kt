package com.godamy.logincompose.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.min

@ExperimentalAnimationApi
@Composable
fun Main() {
    Screen {
        var count by remember { mutableStateOf(0) }

        val infiniteTransition = rememberInfiniteTransition()
        val transition = updateTransition(targetState = count, label = "Update transition")

        val bgColor by infiniteTransition.animateColor(
            initialValue = Color.White,
            targetValue = Color.LightGray,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 1000
                },
                repeatMode = RepeatMode.Reverse
            )
        )

        val borderUp by transition.animateDp(label = "transition Dp") { it.dp }
        val borderBg by animateColorAsState(targetValue = Color.Gray.copy(alpha = min(1f, count.toFloat() / 10f)))

        Box(contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .wrapContentSize()
                    .background(bgColor)
                    .border(borderUp, borderBg)
                    .padding(16.dp)
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
}
