package com.example.caffiene_app.composables


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffiene_app.R


@Composable
fun HomeAnimatedGhost(
    modifier: Modifier = Modifier
) {

    val infiniteTransition = rememberInfiniteTransition()

    val ghostTransition by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = (-15).dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val shadowTransition by infiniteTransition.animateValue(
        initialValue = (-15).dp,
        targetValue = (-10).dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val shadowVisibility by infiniteTransition.animateFloat(
        initialValue = 1.2f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.coffe_ghost),
            contentDescription = "",
            modifier = Modifier
                .size(244.dp)
                .offset(y = ghostTransition)
        )

        Image(
            painter = painterResource(R.drawable.coffe_ghost_shadow),
            contentDescription = "",
            modifier = Modifier
                .width(180.dp)
                .offset(y = shadowTransition)
                .graphicsLayer {
                    this.alpha = shadowVisibility
                }
        )


    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    HomeAnimatedGhost()
}