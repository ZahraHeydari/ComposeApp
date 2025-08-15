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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        setContent {
            ComposeAppTheme {
                AddNames()
            }
        }
    }
}

@Composable
fun AddNames() {
    val name = remember {
        mutableStateOf("")
    }
    val names = remember {
        mutableStateListOf<String>()
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { text ->
                    name.value = text
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            )
            Button(
                modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp),
                onClick = {
                    names.add(name.value)
                    name.value = ""
                }) {
                Text(
                    text = "Add"
                )
            }
        }
        Spacer(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp))
        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Divider(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp))
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
        AddNames()
    }
}