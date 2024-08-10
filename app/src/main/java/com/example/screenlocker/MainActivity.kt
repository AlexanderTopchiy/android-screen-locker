package com.example.screenlocker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.screenlocker.logic.ScreenLockerViewModel
import com.example.screenlocker.ui.theme.ScreenLockerTheme
import com.example.screenlocker.ui.widgets.MainScreen

class MainActivity : ComponentActivity() {

    private val viewModel: ScreenLockerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLockerTheme {
                MainScreen(viewModel = viewModel, activity = this)
            }
        }
    }
}