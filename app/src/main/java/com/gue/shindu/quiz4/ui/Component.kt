package com.gue.shindu.quiz4.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gue.shindu.quiz4.ui.theme.BodyBackground
import com.gue.shindu.quiz4.ui.theme.ButtonColor

@Composable
fun GueButton(
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
)
{
    Button(
        onClick = onClick,
        border = BorderStroke(
            width = Dp.Hairline,
            color = ButtonColor
        ),
        colors = ButtonDefaults.buttonColors(BodyBackground),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = modifier
    ) {
        Text(buttonText)
    }
}

@Composable
fun GambarBulat(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size), onDraw = {
        drawCircle(color = color)
    })

}

