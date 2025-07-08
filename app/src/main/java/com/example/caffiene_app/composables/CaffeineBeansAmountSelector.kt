package com.example.caffiene_app.composables

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.LightGrayBackground
import com.example.caffiene_app.ui.theme.UrbanistFont
import kotlinx.coroutines.delay


@Composable
fun CaffeineBeansAmountSelector(
    modifier: Modifier = Modifier,
    onAmountChanged: (CaffeineAmount) -> Unit
) {
    var selected by remember { mutableStateOf(CaffeineAmount.MEDIUM) }
    var pendingSelected by remember { mutableStateOf<CaffeineAmount?>(null) }
    var visible by remember { mutableStateOf(true) }

    val xPositions = remember {
        mapOf(
            CaffeineAmount.LOW to 10.dp,
            CaffeineAmount.MEDIUM to 55.dp,
            CaffeineAmount.HIGH to 105.dp
        )
    }

    val x by remember(selected) { mutableStateOf(xPositions[selected] ?: 0.dp) }

    Column(
        modifier = modifier.width(152.dp)
    ) {
        Box(
            modifier = modifier
                .width(152.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(LightGrayBackground)
        ) {
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                CaffeineAmount.entries.forEach { level ->
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .width(50.dp)
                            .clickable {
                                if (level != selected) {
                                    visible = false
                                    pendingSelected = level
                                }
                            }
                    )
                }
            }

            androidx.compose.animation.AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(200)),
                exit = fadeOut(tween(200)),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = x)
            ) {
                Box(
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(DeepBrown)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_coffee),
                        contentDescription = "Caffeine level indicator",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            LaunchedEffect(visible) {
                if (!visible && pendingSelected != null) {
                    delay(200)
                    selected = pendingSelected!!
                    pendingSelected = null
                    visible = true
                    onAmountChanged(selected)
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CaffeineAmount.entries.forEach { level ->
                Text(
                    text = level.displayName,
                    fontFamily = UrbanistFont,
                    color = Charcoal.copy(alpha = 0.6f),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

enum class CaffeineAmount(val displayName: String) {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High")
}


@Preview(showBackground = true)
@Composable
private fun CaffeineBeansAmountSelectorPreview() {
    CaffeineBeansAmountSelector(
        onAmountChanged = {}
    )
}