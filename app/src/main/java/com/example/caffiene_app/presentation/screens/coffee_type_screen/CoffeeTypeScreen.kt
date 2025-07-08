package com.example.caffiene_app.presentation.screens.coffee_type_screen

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
import com.example.caffiene_app.composables.CoffeeHorizontalPager
import com.example.caffiene_app.composables.HomeTopBar
import com.example.caffiene_app.composables.WelcomeItem
import org.koin.compose.koinInject

@Composable
fun CoffeeTypeScreen(
    modifier: Modifier = Modifier,
    viewModel: CoffeeTypeViewModel = koinInject()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        HomeTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        WelcomeItem("Hamsa", modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 60.dp))

        CoffeeHorizontalPager(
            items = coffeeItems,
            onItemSelected = { index ->
                viewModel.onCoffeeSelected(index)
            }
        )

        val selectedIndex = viewModel.selectedIndex.value
        val selectedCoffeeName = coffeeItems[selectedIndex].second

        CaffeineButton(
            label = "Continue",
            icon = R.drawable.ic_arrow,
            onClick = { viewModel.onButtonClick(selectedCoffeeName) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp, top = 120.dp)
        )
    }
}

val coffeeItems = listOf(
    R.drawable.espresso to "Espresso",
    R.drawable.latte to "Latte",
    R.drawable.macchiato to "Cappuccino",
    R.drawable.black_coffee to "Black"
)

@Preview
@Composable
private fun CoffeeTypeScreenPreview() {
    CoffeeTypeScreen()
}
