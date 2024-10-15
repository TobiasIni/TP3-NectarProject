package com.example.nectar.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview (showBackground = true)
@Composable
fun CustomTopBarDetails() {
    TopAppBar(
        title = {
            Text(
                text = "Product Detail")
        },
        navigationIcon = {
            IconButton(onClick = { /* Acción para abrir el menú */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_atras),
                    contentDescription = "Menu")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),

        )
}


