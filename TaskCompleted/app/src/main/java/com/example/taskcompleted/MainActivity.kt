package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.ui.theme.TaskCompletedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskCompletedTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),) { paddingValues ->
                    TaskCompletedApp(
                        text = stringResource(R.string.text_2),
                        quote = stringResource(R.string.quote_1)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletedApp(text: String,quote: String, modifier: Modifier = Modifier) {
    TaskCompleted(
        text_message = text,
        quote = quote
    )
}

@Composable
private fun TaskCompleted(text_message: String, quote: String){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = image,
            contentDescription = null

        )
        Text(
            text = text_message,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            )
        )
        Text(
            text = quote,
            fontSize = 16.sp
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskCompletedTheme {
        TaskCompletedApp(
            text = stringResource(R.string.text_2),
            quote = stringResource(R.string.quote_1)
        )
    }
}