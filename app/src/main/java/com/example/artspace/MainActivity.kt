package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceLayout(
    )
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {

    var index by remember { mutableIntStateOf(1) }

    val image: Int = when (index) {
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        else -> R.drawable.five
    }

    val title: Int = when(index) {
        1 -> R.string.title_1
        2 -> R.string.title_2
        3 -> R.string.title_3
        4 -> R.string.title_4
        else -> R.string.title_5
    }

    val artist: Int = when(index) {
        1 -> R.string.artist_1
        2 -> R.string.artist_2
        3 -> R.string.artist_3
        4 -> R.string.artist_4
        else -> R.string.artist_5
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.6F)
                .shadow(4.dp),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(44.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(modifier = Modifier.background(color = Color(211, 195, 250))) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraLight,
                    lineHeight = 28.sp
                )
                Text(
                    text = stringResource(id = artist),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                index--
                if (index < 1) {
                    index = 5
                }
            }) {
                Text(text = "Previous")
            }
            Button(onClick = {
                index++
                if (index > 5) {
                    index = 1
                }
            }) {
                Text(text = "Next")
            }
        }
    }
}