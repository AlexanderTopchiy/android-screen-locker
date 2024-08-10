package com.example.screenlocker.presentation.features.screen_locker

import android.app.Activity
import android.os.Bundle
import com.example.screenlocker.domain.screen_locker.ScreenLockerUseCase

class ScreenLockerPermissionActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ScreenLockerUseCase.lockScreen(this)
        finish()
    }
}
