package com.example.birthdayreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.birthdayreminder.ui.theme.BirthdayReminderTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayReminderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BirthdayApp()
                }


            }
        }
    }
}

@Composable
fun BirthdayApp() {
    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        var name by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("")}
        Text(text = "Enter Name")
        TextField(
            value = name,
            onValueChange = { name = it },
            label = {Text(stringResource(R.string.enter_name))}
        )
        Spacer(Modifier.size(16.dp))
        TextField(
            value = date,
            onValueChange =  { date = it},
            label  = { Text( stringResource(R.string.enter_birthdate)) }
        )
        Spacer(Modifier.size(16.dp))
        Row {
            Button(onClick = {}) {
                Text("Add")
            }
            Button(onClick = {}) {
                Text("List")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayAppPreview() {
    BirthdayReminderTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            BirthdayApp()
        }
    }}






