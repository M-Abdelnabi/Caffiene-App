package com.example.caffiene_app.presentation.screens.end_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.CaffeineButton
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.LightGrayBackground
import com.example.caffiene_app.ui.theme.UrbanistFont
import com.example.caffiene_app.ui.theme.sniglet
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EndScreen(
    modifier: Modifier = Modifier,
    viewModel: EndScreenViewModel = koinViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(LightGrayBackground)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_exit),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { viewModel.onExitClick() }
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_coffee),
                contentDescription = "",
                tint = DeepBrown,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(
                text = stringResource(R.string.more_espresso_less_depresso),
                fontFamily = sniglet,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = DeepBrown,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(R.drawable.ic_coffee),
                contentDescription = "",
                tint = DeepBrown,
                modifier = Modifier
                    .size(32.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.cup_cake),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
                .padding(top = 24.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        ) {
            Text(
                text = stringResource(R.string.bon_app_tit),
                fontFamily = UrbanistFont,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Charcoal.copy(alpha = 0.8f),

                )
            Image(
                painter = painterResource(R.drawable.ic_magic),
                contentDescription = "",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        CaffeineButton(
            label = "Thank youu",
            icon = R.drawable.ic_arrow,
            onClick = {
                viewModel.onButtonClick()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 162.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EndScreen()
}