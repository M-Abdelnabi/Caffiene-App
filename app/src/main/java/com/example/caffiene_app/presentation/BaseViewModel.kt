package com.example.caffiene_app.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.example.caffiene_app.presentation.navigation.Destination
import com.example.caffiene_app.presentation.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseViewModel<S>(initialState: S) : ViewModel(), KoinComponent {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val navigator: Navigator by inject()

    protected fun navigate(destination: Destination, navOptions: NavOptions? = null) =
        viewModelScope.launch {
            navigator.navigate(destination = destination, navOptions = navOptions)
        }

    protected fun navigateUp() = viewModelScope.launch { navigator.navigateUp() }

    protected fun updateUiState(update: (S) -> S) {
        _uiState.value = update(_uiState.value)
    }

    protected fun launchSafely(
        onLoading: (() -> Unit)? = null,
        onSuccess: suspend () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onLoading?.let { it() }
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Unexpected error")
            }
        }
    }
}