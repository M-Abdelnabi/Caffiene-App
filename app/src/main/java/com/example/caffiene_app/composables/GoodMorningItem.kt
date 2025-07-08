package com.example.caffiene_app.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.DarkGray
import com.example.caffiene_app.ui.theme.Gray
import com.example.caffiene_app.ui.theme.UrbanistFont

@Composable
fun WelcomeItem(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp)
    ) {

        Text(
            text = stringResource(R.string.good_morning),
            color = Gray,
            fontFamily = UrbanistFont,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold

        )

        Text(
            text = "$name ☀",
            color = DarkGray,
            fontFamily = UrbanistFont,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(R.string.what_would_you_like_to_drink_today),
            color = Charcoal.copy(alpha = 0.8f),
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeItemPreview() {
    WelcomeItem("Hamsa")
}
