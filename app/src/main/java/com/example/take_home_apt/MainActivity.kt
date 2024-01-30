package com.example.take_home_apt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.take_home_apt.presentation.components.navGraph.NavGraph
import com.example.take_home_apt.presentation.components.navGraph.Route
import com.example.take_home_apt.ui.theme.Take_home_aptTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.toPaddingValues

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {

            setContent {
                Take_home_aptTheme {
                    Box(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .safeDrawingPadding()
                            .padding(
                                LocalWindowInsets.current.systemBars.toPaddingValues()
                            )
                    ) {
                        NavGraph(startDestination = Route.ShipmentNavigation.route)
                    }
                }
            }
        }
    }
}