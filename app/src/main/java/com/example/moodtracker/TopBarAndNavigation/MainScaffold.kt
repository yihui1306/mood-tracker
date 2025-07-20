package com.example.moodtracker.TopBarAndNavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun MainScreenWithDrawer(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Diary", modifier = Modifier.padding(16.dp))
                Text("Setting", modifier = Modifier.padding(16.dp))

            }
        }
    ) {
        BottomNavBar (openDrawer = {scope.launch{drawerState.open()}})
    }
}