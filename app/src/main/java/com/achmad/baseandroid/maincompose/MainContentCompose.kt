package com.achmad.baseandroid.maincompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePageCompose(navController: NavController) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "This is a test app for aruna"
    )
}