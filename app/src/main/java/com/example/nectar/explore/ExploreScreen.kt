package com.example.nectar.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BottomNavigationBar
import com.example.nectar.CustomTopBar
import com.example.nectar.SearchBar
import com.example.nectar.ui.theme.components.Product
import com.example.nectar.ui.theme.components.ProductCard
import com.example.nectar.ui.theme.components.ProductList




@Composable
fun Explore(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        CustomTopBar(title = "Explore")
        Spacer(modifier = Modifier.size(4.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            SearchBar()
        }
        Spacer(modifier = Modifier.size(4.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            CategoryList(categories = categories, navController = navController)
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
            BottomNavigationBar(navController)
        }
    }
}

@Composable
fun ProductSection(title: String, products: List<Product>, navController: NavController) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ver más",
                fontSize = 14.sp,
                color = Color(0xFF53B175)
            )
        }
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(products) { product ->
                ProductCard(
                    navController = navController,
                    product = product,
                    modifier = Modifier
                        .width(100.dp)
                        .height(20.dp)// Ajusta el ancho de cada tarjeta de producto
                        .padding(end = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview(){
    Explore(navController = rememberNavController())
}