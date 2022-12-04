package com.twentyfourseven.taptap.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class TapTapFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FirebaseMessagingToken", token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.e("fcm", "${message.messageId}")
        super.onMessageReceived(message)
    }
}