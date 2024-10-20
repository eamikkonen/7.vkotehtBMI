// MainActivity.kt
package com.example.viewmodelbmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viewmodelbmi.ui.theme.ViewmodelBMITheme

class MainActivity : ComponentActivity() {

    // Obtain the ViewModel
    private val viewModel: BMICalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelBMITheme {
                BMICalculatorApp(viewModel)
            }
        }
    }
}

@Composable
fun BMICalculatorApp(viewModel: BMICalculatorViewModel) {
    Surface(color = MaterialTheme.colorScheme.background) {
        BMICalculatorScreen(viewModel)
    }
}

@Composable
fun BMICalculatorScreen(viewModel: BMICalculatorViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Height Input
        OutlinedTextField(
            value = viewModel.heightInput,
            onValueChange = { viewModel.onHeightChange(it) },
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Weight Input
        OutlinedTextField(
            value = viewModel.weightInput,
            onValueChange = { viewModel.onWeightChange(it) },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // BMI Result
        Text(
            text = if (viewModel.bmi.isNotEmpty()) "Your BMI: ${viewModel.bmi}" else "Please enter valid height and weight",
            style = MaterialTheme.typography.titleLarge
        )
    }
}
