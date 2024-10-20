// BMICalculatorViewModel.kt
package com.example.viewmodelbmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMICalculatorViewModel : ViewModel() {

    // Member variables for user input
    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    // Member variable for BMI result
    val bmi: String
        get() = calculateBMI()

    // Methods to update member variables when data changes
    fun onHeightChange(newHeight: String) {
        heightInput = newHeight
    }

    fun onWeightChange(newWeight: String) {
        weightInput = newWeight
    }

    // Private method for calculation
    private fun calculateBMI(): String {
        val height = heightInput.toFloatOrNull()
        val weight = weightInput.toFloatOrNull()
        return if (height != null && weight != null && height > 0f) {
            val bmiValue = weight / (height * height)
            String.format("%.2f", bmiValue)
        } else {
            ""
        }
    }
}
