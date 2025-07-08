package com.example.caffiene_app.composables

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.SemiTransparentWhite
import com.example.caffiene_app.ui.theme.SoftPeach
import com.example.caffiene_app.ui.theme.UrbanistFont
import com.example.caffiene_app.ui.theme.lightBlack

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun OnOffSwitchItem(modifier: Modifier = Modifier) {

    var isEnable by remember { mutableStateOf(false) }

    val options = SwitchOption.entries

    val backgroundColor by animateColorAsState(
        targetValue = if (isEnable) DeepBrown else SoftPeach,
        animationSpec = tween(durationMillis = 300),
    )

    val animatedIcon by animateDpAsState(
        targetValue = if (isEnable) 0.dp else 38.dp,
        animationSpec = tween(durationMillis = 450),
    )

    Box(
        modifier = modifier
            .height(40.dp)
            .width(78.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable { isEnable = !isEnable }

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            options.forEach {
                Text(
                    text = it.label,
                    color = if (it == SwitchOption.OFF) lightBlack else SemiTransparentWhite,
                    fontFamily = UrbanistFont,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Image(
            painter = painterResource(R.drawable.ic_mug),
            contentDescription = null,
            modifier = Modifier.offset(x = animatedIcon)
        )
    }
}

enum class SwitchOption(val label: String) {
    OFF("OFF"),
    ON("ON")
}

@Preview
@Composable
private fun OnOffSwitchItemPreview() {
    OnOffSwitchItem()
}