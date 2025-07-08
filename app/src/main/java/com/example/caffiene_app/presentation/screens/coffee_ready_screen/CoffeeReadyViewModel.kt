package com.example.caffiene_app.presentation.screens.coffee_ready_screen

import com.caffeine.presentation.screen.ready_coffee_screen.CoffeeReadyUiState
import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class CoffeeReadyViewModel : BaseViewModel<CoffeeReadyUiState>(CoffeeReadyUiState()),
    CoffeeReadyInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.SnackPicker)
    }

    override fun onClickExitButton() {
        navigateUp()
    }

}