package com.gue.shindu.quiz4.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gue.shindu.quiz4.R
import com.gue.shindu.quiz4.ui.theme.PinkHSITaaruf

@Composable
fun AwalScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxHeight(),
    ) {
        Text(
            buildAnnotatedString {
                val textBlack = SpanStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                val textPink = textBlack.copy(color = PinkHSITaaruf)

                withStyle(style = textBlack) {
                    append(stringResource(R.string.awal_screen_1))
                }
                withStyle(style = textPink) {
                    append(stringResource(R.string.awal_screen_2))
                }
                withStyle(style = textBlack) {
                    append(stringResource(R.string.awal_screen_3))
                }
                withStyle(style = textPink) {
                    append(stringResource(R.string.awal_screen_4))
                }
            },
            lineHeight = 36.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Image(
            alignment = Alignment.Center,
            painter = painterResource(R.drawable.body),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.None,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        )
        GueButton(
            buttonText = stringResource(R.string.mulai),
            onClick = onNextButtonClicked,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

    }
}

@Preview
@Composable
fun PreviewAwalScreen() {
    AwalScreen(onNextButtonClicked = {})
}