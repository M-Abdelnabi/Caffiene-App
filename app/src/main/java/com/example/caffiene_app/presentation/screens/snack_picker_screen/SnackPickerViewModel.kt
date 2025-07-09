package com.example.caffiene_app.presentation.screens.snack_picker_screen

import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class SnackPickerViewModel : BaseViewModel<SnackPickerUiState>(SnackPickerUiState()),
    SnackPickerInteractionListener {

    override fun onItemClick(selectedSnack: Int) {
        navigate(Destinations.EndScreen(selectedSnack))
    }

    override fun onExitClick() {
        navigateUp()
    }
}