package com.gue.kotlinunit1.data.latihan2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gue.kotlinunit1.R

@Composable
fun ComposeArticle(title: String, text1: String, text2: String, modifier: Modifier = Modifier) {
    val headerImage = painterResource(R.drawable.bg_compose_background)
    Box {

    }
    Column() {
        Image(
            painter = headerImage,
            contentDescription = "Header image",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(all = 16.dp)
        )
        Text(
            text = text1,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(all = 16.dp)
        )
    }
}