package com.maxmeza.jetpackcatalog.multi_screens.presentation.screen.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxmeza.jetpackcatalog.commom.util.WindowType
import com.maxmeza.jetpackcatalog.commom.util.rememberWindowSize

@Preview(
    device = Devices.PIXEL_5,
    showSystemUi = true
)
@Composable
fun CustomWindowSize(modifier: Modifier = Modifier) {
    val windowSize = rememberWindowSize()

    when(windowSize.width) {
        WindowType.Compact -> {
            // Render one column of list
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.padding(20.dp)
            ) {
                items(40) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.LightGray)
                        .padding(10.dp)
                    ) {
                        Text("Test $it")
                    }
                }
            }
        } else -> {
            // Render 3 columns of list
            LazyVerticalGrid(
                columns = GridCells.Adaptive(220.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.padding(20.dp)
            ) {
                items(40, key = { it }) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .clip(RoundedCornerShape(8.dp))
                    ){
                        Text("Text $it", color = Color.Black)
                    }
                }
            }
        }
    }
}