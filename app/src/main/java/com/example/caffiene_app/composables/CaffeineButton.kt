package com.example.caffiene_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.caffiene_app.ui.theme.SemiTransparentWhite
import com.example.caffiene_app.ui.theme.UrbanistFont

@Composable
fun CustomizedButton(
    label: String,
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Charcoal)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = label,
            color = SemiTransparentWhite,
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 32.dp, end = 4.dp)
        )
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 4.dp, end = 32.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun CustomizedButtonPreview() {
    Column {
        CustomizedButton(
            label = "continue",
            icon = R.drawable.ic_arrow,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomizedButtonPreview1() {
    CustomizedButton(
        label = "Take snack",
        icon = R.drawable.ic_arrow,
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomizedButtonPreview2() {
    CustomizedButton(
        label = "Thank you",
        icon = R.drawable.ic_arrow,
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomizedButtonPreview3() {
    CustomizedButton(
        label = "bring my coffee",
        icon = R.drawable.ic_coffee_mag,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}