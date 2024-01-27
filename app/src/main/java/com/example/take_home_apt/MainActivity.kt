package com.example.take_home_apt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.take_home_apt.presentation.SearchScreenNow
import com.example.take_home_apt.ui.theme.Take_home_aptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Take_home_aptTheme {
                SearchScreenNow()
//                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
//                    NavGraph(startDestination = Route.ShipmentNavigation.route)
//                }
            }
        }
    }
}