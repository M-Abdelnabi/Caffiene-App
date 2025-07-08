package com.example.caffiene_app.presentation.screens.coffee_size_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class CoffeeSizeViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CoffeeSizeUiState>(CoffeeSizeUiState()), CoffeeSizeInteractionListener {

    private val destination = savedStateHandle.toRoute<Destinations.CoffeeSize>()

    init {
        val coffeeType = destination.type
        updateUiState { it.copy(type = coffeeType) }
    }

    override fun onButtonClick() {
        navigate(Destinations.CoffeePreparation)
    }

    override fun onBackClick() {
        navigateUp()
    }

}