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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.BloomBottomNav

@Composable
fun HomeScreenBottomNav() {
    BloomBottomNav {
        HomeBottomNavItem(
            icon = Icons.Filled.Home,
            labelRes = R.string.home,
            selected = true,
            onClick = { /*TODO*/ }
        )
        HomeBottomNavItem(
            icon = Icons.Filled.FavoriteBorder,
            labelRes = R.string.favorites,
            selected = false,
            onClick = { /*TODO*/ }
        )
        HomeBottomNavItem(
            icon = Icons.Filled.AccountCircle,
            labelRes = R.string.profile,
            selected = false,
            onClick = { /*TODO*/ }
        )
        HomeBottomNavItem(
            icon = Icons.Filled.ShoppingCart,
            labelRes = R.string.cart,
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun RowScope.HomeBottomNavItem(
    icon: ImageVector,
    @StringRes labelRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = icon, contentDescription = "") },
        label = { Text(stringResource(id = labelRes), style = MaterialTheme.typography.caption) },
        selected = selected,
        onClick = onClick,
    )
}
