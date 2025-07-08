package com.example.caffiene_app.presentation.screens.home_screen

import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations


class HomeScreenViewModel : BaseViewModel<HomeUiState>(HomeUiState()),
    HomeScreenInteractionListener {

    override fun onButtonClick() {
        navigate(Destinations.CoffeeType)
    }

}