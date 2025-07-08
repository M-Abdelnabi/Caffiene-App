package com.example.caffiene_app.presentation.screens.coffee_ready_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.CaffeineButton
import com.example.caffiene_app.composables.OnOffSwitchItem
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.DeepBrown
import com.example.caffiene_app.ui.theme.LightGrayBackground
import com.example.caffiene_app.ui.theme.SemiTransparentWhite
import com.example.caffiene_app.ui.theme.UrbanistFont
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeeReadyScreen(
    viewModel: CoffeeReadyViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SemiTransparentWhite)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp, 48.dp)
                .clip(CircleShape)
                .background(LightGrayBackground)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_exit),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { viewModel.onClickExitButton() }
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(DeepBrown)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_true),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )

            }
            Text(
                text = stringResource(R.string.your_coffee_is_ready_enjoy),
                textAlign = TextAlign.Center,
                fontFamily = UrbanistFont,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Charcoal.copy(alpha = 0.87f)
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .height(370.dp)
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(R.drawable.ic_starbuks),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_starbuks_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .size(64.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.cover),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(69.dp)
                            .offset(y = (-20).dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(28.dp)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                OnOffSwitchItem()
                Text(
                    text = stringResource(R.string.take_away),
                    fontFamily = UrbanistFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Charcoal.copy(alpha = 0.7f),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            CaffeineButton(
                label = "Take snack",
                icon = R.drawable.ic_arrow,
                onClick = { viewModel.onClickButton() },
                modifier = Modifier.padding(top = 22.dp)
            )
        }

    }
}