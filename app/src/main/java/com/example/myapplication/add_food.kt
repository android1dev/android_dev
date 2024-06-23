package com.example.myapplication

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.io.File
import java.io.FileOutputStream

@Preview
@Composable
fun AddFoodItemScreenPreview() {
    val context = LocalContext.current
    AddFoodItemScreen(context)
}

@Composable
fun AddFoodItemScreen(context: Context) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val types = listOf("Starters", "Main Course", "Dessert")
    var selectedType by remember { mutableStateOf(types[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Gray), // Set background color to beige
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name", color = Color.Blue) }, // Set text color to blue
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description", color = Color.Blue) }, // Set text color to blue
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price", color = Color.Blue) }, // Set text color to blue
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box {
            OutlinedTextField(
                value = selectedType,
                onValueChange = {},
                readOnly = true,
                label = { Text("Type", color = Color.Blue) }, // Set text color to blue
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Text(
                        text = "\u25BE",
                        color = Color.Blue, // Set text color to blue
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                types.forEach { type ->
                    DropdownMenuItem(onClick = {
                        selectedType = type
                        expanded = false
                    }) {
                        Text(text = type, color = Color.Blue) // Set text color to blue
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Save the food item
                saveFoodItem(context, FoodItem(name, description, price.toDouble(), selectedType))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Save", color = Color.Magenta) // Set text color to blue
        }
    }
}

data class FoodItem(val name: String, val description: String, val price: Double, val type: String)

fun saveFoodItem(context: Context, foodItem: FoodItem) {
    val filename = "food_items.csv"
    val file = File(context.filesDir, filename)
    val foodItemString = "${foodItem.name},${foodItem.description},${foodItem.price},${foodItem.type}\n"
    FileOutputStream(file, true).bufferedWriter().use { writer ->
        writer.write(foodItemString)
    }
}
