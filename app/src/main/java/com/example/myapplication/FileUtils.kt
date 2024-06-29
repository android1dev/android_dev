package com.example.myapplication

import android.content.Context
import java.io.File

fun readFoodItems(context: Context): List<FoodItem> {
    val filename = "food_items.csv"
    val file = File(context.filesDir, filename)
    if (!file.exists()) return emptyList()

    return file.readLines().mapNotNull { line ->
        val parts = line.split(",")
        if (parts.size == 4) {
            FoodItem(parts[0], parts[1], parts[2].toDoubleOrNull() ?: 0.0, parts[3])
        } else {
            null
        }
    }
}
