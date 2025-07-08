package com.example.caffiene_app.di

import androidx.lifecycle.SavedStateHandle
import com.example.caffiene_app.presentation.navigation.Destinations
import com.example.caffiene_app.presentation.navigation.Navigator
import com.example.caffiene_app.presentation.navigation.NavigatorImpl
import com.example.caffiene_app.presentation.screens.coffee_preparation_screen.CoffeePreparationViewModel
import com.example.caffiene_app.presentation.screens.coffee_ready_screen.CoffeeReadyViewModel
import com.example.caffiene_app.presentation.screens.coffee_size_screen.CoffeeSizeViewModel
import com.example.caffiene_app.presentation.screens.coffee_type_screen.CoffeeTypeViewModel
import com.example.caffiene_app.presentation.screens.home_screen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { CoffeeTypeViewModel() }
    viewModel { (handle: SavedStateHandle) -> CoffeeSizeViewModel(handle) }
    viewModel { CoffeePreparationViewModel() }
    viewModel { CoffeeReadyViewModel() }

    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}
