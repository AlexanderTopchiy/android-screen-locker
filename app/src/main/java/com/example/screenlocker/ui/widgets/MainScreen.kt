package com.example.screenlocker.ui.widgets

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.screenlocker.logic.ScreenLockerViewModel
import com.example.screenlocker.ui.theme.ScreenLockerTheme

@Composable
fun MainScreen(viewModel: ScreenLockerViewModel, activity: Activity) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { viewModel.lockScreen(activity) }) {
            Text(text = "Lock Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScreenLockerTheme {
        MainScreen(viewModel = ScreenLockerViewModel(), activity = Activity())
    }
}