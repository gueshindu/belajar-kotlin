package com.gue.shindu.quiz4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gue.shindu.quiz4.ui.theme.GueQuiz4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GueQuiz4Theme {
                Quiz4App()
            }
        }
    }
}
