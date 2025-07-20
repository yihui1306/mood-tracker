package com.example.moodtracker.TopBarAndNavigation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.fit5046a4.bottomNavigationBarAndTopBar.NavRoute
import com.example.moodtracker.R
import com.example.moodtracker.Diary
import com.example.moodtracker.Events
import com.example.moodtracker.Home


@Composable
fun BottomNavBar(openDrawer:() -> Unit) {
    val navRoutes = listOf(
        NavRoute("home", R.drawable.home, "Home"),
        NavRoute("diary", R.drawable.notebook, "Diary"),
        NavRoute("event", R.drawable.calendar, "Events")
    )

    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar (openDrawer)},
        bottomBar = {
            NavigationBar(
                modifier = Modifier.height(80.dp),
                containerColor = Color(0xFFEED6C4)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                navRoutes.forEach { navRoute ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = navRoute.iconRes),
                                contentDescription = navRoute.label,
                                tint =  Color.Unspecified,
                                modifier = Modifier.size(40.dp).padding(top = 12.dp)
                            )
                        },
                        label = { Text(navRoute.label) },
                        selected = currentDestination?.route == navRoute.route,
                        onClick = {
                            navController.navigate(navRoute.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { Home() }
            composable("diary") { Diary() }
            composable("event") { Events() }
        }
    }
}