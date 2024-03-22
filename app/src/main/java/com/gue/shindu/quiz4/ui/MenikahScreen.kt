package com.gue.shindu.quiz4.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gue.shindu.quiz4.R

@Composable
fun MenikahScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxHeight(),
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            alignment = Alignment.Center,
            painter = painterResource(R.drawable.menikah),
            contentDescription = stringResource(R.string.menikah),
            contentScale = ContentScale.None,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                stringResource(R.string.menikah_title),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.menikah_body),
                textAlign = TextAlign.Center)
        }
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
fun PreviewMenikahScreen()
{
    MenikahScreen(onNextButtonClicked = {})
}