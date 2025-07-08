package com.example.caffiene_app.presentation.screens.coffee_preparation_screen

import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class CoffeePreparationViewModel(

) : BaseViewModel<CoffeePreparationUiState>(CoffeePreparationUiState()), CoffeePreparationInteractionListener {
    override fun onFinishClick() {
        navigate(Destinations.CoffeeReady)
    }

}