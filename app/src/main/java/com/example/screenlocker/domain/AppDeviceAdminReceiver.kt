package com.example.screenlocker.domain

import android.app.admin.DeviceAdminReceiver
import android.content.Context

class AppDeviceAdminReceiver : DeviceAdminReceiver() {
    companion object {
        fun getComponentName(context: Context) = android.content.ComponentName(context, AppDeviceAdminReceiver::class.java)
    }
}