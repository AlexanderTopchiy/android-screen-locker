package com.example.screenlocker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.screenlocker.presentation.features.screen_locker.ScreenLockerScreen
import com.example.screenlocker.presentation.features.screen_locker.ScreenLockerViewModel
import com.example.screenlocker.presentation.theme.ScreenLockerTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ScreenLockerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLockerTheme {
                ScreenLockerScreen(viewModel = viewModel, activity = this)
            }
        }
    }
}