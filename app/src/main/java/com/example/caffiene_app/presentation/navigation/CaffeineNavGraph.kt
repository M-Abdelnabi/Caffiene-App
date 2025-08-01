package com.example.caffiene_app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.caffiene_app.presentation.navigation.utils.ObserveAsEvents
import org.koin.compose.koinInject

val LocalNavController = compositionLocalOf<NavHostController> { error("No Nav Controller Found") }


@Composable
fun CaffeineNavGraph(navController: NavHostController, navigator: Navigator = koinInject()) {

    ObserveAsEvents(navigator.navigationEvent) { event ->
        when (event) {
            is NavigationEvent.Navigate -> navController.navigate(
                route = event.destination, navOptions = event.navOptions
            )

            NavigationEvent.NavigateUp -> navController.navigateUp()
        }
    }

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {

        NavHost(
            navController = navController,
            startDestination = navigator.startGraph,
        ) {
            buildCaffeineNavGraph()
        }

    }
}