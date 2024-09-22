package com.maxmeza.jetpackcatalog.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.maxmeza.jetpackcatalog.multi_screens.presentation.screen.custom.CustomWindowSize
import com.maxmeza.jetpackcatalog.styles.presentation.screen.gradients.GradientScreen


@Composable
fun SetupNavGraph(
   navController: NavHostController,
   startDestination: Screen = Screen.Home
) {

   NavHost(navController = navController, startDestination = startDestination) {
      composable<Screen.Home> {
         GradientScreen(onDetail = {
            navController.navigate(Screen.Detail(movieId = 1))
         })
      }
      composable<Screen.Detail> { backStackEntry ->
         val profile = backStackEntry.toRoute<Screen.Detail>()
         Scaffold {
            Column(Modifier.padding(it)) {
               Text(text = "${profile.movieId}")
               CustomWindowSize()
            }
         }
      }
   }
}