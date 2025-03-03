package com.example.artspaceapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp( modifier: Modifier = Modifier) {
    var image by remember { mutableStateOf(1) }
    var currentImage = when(image){
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        5 -> R.drawable.image5
        else -> R.drawable.image6

    }
    var title by remember { mutableStateOf(1) }
    var currentTitle = when(title){
        1 -> R.string.title1
        2 -> R.string.title2
        3 -> R.string.title3
        4 -> R.string.title4
        5 -> R.string.title5
        else -> R.string.title6
    }
    var date by remember { mutableStateOf(1) }
    var currentDate = when(title){
        1 -> R.string.month1
        2 -> R.string.month2
        3 -> R.string.month3
        4 -> R.string.month4
        5 -> R.string.month5
        else -> R.string.month6
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(40.dp))
        Image(
            painter = painterResource(currentImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp))

        )

        Column (modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .padding(16.dp)) {
            Text(
                text = stringResource(currentTitle),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier
            )
            Text(
                text = stringResource(currentDate),
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.End)

            )
        }

        Row (modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)){
            Button(onClick = { if(image!=1){
                image--
                title--
                date--
            } else{
                image = 6
                title = 6
                date = 6
            } },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE60023)
                ),
                contentPadding = PaddingValues(18.dp)) {
                Text(text = stringResource(R.string.previous), fontSize = 25.sp)
            }
            Button(onClick = {
                if(image!=6){
                image++
                title++
                    date++
            } else{
                image = 1
                    title = 1
                    date = 1
            } },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE60023)
                ),
                contentPadding = PaddingValues(18.dp)
            ) {
                Text(text = stringResource(R.string.next), fontSize = 25.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}