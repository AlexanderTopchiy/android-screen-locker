package com.example.screenlocker.presentation.features.screen_locker

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.screenlocker.domain.screen_locker.ScreenLockerUseCase

class ScreenLockerViewModel : ViewModel() {

    fun lockScreen(activity: Activity) {
        val shouldClose = ScreenLockerUseCase.lockScreen(activity)
        if (shouldClose) {
            activity.finish()
        }
    }
}