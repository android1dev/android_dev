package com.example.myapplication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@ExperimentalFoundationApi
@Composable
fun MyTabLayout() {
    val tabTitles = listOf("Tab1", "Tab2") // Naming our tabs
    val pagerState = rememberPagerState(pageCount = tabTitles.size)
    val coroutineScope = rememberCoroutineScope() // launch task

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 4.dp,
                    color = Color.Black
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, fontSize = 18.sp) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> Text("Content of Tab1", modifier = Modifier.fillMaxSize().padding(16.dp))
                1 -> Text("Content of Tab2", modifier = Modifier.fillMaxSize().padding(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun MyTabLayoutPreview() {
    MyTabLayout()
}


