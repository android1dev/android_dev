package com.example.myapplication


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource

@Composable
fun MyImage(){
    val image= painterResource(id = R.drawable.ic_launcher_background)
    Image(painter = image, contentDescription = null )
}