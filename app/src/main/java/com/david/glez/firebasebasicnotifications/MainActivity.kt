package com.david.glez.firebasebasicnotifications

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.david.glez.firebasebasicnotifications.ui.theme.FirebaseBasicNotificationsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseBasicNotificationsTheme {
        Greeting("Android")
    }
}