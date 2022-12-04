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
        openUrl(context, url)
    }
}

fun openUrl(
    context: Context,
    url: String
) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun shareText(context: Context, text: String) {
    val sendIntent = Intent(Intent.ACTION_SEND)
    sendIntent.putExtra(Intent.EXTRA_TEXT, text)
    sendIntent.type = "text/plain"
    context.startActivity(sendIntent)
}