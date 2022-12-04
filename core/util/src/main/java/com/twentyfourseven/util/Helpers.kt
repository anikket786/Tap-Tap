package com.twentyfourseven.util

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent


fun openChromeCustomTab(
    context: Context,
    url: String,
) {
    val customIntent = CustomTabsIntent.Builder()
    customIntent.setToolbarColor(Color.parseColor("#FF000000"))
    val customTabsIntent = customIntent.build()

    try {
        customTabsIntent.intent.setPackage("com.android.chrome")
        customTabsIntent.launchUrl(context, Uri.parse(url))
    } catch (e: Exception) {
        e.printStackTrace()
        openUrlInExternalBrowser(context, url)
    }
}

fun openUrlInExternalBrowser(
    context: Context,
    url: String
) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}