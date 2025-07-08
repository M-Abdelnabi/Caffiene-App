package com.example.caffiene_app.presentation.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.CaffeineButton
import com.example.caffiene_app.composables.CaffeineSlogan
import com.example.caffiene_app.composables.HomeAnimatedGhost
import com.example.caffiene_app.composables.HomeTopBar
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinInject()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HomeTopBar()
        }
        CaffeineSlogan(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 26.dp)
        )
        HomeAnimatedGhost(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 33.dp)
        )
        CaffeineButton(
            label = "bring my coffee",
            icon = R.drawable.ic_coffee_mag,
            modifier = Modifier
                .padding(top = 60.dp, bottom = 50.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { viewModel.onButtonClick() }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}


