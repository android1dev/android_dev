package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        MainScreen()
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopAppBar(title = { tu("Tab Layout Example") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Add functionality */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            val tabTitles = listOf("Tab 1", "Tab 2", "Food List", "Add Food Item")
            TabRow(selectedTabIndex = pagerState.currentPage) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        text = { tu(title) }, // Use Text directly without qualification
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.scrollToPage(index)
                            }
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                count = tabTitles.size
            ) { page ->
                when (page) {
                    0 -> FirstTabScreen()
                    1 -> SecondTabScreen()
                    2 -> FoodListScreen()
                    3 -> AddFoodItemScreen()
                    else -> {} // Handle additional cases if needed
                }
            }
        }
    }
}

fun tu(type: String) {

}

@Composable
fun FirstTabScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyText("This is the first tab", MaterialTheme.typography.bodyMedium) // Use MyText instead of Text for custom public access
    }
}

@Composable
fun SecondTabScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyText("This is the second tab", MaterialTheme.typography.bodyMedium) // Use MyText instead of Text for custom public access
    }
}

@Composable
fun FoodListScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyText("Food List Screen", MaterialTheme.typography.bodyMedium) // Use MyText instead of Text for custom public access
    }
}

@Composable
fun AddFoodItemScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyText("Add Food Item Screen", MaterialTheme.typography.bodyMedium) // Use MyText instead of Text for custom public access
    }
}

@Composable
fun MyText(text: String, style: TextStyle) {
    tu(text) // Define a public wrapper function for Text
}
