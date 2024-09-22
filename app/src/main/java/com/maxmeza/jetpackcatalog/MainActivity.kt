package com.maxmeza.jetpackcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.navigation.compose.rememberNavController
import com.maxmeza.jetpackcatalog.navigation.Screen
import com.maxmeza.jetpackcatalog.navigation.SetupNavGraph
import com.maxmeza.jetpackcatalog.ui.theme.JetpackCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCatalogTheme {
                SetupNavGraph(
                    navController = rememberNavController(),
//                    startDestination = if(token != null) Screen.Home else Screen.Auth
                )
            }
        }
    }
}
