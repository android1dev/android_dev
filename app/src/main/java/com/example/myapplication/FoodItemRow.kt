//package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.FoodItem

data class FoodItem(val name: String, val description: String, val price: Double, val type: String)

@Composable
fun FoodItemRow(foodItem: FoodItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            MyText(text = foodItem.name, style = MaterialTheme.typography.bodyLarge)
            MyText(text = foodItem.description, style = MaterialTheme.typography.bodyMedium)
        }
        MyText(text = "${foodItem.price}", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun MyText(text: String, style: TextStyle) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodItemRow() {
    // Sample food items
    val foodItems = listOf(
        FoodItem("Pizza", "Delicious cheese pizza", 9.99, "Main Course"),
        FoodItem("Burger", "Juicy beef burger", 7.49, "Main Course"),
        FoodItem("Salad", "Fresh garden salad", 5.99, "Appetizer"),
        FoodItem("Ice Cream", "Creamy vanilla ice cream", 3.99, "Dessert")
    )

    Column {
        foodItems.forEach { foodItem ->
            FoodItemRow(foodItem = foodItem)
        }
    }
}
