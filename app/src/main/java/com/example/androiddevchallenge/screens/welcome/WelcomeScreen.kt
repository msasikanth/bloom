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
package com.example.androiddevchallenge.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.screens.login.LOGIN_SCREEN
import com.example.androiddevchallenge.ui.theme.BloomSecondaryPrimaryTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white

const val WELCOME_SCREEN = "welcome_screen"

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    WelcomeScreenBackground {
        Column(
            modifier = Modifier.padding(top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 88.dp, bottom = 48.dp),
                painter = painterResource(id = R.drawable.ic_welcome_illos),
                contentDescription = "Bloom Logo Icon",
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Bloom Logo Text"
            )
            Text(
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                text = stringResource(id = R.string.bloom_login_subtitle),
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center
            )

            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                BloomSecondaryPrimaryTheme {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 48.dp)
                            .padding(bottom = 8.dp),
                    ) {
                        Text(text = stringResource(id = R.string.create_account))
                    }
                }

                TextButton(onClick = { navController.navigate(LOGIN_SCREEN) }, modifier = Modifier.fillMaxWidth()) {
                    val contentColor = if (MaterialTheme.colors.isLight) {
                        pink900
                    } else {
                        white
                    }
                    Text(text = stringResource(id = R.string.login), color = contentColor)
                }
            }
        }
    }
}

@Composable
fun WelcomeScreenBackground(
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxHeight(),
        color = MaterialTheme.colors.primary
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "Welcome background",
            contentScale = ContentScale.Crop
        )
        content()
    }
}
