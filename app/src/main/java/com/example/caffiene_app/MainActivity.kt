package com.example.caffiene_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.caffiene_app.di.appModule
import com.example.caffiene_app.presentation.CaffeineApp
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            startKoin {
                androidLogger()
                modules(appModule)
            }
            CaffeineApp()
        }
    }
}
