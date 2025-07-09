package com.example.caffiene_app.presentation.screens.end_screen

import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class EndScreenViewModel : BaseViewModel<EndScreenUiState>(EndScreenUiState()),
    EndScreenInteractionListener {
    override fun onButtonClick() {
        navigate(Destinations.Home)
    }

    override fun onExitClick() {
        navigateUp()
    }
}