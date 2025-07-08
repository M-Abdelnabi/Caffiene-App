package com.example.caffiene_app.presentation.screens.coffee_size_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.CaffeineBeansAmountSelector
import com.example.caffiene_app.composables.CaffeineButton
import com.example.caffiene_app.composables.CoffeeSizeSelector
import com.example.caffiene_app.composables.CupSize
import com.example.caffiene_app.composables.TopBarItem
import com.example.caffiene_app.ui.theme.UrbanistFont
import com.example.caffiene_app.ui.theme.lightBlack
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeeSizeScreen(
    modifier: Modifier = Modifier, viewModel: CoffeeSizeViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    val cupSize = remember { mutableStateOf(CupSize.Medium) }

    val cupImageSize by animateDpAsState(
        targetValue = when (cupSize.value) {
            CupSize.Small -> 200.dp
            CupSize.Medium -> 250.dp
            CupSize.Large -> 320.dp
        }, label = "CupImageSize"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopBarItem(
            uiState.type,
            onClickBack = { viewModel.onBackClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp, top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 60.dp, bottom = 36.dp)
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
                    .size(70.dp)
            )
            val ml by remember {
                derivedStateOf {
                    when (cupSize.value) {
                        CupSize.Small -> "150 ML"
                        CupSize.Medium -> "200 ML"
                        CupSize.Large -> "400 ML"
                    }
                }
            }
            Text(
                text = ml,
                color = lightBlack,
                fontFamily = UrbanistFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 64.dp, start = 16.dp)
            )
        }

        CoffeeSizeSelector(
            selectedSize = cupSize.value,
            onSizeSelected = { cupSize.value = it },
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
                .align(Alignment.CenterHorizontally)

        )

        CaffeineBeansAmountSelector(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        CaffeineButton(
            label = "Continue",
            icon = R.drawable.ic_arrow,
            onClick = { viewModel.onButtonClick() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 100.dp, bottom = 50.dp)
        )
    }
}
