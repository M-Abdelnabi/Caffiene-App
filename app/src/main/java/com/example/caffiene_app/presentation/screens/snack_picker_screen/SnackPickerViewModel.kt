package com.example.caffiene_app.presentation.screens.snack_picker_screen

import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations
import com.example.caffiene_app.presentation.screens.snack_picker_screen.SnackPickerInteractionListener
import com.example.caffiene_app.presentation.screens.snack_picker_screen.SnackPickerUiState

class SnackPickerViewModel : BaseViewModel<SnackPickerUiState>(SnackPickerUiState()),
    SnackPickerInteractionListener {
    override fun onItemClick() {
        navigate(Destinations.EndScreen)
    }

    override fun onExitClick() {
        navigateUp()
    }

}