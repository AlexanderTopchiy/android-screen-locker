package com.example.screenlocker.logic

import android.app.admin.DeviceAdminReceiver
import android.content.Context

class MyDeviceAdminReceiver : DeviceAdminReceiver() {
    companion object {
        fun getComponentName(context: Context) = android.content.ComponentName(context, MyDeviceAdminReceiver::class.java)
    }
}