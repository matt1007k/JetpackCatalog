package com.maxmeza.jetpackcatalog.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true
)
@Composable
private fun StatePreview() {
    CounterExample1()
}

@Composable
fun CounterExample1(modifier: Modifier = Modifier) {
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Sumar")
        }
        Text("Contador 1 $counter", color = Color.DarkGray)
        Text("Contador 2 $counter", style = TextStyle(
            fontFamily = FontFamily.Cursive
        ))
    }
}