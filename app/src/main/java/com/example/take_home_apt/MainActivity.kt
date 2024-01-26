package com.example.take_home_apt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.take_home_apt.presentation.components.navGraph.NavGraph
import com.example.take_home_apt.presentation.components.navGraph.Route
import com.example.take_home_apt.ui.theme.Take_home_aptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Take_home_aptTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = Route.ShipmentNavigation.route)
                }
            }
        }
    }
}