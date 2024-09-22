package com.maxmeza.jetpackcatalog.commom.util

import android.app.Activity
import android.view.WindowMetrics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

data class WindowSize(
    val width: WindowType,
    val height: WindowType,
)

enum class WindowType {
    Compact, Medium, Expanded
}

@Composable
fun rememberWindowSize(): WindowSize {
    val configuration = LocalConfiguration.current

    return WindowSize(
        width = when {
            configuration.screenWidthDp < 600 -> WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        },
        height = when {
            configuration.screenHeightDp < 600 -> WindowType.Compact
            configuration.screenHeightDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        }
    )
}

//@Composable
//fun Activity.rememberWindowSizeClass(): WindowSize {
//    val configuration = LocalConfiguration.current
//    val windowMetrics = remember(configuration) {
//        WindowMetricsCalculator.getOrCreate()
//            .computeCurrentWindowMetrics(this)
//    }
//    val windowDpSize = with(LocalDensity.current) {
//        windowMetrics.bounds.toComposeRect().size.toDpSize()
//    }
//    when {
//        windowMetrics.width < 600.dp -> WindowSize.Compact
//        windowMetrics.width < 840.dp -> WindowSize.Medium
//        else -> WindowSize.Expanded
//    }
//}

//NavigationRail