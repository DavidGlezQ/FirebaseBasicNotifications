package com.david.glez.firebasebasicnotifications.ui.theme

import androidx.lifecycle.ViewModel
import com.david.glez.firebasebasicnotifications.data.TopicsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val topicsService: TopicsService): ViewModel() {

    fun subscribeToTopic(topic: String) {
        topicsService.subscribeToTopic(topic = topic)

    }
}