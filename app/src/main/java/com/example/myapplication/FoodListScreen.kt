package com.example.myapplication

import FoodItemRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FoodListScreen(foodItems: List<FoodItem>) {
    LazyColumn {
        items(foodItems) { foodItem ->
            FoodItemRow(foodItem)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodListScreen() {
    val sampleItems = listOf(
        FoodItem("Pizza", "Delicious cheese pizza", 9.99, "Main Course"),
        FoodItem("Burger", "Juicy beef burger", 7.99, "Starters"),
        FoodItem("Ice Cream", "Vanilla ice cream", 4.99, "Dessert")
    )
    FoodListScreen(foodItems = sampleItems)
}
