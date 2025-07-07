package com.example.caffiene_app.composables

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.sniglet

@Composable
fun CaffeineSlogan(
    modifier: Modifier = Modifier
) {

    val starTransition = rememberInfiniteTransition()

    val star1Visibility by starTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        )
    )
    val star2Visibility by starTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 350),
            repeatMode = RepeatMode.Reverse
        )
    )
    val star3Visibility by starTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 400),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
            .height(200.dp)
            .width(200.dp)
    ) {
        Text(
            text = stringResource(R.string.slogan),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontFamily = sniglet,
            color = Charcoal.copy(alpha = 0.87f),
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.BottomEnd)
                .offset(y = (-18).dp)
                .graphicsLayer { alpha = star1Visibility }
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.TopEnd)
                .offset(y = 20.dp, x = (-12).dp)
                .graphicsLayer { alpha = star2Visibility }
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.CenterStart)
                .offset(y = (-22).dp, x = 20.dp)
                .graphicsLayer { alpha = star3Visibility }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CaffeineSlogan()
}

