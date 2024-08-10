package com.example.screenlocker.presentation.features.screen_locker

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.screenlocker.R
import com.example.screenlocker.domain.screen_locker.ScreenLockerUseCase

class ScreenLockerWidgetProvider : AppWidgetProvider() {
    
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val remoteViews = RemoteViews(context.packageName, R.layout.screen_locker_widget)

            val intent = Intent(context, ScreenLockerWidgetProvider::class.java).apply {
                action = "com.example.screenlocker.ACTION_LOCK_SCREEN"
            }

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            remoteViews.setOnClickPendingIntent(R.id.widget_button, pendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == "com.example.screenlocker.ACTION_LOCK_SCREEN") {
            ScreenLockerUseCase.lockScreen(context)
        }
    }
}