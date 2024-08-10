package com.example.screenlocker.logic

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel

class ScreenLockerViewModel : ViewModel() {

    fun lockScreen(activity: Activity) {
        val devicePolicyManager = activity.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

        if (devicePolicyManager.isAdminActive(MyDeviceAdminReceiver.getComponentName(activity))) {
            devicePolicyManager.lockNow()
            activity.finish()
        } else {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, MyDeviceAdminReceiver.getComponentName(activity))
                putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "This app requires administrator privileges to lock the screen.")
            }
            activity.startActivity(intent)
        }
    }
}