package com.firatatalay.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firatatalay.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun PacktPublishing(bookName: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Green),
        text = "Title of the book is: $bookName")
}

@Preview(showBackground = true)
@Composable
fun PacktPublishingPreview() {
    PacktPublishing("Android Development with Kotlin")
}



//Column preview
@Composable
fun ColumnComposable() {
    Column {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}
@Preview(showBackground = true)
@Composable
fun ColumnComposablePreview() {
    ColumnComposable()
}

//Column modifiers preview
@Composable
fun ColumnComposableModifiers() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnComposableModifiersPreview() {
    ColumnComposableModifiers()
}




//Row preview
@Composable
fun RowComposable() {
    Row {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun RowComposablePreview() {
    RowComposable()
}

// Row modifiers preview
@Composable
fun RowComposableModifiers() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun RowComposableModifiersPreview() {
    RowComposableModifiers()
}



//Box Preview
@Composable
fun BoxComposable() {
    Box(
        modifier = Modifier
            .size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text(text = "9")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxComposablePreview() {
    BoxComposable()
}



// LazyColumn Preview
@Composable
fun LazyColumnComposable() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnComposablePreview() {
    LazyColumnComposable()
}




// LazyRow Preview
@Composable
fun LazyRowComposable() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowComposablePreview() {
    LazyRowComposable()
}





//LazyVerticalGrid Preview
@Composable
fun LazyVerticalGridComposable() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        columns = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyVerticalGridComposablePreview() {
    LazyVerticalGridComposable()
}



//LazyHorizontalGrid preview
@Composable
fun LazyHorizontalGridComposable() {
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        rows = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyHorizontalGridComposablePreview() {
    LazyHorizontalGridComposable()
}
































































