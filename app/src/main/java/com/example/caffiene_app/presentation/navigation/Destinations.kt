package com.example.caffiene_app.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.caffiene_app.presentation.screens.CoffeSizeScreen
import com.example.caffiene_app.presentation.screens.CoffeePreparationScreen
import com.example.caffiene_app.presentation.screens.CoffeeReadyScreen
import com.example.caffiene_app.presentation.screens.CoffeeTypeScreen
import com.example.caffiene_app.presentation.screens.EndScreen
import com.example.caffiene_app.presentation.screens.HomeScreen
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
        composable<Destinations.CoffeeSize> { CoffeSizeScreen() }
        composable<Destinations.CoffeePreparation> { CoffeePreparationScreen() }
        composable<Destinations.CoffeeReady> { CoffeeReadyScreen() }
        composable<Destinations.SnackPicker> { SnackPickerScreen() }
        composable<Destinations.EndScreen> { EndScreen() }
    }
}