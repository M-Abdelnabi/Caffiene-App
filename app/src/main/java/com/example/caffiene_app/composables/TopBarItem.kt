package com.example.caffiene_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.LightGrayBackground
import com.example.caffiene_app.ui.theme.UrbanistFont

@Composable
fun TopBarItem(
    title: String,
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp, 48.dp)
                .clip(CircleShape)
                .background(LightGrayBackground)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center)
                    .clickable {onClickBack()}
            )
        }
        Text(
            text = title,
            fontFamily = UrbanistFont,
            color = Charcoal.copy(alpha = 0.87f),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarItemPreview() {
    TopBarItem(title = "Macchiato", onClickBack = {})
}