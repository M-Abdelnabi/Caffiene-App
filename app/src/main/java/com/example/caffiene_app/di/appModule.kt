package com.example.caffiene_app.di

import com.example.caffiene_app.presentation.navigation.Destinations
import com.example.caffiene_app.presentation.navigation.Navigator
import com.example.caffiene_app.presentation.navigation.NavigatorImpl
import com.example.caffiene_app.presentation.screens.home_screen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeScreenViewModel() }
    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}
