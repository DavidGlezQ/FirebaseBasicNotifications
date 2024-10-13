package com.david.glez.firebasebasicnotifications

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.glez.firebasebasicnotifications.data.TopicsService.Companion.BASKETBALL_TOPIC
import com.david.glez.firebasebasicnotifications.data.TopicsService.Companion.FOOTBALL_TOPIC
import com.david.glez.firebasebasicnotifications.data.TopicsService.Companion.PETANCA_TOPIC
import com.david.glez.firebasebasicnotifications.ui.theme.FirebaseBasicNotificationsTheme
import com.david.glez.firebasebasicnotifications.ui.theme.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get extras whe the notification is clicked
        val extras = intent.extras
        if (extras != null) {
            val example1 = extras.getString("example1")
            val example2 = extras.getString("example2")
            val example3 = extras.getString("example3")
            Log.i("Message", "$example1")
            Log.i("Message", "$example2")
            Log.i("Message", "$example3")
        }
        enableEdgeToEdge()
        setContent {
            FirebaseBasicNotificationsTheme {
                Greeting(mainViewModel)
            }
        }
    }
}

@Composable
fun Greeting(mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Button(
            onClick = { mainViewModel.subscribeToTopic(FOOTBALL_TOPIC) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Football Topic")
        }
        Button(
            onClick = { mainViewModel.subscribeToTopic(BASKETBALL_TOPIC) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Basketball Topic")
        }
        Button(
            onClick = { mainViewModel.subscribeToTopic(PETANCA_TOPIC) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Petanca Topic")
        }
    }
}