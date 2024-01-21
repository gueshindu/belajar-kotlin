package com.gue.kotlinunit1.data.latihan4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {

    Column  {
        Row(
            modifier = modifier.fillMaxSize().weight(1F)
        ) {
            IsiContent(
                judul = "Text composable",
                isi = "Displays text and follows the recommended Material Design guidelines.",
                Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            IsiContent(
                judul = "Image composable",
                isi = "Creates a composable that lays out and draws a given Painter class object.",
                Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = modifier.fillMaxSize().weight(1F)
        ) {
            IsiContent(
                judul = "Row composable",
                isi = "A layout composable that places its children in a horizontal sequence.",
                Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            IsiContent(
                judul = "Column composable",
                isi = "A layout composable that places its children in a vertical sequence.",
                Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }

}

@Composable
fun IsiContent(judul: String, isi: String, bgColor: Color,  modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =  modifier.background(bgColor)
            .fillMaxHeight()
            .padding(all = 16.dp)
    ) {
        Text(
            text = judul,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = isi,
            textAlign = TextAlign.Justify,
        )
    }
}