package com.example.nectar.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import com.example.nectar.BottomNavBarPreview
import com.example.nectar.CustomTopBar
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.components.Product
import com.example.nectar.ui.theme.components.ProductCard
import com.example.nectar.ui.theme.components.sampleProducts
import androidx.compose.foundation.Image as Image


@Composable
fun HomeScreen(navController: NavController) {
    NectarTheme {
        Scaffold (
            topBar = { CustomTopBar("Shop") },
            bottomBar = { BottomNavBarPreview() }
        ){  paddingValues ->
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp,0.dp,10.dp,10.dp)
                        ) {
                            LocationBar()
                            CarouselBanner()
                            ProductSection(
                                title = "Ofertas Exclusivas",
                                products = sampleProducts,
                                navController = navController
                            )
                            ProductSection(
                                title = "Más vendido",
                                products = sampleProducts,
                                navController = navController
                            )
                            ProductSection(
                                title = "Almacén",
                                products = sampleProducts,
                                navController = navController
                            )
                            ProductSection(
                                title = "Verdulería",
                                products = sampleProducts,
                                navController = navController
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun LocationBar() {
    Text(
        text = "Buenos Aires, CABA",
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = Modifier.padding(0.dp,15.dp,8.dp,0.dp)
    )
}

@Composable
fun CarouselBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 8.dp)
    ) {
        // Banner
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
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
                        .width(180.dp) // Ajusta el ancho de cada tarjeta de producto
                        .padding(end = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun homeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}