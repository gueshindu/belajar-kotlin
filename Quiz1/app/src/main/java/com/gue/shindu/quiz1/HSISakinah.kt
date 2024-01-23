package com.gue.shindu.quiz1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gue.shindu.quiz1.ui.theme.BlueBottomButton
import com.gue.shindu.quiz1.ui.theme.BodyBackground
import com.gue.shindu.quiz1.ui.theme.ButtonColor
import com.gue.shindu.quiz1.ui.theme.DisableColor

class HSISakinah {
    @Composable
    fun DisplayQuiz1() {
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(73.dp))
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(width = 100.dp)
                )
                Spacer(Modifier.height(21.dp))
                Body()
            }
            BottomPart()
        }
    }

    @Composable
    fun Body() {
        Box (
            modifier = Modifier
                .background(
                    color = BodyBackground,
                    shape = RoundedCornerShape(size = 18.dp)
                )
                .padding(all = 24.dp)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(R.string.title_text),
                    style = MaterialTheme.typography.titleSmall,
                    modifier =  Modifier.padding(all = 16.dp)
                )
                Text(
                    text = stringResource(R.string.body_text),
                    style = MaterialTheme.typography.headlineSmall
                )
                Image(
                    painter = painterResource(R.drawable.cv),
                    contentDescription = "Logo cv"
                )
                Spacer(modifier = Modifier.height(9.dp))
                TwoButton()


            }
        }
    }

    @Composable
    fun TwoButton() {
        Row {
            Button(
                onClick = {},
                border =  BorderStroke(
                    width = Dp.Hairline,
                    color = ButtonColor
                ),
                colors = ButtonDefaults.buttonColors(BodyBackground),
                shape = RoundedCornerShape(size = 12.dp),
                modifier = Modifier.width(110.dp)

            ) {
                Text(
                    text = stringResource(R.string.btn_lewati),
                    color = ButtonColor,
                )
            }
            Spacer(modifier = Modifier.width(9.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(ButtonColor),
                shape = RoundedCornerShape(size = 12.dp),
                modifier = Modifier.width(110.dp)

            ) {
                Text(
                    text = stringResource(R.string.btnIsi),
                    color = BodyBackground,
                )

            }

        }
    }


    @Composable
    fun BottomPart() {
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val gap = Modifier.width(20.dp)
            ButtonWithIcon(Icons.Outlined.Home, buttonText = stringResource(R.string.btn_home), enable = true)
            Spacer(gap)
            ButtonWithIcon(Icons.Outlined.Search, buttonText = stringResource(R.string.btn_search))
            Spacer(gap)
            ButtonWithIcon(Icons.Rounded.Person, buttonText = stringResource(R.string.btn_profile))
        }
    }

    @Composable
    fun ButtonWithIcon(icon: ImageVector, buttonText: String, enable: Boolean = false) {
        val btnColor = if (enable) BlueBottomButton else DisableColor

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector =icon, contentDescription = buttonText, tint = btnColor )
            Text(buttonText, color = btnColor)

        }
    }



}