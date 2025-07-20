package com.example.moodtracker.TopBarAndNavigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun TopBar(openDrawer:() -> Unit){
    TopAppBar(
        modifier = Modifier.height(100.dp),
        title = {Text("Mood Tracker", modifier = Modifier.padding(top=36.dp))},
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu",  modifier = Modifier.padding(top=35.dp))
            }
        },
        backgroundColor = Color(0xFFEED6C4)
    )
}