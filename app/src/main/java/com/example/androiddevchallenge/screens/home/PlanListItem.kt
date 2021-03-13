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

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.ui.components.BloomCheckBox
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PlantListItem(
    modifier: Modifier = Modifier,
    plant: Plant,
    onPlanSelectionChange: (Boolean) -> Unit
) {
  ConstraintLayout(
    constraintSet = constraints(),
    modifier = modifier.height(64.dp)
  ) {
    CoilImage(
      data = plant.image,
      contentDescription = "Plant: ${plant.name}",
      contentScale = ContentScale.Crop,
      fadeIn = true,
      modifier = Modifier
          .layoutId("image")
          .size(64.dp)
          .clip(MaterialTheme.shapes.small)
    )

    BloomCheckBox(
      checked = plant.isSelected,
      onCheckedChange = onPlanSelectionChange,
      modifier = Modifier.layoutId("checkbox")
    )

    Divider(
      modifier = Modifier.layoutId("divider"),
      startIndent = 0.dp
    )

    Text(
      plant.name,
      style = MaterialTheme.typography.h2,
      color = MaterialTheme.colors.onBackground,
      modifier = Modifier
          .layoutId("title")
          .paddingFromBaseline(top = 24.dp),
    )

    Text(
      plant.description,
      style = MaterialTheme.typography.body1,
      color = MaterialTheme.colors.onBackground,
      modifier = Modifier
          .layoutId("description")
          .paddingFromBaseline(bottom = 24.dp)
    )
  }
}

private fun constraints(): ConstraintSet {
  return ConstraintSet {
    val image = createRefFor("image")
    val title = createRefFor("title")
    val description = createRefFor("description")
    val checkbox = createRefFor("checkbox")
    val divider = createRefFor("divider")

    constrain(image) {
      start.linkTo(parent.start)
      top.linkTo(parent.top)
      bottom.linkTo(parent.bottom)
    }

    constrain(checkbox) {
      end.linkTo(parent.end)
      top.linkTo(parent.top)
      bottom.linkTo(parent.bottom)
    }

    constrain(divider) {
      linkTo(start = image.end, end = parent.end, startMargin = 8.dp)
      bottom.linkTo(parent.bottom)

      width = Dimension.fillToConstraints
    }

    constrain(title) {
      linkTo(start = divider.start, end = checkbox.start, startMargin = 16.dp)

      top.linkTo(parent.top)
      bottom.linkTo(description.top)

      width = Dimension.fillToConstraints
    }

    constrain(description) {
      linkTo(start = title.start, end = checkbox.start)

      top.linkTo(title.bottom)
      bottom.linkTo(divider.top)

      width = Dimension.fillToConstraints
    }
  }
}
