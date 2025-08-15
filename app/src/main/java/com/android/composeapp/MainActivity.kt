package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.composeapp.ui.theme.ComposeAppTheme

/**
 * Jetpack Compose: A modern toolkit for building native UI
 *
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // Equivalent to setContentView
            ComposeAppTheme { // For applying theme on Application
                Greeting(name = "Android")
            }
        }
    }
}

/**
 * A composable is a regular function that is annotated with the @Composable annotation
 * which produces UI elements based on the input data
 */
@Composable
fun Greeting(name: String) {
    LazyColumn { // For making lazy loading lists (vertically) - items which are not on the screen are not calculated/rendered, just like RecyclerView's behavior in xml
        items(20) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.background(Color.Blue)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Hello $name!",
                        textAlign = TextAlign.Center,
                        color = Color.Blue,
                        fontSize = 24.sp,
                        // Modifier is used to apply changes to the view's appearance
                        modifier = Modifier // Here, functions are called sequentially
                            .padding(16.dp)
                            .wrapContentHeight(Alignment.CenterVertically) // Centers vertically
                    )
                    Icon(
                        imageVector = Icons.Default.AddCircle, contentDescription = null
                    )
                }
                Divider(modifier = Modifier.padding(16.dp))
            }
        }
    }
}

/**
 * For showing UI components on the screen
 * without building and installing the application
 * */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Android")
    }
}