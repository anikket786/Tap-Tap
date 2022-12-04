package com.twentyfourseven.taptap

import android.app.Application
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory
import com.twentyfourseven.util.AnalyticsManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TapTapApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Prevent side loaded apps from opening
        if (MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            return // Skip app initialization.
        }

        AnalyticsManager.initialize(this)
    }
}