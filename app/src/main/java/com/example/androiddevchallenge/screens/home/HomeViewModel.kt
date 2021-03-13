package com.example.androiddevchallenge.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

  private val _plants = MutableLiveData<List<Plant>>()
  val plants: LiveData<List<Plant>>
    get() = _plants

  init {
    _plants.value = plantsList
  }

  fun plantSelectionChanged(plantId: Int, isChecked: Boolean) {
    val currentPlants = _plants.value.orEmpty()
    val updatedPlants = currentPlants
      .map { plant ->
        if (plant.id == plantId) {
          plant.copy(isSelected = isChecked)
        } else {
          plant
        }
      }

    _plants.value = updatedPlants
  }
}
