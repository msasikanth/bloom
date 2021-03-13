/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screens.home.HOME_SCREEN
import com.example.androiddevchallenge.screens.home.HomeScreen
import com.example.androiddevchallenge.screens.login.LOGIN_SCREEN
import com.example.androiddevchallenge.screens.login.LoginScreen
import com.example.androiddevchallenge.screens.welcome.WELCOME_SCREEN
import com.example.androiddevchallenge.screens.welcome.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.BloomSecondaryPrimaryTheme
import com.example.androiddevchallenge.ui.theme.BloomTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which means we need to through handling
        // insets
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BloomTheme {
                ProvideWindowInsets {
                    MyApp()
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = WELCOME_SCREEN) {
        composable(WELCOME_SCREEN) { WelcomeScreen(navController = navController) }
        composable(LOGIN_SCREEN) {
            BloomSecondaryPrimaryTheme {
                LoginScreen(navController = navController)
            }
        }
        composable(HOME_SCREEN) { HomeScreen() }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    BloomTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    BloomTheme(darkTheme = true) {
        MyApp()
    }
}
