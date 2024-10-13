package com.david.glez.firebasebasicnotifications.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class TopicsService @Inject constructor(val firebaseMessaging: FirebaseMessaging) {
    companion object {
        const val FOOTBALL_TOPIC = "football_topic"
        const val BASKETBALL_TOPIC = "basketball_topic"
        const val PETANCA_TOPIC = "petanca_topic"
    }

    fun subscribeToTopic(topic: String) {
        firebaseMessaging.subscribeToTopic(topic).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("NotificationSub", "Subscribed to $topic")
            } else {
                Log.i("NotificationSub", "error subscribed to $topic")
            }
        }
    }

    fun unsubscribeToTopic(topic: String) {
        firebaseMessaging.unsubscribeFromTopic(topic)

    }
}