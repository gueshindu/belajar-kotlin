package com.gue.kotlinunit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gue.kotlinunit1.data.latihan1.GreetingImage
import com.gue.kotlinunit1.data.latihan2.ComposeArticle
import com.gue.kotlinunit1.data.latihan3.TaskManager
import com.gue.kotlinunit1.data.latihan3.TaskStatus
import com.gue.kotlinunit1.data.latihan4.ComposeQuadrant
import com.gue.kotlinunit1.data.latihan5.BusinessCard
import com.gue.kotlinunit1.ui.theme.KotlinUnit1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinUnit1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    when (5) {
                        1 -> GreetingImage(message = stringResource(R.string.main_text), from = stringResource(R.string.from_text))
                        2 -> ComposeArticle(
                            title = stringResource(R.string.msg_title),
                            text1 = stringResource(R.string.msg_1),
                            text2 = stringResource(R.string.msg_2)
                        )
                        3 -> TaskManager(taskStatus = TaskStatus.ISCOMPLETE)
                        4 -> ComposeQuadrant()
                        5 -> BusinessCard()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinUnit1Theme {
        Greeting("Android")
    }
}