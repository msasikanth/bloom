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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.components.BloomCard
import dev.chrisbanes.accompanist.coil.CoilImage

data class Theme(
    val name: String,
    val image: String
)

val themes = listOf(
    Theme(
        name = "Desert chic",
        image = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
    ),
    Theme(
        name = "Tiny terrariums",
        image = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
    ),
    Theme(
        name = "Jungle vibes",
        image = "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
    ),
    Theme(
        name = "Easy care",
        image = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
    ),
    Theme(
        name = "Statements",
        image = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
    )
)

@Composable
fun ThemesHorizontalList(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.height(168.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(themes) { theme ->
            ThemeItem(
                theme = theme
            )
        }
    }
}

@Composable
fun ThemeItem(
    modifier: Modifier = Modifier,
    theme: Theme
) {
    BloomCard(
        modifier = modifier
            .size(136.dp)
            .clickable { }
    ) {
        Column(Modifier.fillMaxSize()) {
            CoilImage(
                data = theme.image,
                contentScale = ContentScale.Crop,
                contentDescription = "Theme: ${theme.name}",
                fadeIn = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = theme.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
