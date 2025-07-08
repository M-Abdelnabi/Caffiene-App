package com.example.caffiene_app.presentation.screens.coffee_preparation_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.AnimatedWaveProgressBar
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.UrbanistFont
import com.example.caffiene_app.ui.theme.lightBlack
import com.example.caffiene_app.ui.theme.sniglet
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeePreparationScreen(
    modifier: Modifier = Modifier,
    viewModel: CoffeePreparationViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        delay(4000)
        viewModel.onFinishClick()
    }

    val cupImageSize = 250.dp
    val logoImageSize = 90.dp

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 120.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(341.dp)
                .padding(top = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_starbuks),
                contentDescription = "Cup",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(cupImageSize)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_starbuks_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(logoImageSize)
            )

            Text(
                text = "150 ML",
                color = lightBlack,
                fontFamily = UrbanistFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 64.dp, start = 16.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 190.dp)
        ) {
            AnimatedWaveProgressBar()
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Almost Done",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = stringResource(R.string.your_coffee_will_be_finish_in),
                    color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 64.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = stringResource(R.string.ff),
                        fontFamily = sniglet,
                        color = DeepBrown,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = stringResource(R.string.co),
                        fontFamily = sniglet,
                        color = DeepBrown,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = stringResource(R.string.ee),
                        fontFamily = sniglet,
                        color = DeepBrown,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }
        }
    }
}