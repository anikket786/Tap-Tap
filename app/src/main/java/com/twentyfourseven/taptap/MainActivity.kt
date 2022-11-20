package com.twentyfourseven.taptap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.twentyfourseven.designsystem.theme.WhiteTheme
import com.twentyfourseven.taptap.ui.Greeting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhiteTheme {
                // A surface container using the 'background' color from the theme
                Greeting("Android")
            }
        }
    }
}