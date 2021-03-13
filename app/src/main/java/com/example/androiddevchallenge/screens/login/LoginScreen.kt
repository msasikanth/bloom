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
package com.example.androiddevchallenge.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.screens.home.HOME_SCREEN
import com.example.androiddevchallenge.screens.welcome.WELCOME_SCREEN
import com.example.androiddevchallenge.ui.theme.BloomRoundedButtonTheme

const val LOGIN_SCREEN = "login_screen"

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    var emailAddress by mutableStateOf("")
    var password by mutableStateOf("")
    var passwordVisible by mutableStateOf(false)

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login_with_email),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 16.dp)
            )

            LoginEmailAddressTextField(
                value = emailAddress,
                onValueChange = { emailAddress = it },
                placeholder = stringResource(id = R.string.login_email_address)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LoginPasswordTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = stringResource(id = R.string.login_password),
                passwordVisible = passwordVisible,
                passwordToggleClicked = {
                    passwordVisible = passwordVisible.not()
                }
            )

            Text(
                buildAnnotatedString {
                    append("By clicking below, you agree to our ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Terms of Use")
                    }
                    append(" and consent to our ")

                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Privacy Policy")
                    }
                    append(".")
                },
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )

            BloomRoundedButtonTheme {
                LoginButton(
                    onClick = {
                        navController.navigate(HOME_SCREEN) {
                            popUpTo(WELCOME_SCREEN) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 48.dp)
    ) {
        Text(text = stringResource(id = R.string.login))
    }
}

@Composable
fun LoginEmailAddressTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, style = MaterialTheme.typography.body1) },
        singleLine = true,
    )
}

@Composable
fun LoginPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    passwordVisible: Boolean,
    passwordToggleClicked: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, style = MaterialTheme.typography.body1) },
        singleLine = true,
        visualTransformation = if (passwordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = passwordToggleClicked) {
                if (passwordVisible)
                    Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "Hide password")
                else
                    Icon(imageVector = Icons.Filled.Visibility, contentDescription = "Show password")
            }
        }
    )
}
