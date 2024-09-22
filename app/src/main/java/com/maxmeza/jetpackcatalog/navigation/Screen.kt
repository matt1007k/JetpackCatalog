package com.maxmeza.jetpackcatalog.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Home: Screen()
    @Serializable
    data class Detail(val movieId: Int): Screen()
}