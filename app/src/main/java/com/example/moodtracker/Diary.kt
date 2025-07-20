package com.example.moodtracker


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Diary(){
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateString = currentDate.format(formatter)

    var selectDate by remember { mutableStateOf(dateString) }
    var diaryText by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var showAddOption by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // date selector
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center)
        {
            Button(
                onClick = { showDatePicker = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD7C4A3),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ){
                Text(
                    text = selectDate,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        // how do u feel today section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            Text(
                text = "How do you feel today?",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "🧐",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Main text field area
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color(0xFFD7C4A3))
        ){
            Column {
                OutlinedTextField(
                    value = diaryText,
                    onValueChange = {diaryText = it},
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    placeholder = {
                        Text(
                            text = "Write your thought here...",
                            color = Color.Gray
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                )
            }
        }
        //Add option area
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.End
        ){
            Column(
                horizontalAlignment = Alignment.End
            ) {
                //Add bottom +(Plus icon)
                FloatingActionButton(
                    onClick = {showAddOption = !showAddOption},
                    modifier = Modifier
                        .size(40.dp)
                        .padding(bottom = 8.dp),
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                ){
                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                // Options text
                if(showAddOption){
                    Text(
                        text = "Add image\nAdd voice message\nTake a picture",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // save bottom
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {/* Handle save*/},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
            ){
                Text(
                    text = "Save",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }
    }
    // Date picker dialog(option)
    if(showDatePicker){
        // if need any implementation write in here
        LaunchedEffect(Unit) {
            showDatePicker = false
        }
    }
}