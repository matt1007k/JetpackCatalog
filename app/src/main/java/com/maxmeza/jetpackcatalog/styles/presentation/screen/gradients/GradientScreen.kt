package com.maxmeza.jetpackcatalog.styles.presentation.screen.gradients

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GradientScreenPreview(){
    GradientScreen(onDetail = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradientScreen(onDetail: () -> Unit, modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBottomList = listOf(
        BottomNavItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavItem(
            title = "Favorites",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            hasNews = false
        ),
        BottomNavItem(
            title = "Notifications",
            selectedIcon = Icons.Filled.Share,
            unselectedIcon = Icons.Outlined.Share,
            hasNews = true,
            badgeCount = 2
        )
    )
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                navBottomList.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        selected = index == 0,
                        onClick = {
//                                navController.navigate(route)
                        },
                        label = { Text(item.title) },
                        icon = {
                            Icon(
                                imageVector = if (index == 0) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(item.badgeCount.toString())
                                }
                            }
                        }
                    )
                }
            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            },
            topBar = {
                CenterAlignedTopAppBar(
                    { Text("Home") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Build description")
                        }
                    },
                    actions = {
                        IconButton(onClick = { print("Build") }) {
                            Icon(Icons.Filled.Add, contentDescription = "Build description")
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = {
//                BottomAppBar(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    contentColor = MaterialTheme.colorScheme.primary,
//                ) {
//                    IconButton(onClick = { print("Build") }) {
//                        Icon(Icons.Filled.Build, contentDescription = "Build description")
//                    }
//                }
                NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                    navBottomList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == 1,
                            onClick = {
                                onDetail()
//                                navController.navigate(route)
                            },
                            label = { Text(item.title) },
                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(item.badgeCount.toString())
                                        }
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (index == 0) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }

                            },

                            )
                    }
                }
            },
        ) { contentPadding ->
            Column(Modifier.padding(contentPadding)) {
                Text("Gradient")
            }
        }
    }
}
