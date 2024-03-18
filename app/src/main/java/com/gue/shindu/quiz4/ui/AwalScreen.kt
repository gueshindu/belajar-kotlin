package com.gue.shindu.quiz4.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gue.shindu.quiz4.Quiz4AppBar
import com.gue.shindu.quiz4.Quiz4Screen
import com.gue.shindu.quiz4.R
import com.gue.shindu.quiz4.ui.theme.PinkHSITaaruf

@Composable
fun AwalScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("Temukan pasangan melalui ")
            }
            withStyle(style = SpanStyle(color = PinkHSITaaruf)) {
                append("ta’aruf ")
            }
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("membangun rumah tangga ")
            }
            withStyle(style = SpanStyle(color = PinkHSITaaruf)) {
                append("sakinah")
            }
        })
        Button(
            onClick = onNextButtonClicked,
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("NEXT")
        }
    }
}

@Preview
@Composable
fun PreviewAwalScreen()
{
    AwalScreen(onNextButtonClicked = {})    
}