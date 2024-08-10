package com.example.screenlocker.domain.screen_locker

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import com.example.screenlocker.domain.AppDeviceAdminReceiver

object ScreenLockerUseCase {

    fun lockScreen(context: Context): Boolean {
        val devicePolicyManager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val componentName = AppDeviceAdminReceiver.getComponentName(context)

        return if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.lockNow()
            true
        } else {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(
                    DevicePolicyManager.EXTRA_DEVICE_ADMIN,
                    componentName
                )
                putExtra(
                    DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    "This app requires administrator privileges to lock the screen."
                )
            }
            context.startActivity(intent)
            false
        }
    }
}