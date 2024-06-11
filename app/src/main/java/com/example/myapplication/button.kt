package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material3.Button

@Composable
fun Normalbutton(onClick: () -> Unit) {
    Button(onClick = { }) {
        Text(text = "press me")
    }}

@Preview
@Composable
fun PreviewNormalButton() {
    Normalbutton {

    }
}


