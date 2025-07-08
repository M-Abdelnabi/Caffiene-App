package com.example.caffiene_app.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.caffiene_app.presentation.screens.CoffeePreparationScreen
import com.example.caffiene_app.presentation.screens.CoffeeReadyScreen
import com.example.caffiene_app.presentation.screens.coffee_size_screen.CoffeeSizeScreen
import com.example.caffiene_app.presentation.screens.coffee_type_screen.CoffeeTypeScreen
import com.example.caffiene_app.presentation.screens.EndScreen
import com.example.caffiene_app.presentation.screens.home_screen.HomeScreen
import com.example.caffiene_app.presentation.screens.SnackPickerScreen
import kotlinx.serialization.Serializable

sealed interface Destinations : Graph {

    @Serializable
    data object CaffeineGraph : Graph

    @Serializable
    data object Home : Destination

    @Serializable
    data object CoffeeType : Destination

    @Serializable
    data class CoffeeSize(val type: String) : Destination

    @Serializable
    data object CoffeePreparation : Destination

    @Serializable
    data object CoffeeReady : Destination

    @Serializable
    data object SnackPicker : Destination

    @Serializable
    data object EndScreen : Destination
}

fun NavGraphBuilder.buildCaffeineNavGraph() {
    navigation<Destinations.CaffeineGraph>(startDestination = Destinations.Home) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.CoffeeType> { CoffeeTypeScreen() }
        composable<Destinations.CoffeeSize> { CoffeeSizeScreen() }
        composable<Destinations.CoffeePreparation> { CoffeePreparationScreen() }
        composable<Destinations.CoffeeReady> { CoffeeReadyScreen() }
        composable<Destinations.SnackPicker> { SnackPickerScreen() }
        composable<Destinations.EndScreen> { EndScreen() }
    }
}