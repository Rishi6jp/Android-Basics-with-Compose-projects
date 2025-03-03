package com.example.mybusnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusnesscard.ui.theme.MyBusnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBusnessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        name = "Rishi",
                        quote = "To the top, then"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(name: String, quote: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.businesscardpfp)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .fillMaxHeight()
            ) {
        Column(

            modifier = Modifier
                .padding(20.dp)

        ) {
            Image(
                painter = image,
                contentDescription = "avator",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(300.dp)
                    .border(10.dp, Color.Green, CircleShape)
            )
            Column(modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)) {
                Text(
                    text = "@${name}",
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = quote,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Column(modifier.padding(20.dp)
            .align(alignment = Alignment.CenterHorizontally)){
            Details(imageId = R.drawable.phone_call, title = "Phone no", details = "+91 12345 12345")
            Details(imageId = R.drawable.twitter, title = "Twitter Handle", details = "@xyz")
            Details(imageId = R.drawable.email, title = "Email Id", details = "xyz@gmail.com")
        }
    }
}
@Composable
fun Details(imageId: Int,title: String, details: String){
    val image = painterResource(imageId)
    Row {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Column (modifier = Modifier.padding(start = 20.dp)){
            Text(
                text = title
            )
            Text(
                text = details
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusnessCardTheme {
        BusinessCardApp( name = "Rishi", quote = "To the top, then")
    }
}