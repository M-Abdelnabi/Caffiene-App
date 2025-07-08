package com.example.caffiene_app.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.SemiTransparentWhite
import com.example.caffiene_app.ui.theme.UrbanistFont

@Composable
fun CoffeSizeBicker(
    selectedSize: CupSize,
    onSizeSelected: (CupSize) -> Unit,
    modifier: Modifier = Modifier
) {
    val options = listOf(CupSize.Small, CupSize.Medium, CupSize.Large)

    Box(
        modifier = modifier
            .width(156.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(100))
            .background(Color.White)
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            options.forEach { size ->
                SizeOption(
                    size = size,
                    isSelected = selectedSize == size,
                    onClick = { onSizeSelected(size) }
                )
            }
        }
    }
}

@Composable
fun SizeOption(
    size: CupSize,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val animatedBGColor by animateColorAsState(
        targetValue = if (isSelected) DeepBrown else Color.Transparent,
        animationSpec = tween(durationMillis = 1300)
    )

    val animatedTextColor by animateColorAsState(
        targetValue = if (isSelected) SemiTransparentWhite else Charcoal.copy(alpha = 0.6f),
        animationSpec = tween(durationMillis = 1300)
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(44.dp)
            .height(44.dp)
            .clip(RoundedCornerShape(50))
            .clickable { onClick() }
            .background(color = animatedBGColor)
    ) {
        Text(
            text = size.label,
            fontSize = 20.sp,
            fontFamily = UrbanistFont,
            color = animatedTextColor,
            fontWeight = FontWeight.Bold
        )
    }
}

enum class CupSize(val label: String) {
    Small("S"),
    Medium("M"),
    Large("L");
}


@Preview
@Composable
fun SizeSwitchPreview() {
    var selected by remember { mutableStateOf(CupSize.Medium) }

    CoffeSizeBicker(
        selectedSize = selected,
        onSizeSelected = { selected = it },
        modifier = Modifier.padding(16.dp)
    )
}