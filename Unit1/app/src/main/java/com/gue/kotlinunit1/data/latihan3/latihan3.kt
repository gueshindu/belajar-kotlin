package com.gue.kotlinunit1.data.latihan3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gue.kotlinunit1.R

enum class TaskStatus {
    ISCOMPLETE, ISERROR
}


@Composable
fun TaskManager(taskStatus: TaskStatus, modifier: Modifier = Modifier) {
    val statusImage: Painter
    val text1: String
    val text2: String
    when (taskStatus) {
        TaskStatus.ISERROR -> {
            statusImage = painterResource(R.drawable.ic_launcher_foreground)
            text1 = stringResource(R.string.msg_title_error)
            text2 = stringResource(R.string.msg_body_error)
        }
        TaskStatus.ISCOMPLETE -> {
            statusImage = painterResource(R.drawable.ic_task_completed)
            text1 = stringResource(R.string.msg_title_complete)
            text2 = stringResource(R.string.msg_body_complete)
        }
    }
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
            Image(
                painter = statusImage,
                contentDescription = "Status image",
            )
            Text(
                text = text1,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = text2,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}