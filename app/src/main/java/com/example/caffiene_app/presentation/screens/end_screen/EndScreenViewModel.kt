package com.example.caffiene_app.presentation.screens.end_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class EndScreenViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<EndScreenUiState>(EndScreenUiState()),
    EndScreenInteractionListener
{
    private val destination = savedStateHandle.toRoute<Destinations.EndScreen>()

    init {
        val snackType = destination.snack
        updateUiState { it.copy(snackImageResource = snackType) }
    }
    override fun onButtonClick() {
        navigate(Destinations.Home)
    }

    override fun onExitClick() {
        navigateUp()
    }
}