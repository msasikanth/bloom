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
package com.example.androiddevchallenge.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

const val HOME_SCREEN = "home_screen"

@Composable
fun HomeScreen() {
    val paddingBottom = LocalWindowInsets.current.navigationBars.toPaddingValues().calculateBottomPadding()
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(
                top = 40.dp,
                bottom = paddingBottom
            )
            .fillMaxHeight(),
        bottomBar = { HomeScreenBottomNav() },
    ) {
        var searchQuery by mutableStateOf("")

        LazyColumn(modifier = Modifier.padding(bottom = 56.dp)) {
            item {
                HomeSearchFiled(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it }
                )
            }

            item {
                Text(
                    stringResource(id = R.string.browse_themes),
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp)
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )
            }

            item {
                ThemesHorizontalList()
            }

            item {
                HomeGardenHeader(modifier = Modifier.padding(horizontal = 16.dp))
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(plants) { plant ->
                PlantListItem(
                    plant = plant,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
