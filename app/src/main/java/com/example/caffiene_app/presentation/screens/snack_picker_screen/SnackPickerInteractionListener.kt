package com.example.caffiene_app.presentation.screens.snack_picker_screen

interface SnackPickerInteractionListener {
    fun onItemClick(selectedSnack: Int)
    fun onExitClick()
}