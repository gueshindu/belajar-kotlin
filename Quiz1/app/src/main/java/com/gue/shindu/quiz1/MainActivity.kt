package com.gue.shindu.quiz1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.gue.shindu.quiz1.ui.theme.Quiz1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainDisplay()
                }
            }
        }
    }
}

@Composable
fun MainDisplay() {
    HSISakinah().DisplayQuiz1()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Quiz1Theme {
        MainDisplay()
    }
}

