package com.example.caffiene_app.presentation.screens.coffee_type_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import com.example.caffiene_app.presentation.BaseViewModel
import com.example.caffiene_app.presentation.navigation.Destinations

class CoffeeTypeViewModel : BaseViewModel<SelectCoffeeUiState>(SelectCoffeeUiState()),
    SelectCoffeeInteractionListener {

    private val _selectedIndex = mutableIntStateOf(0)
    val selectedIndex: State<Int> = _selectedIndex

    fun onCoffeeSelected(index: Int) {
        _selectedIndex.intValue = index
    }

    override fun onButtonClick(selectedCoffee: String) {
        navigate(Destinations.CoffeeSize(selectedCoffee))
    }

}