package com.twentyfourseven.util

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsManager {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    fun initialize(application: Application) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(application)
    }

    fun logEvent(event: AnalyticsEvent) {
        firebaseAnalytics.logEvent(event.name.lowercase(), null)
    }
}