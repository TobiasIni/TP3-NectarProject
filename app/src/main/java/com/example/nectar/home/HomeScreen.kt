package com.example.nectar.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BottomNavigationBar
import com.example.nectar.CustomTopBar
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.components.Product
import com.example.nectar.ui.theme.components.ProductCard
import com.example.nectar.ui.theme.components.sampleProducts
import androidx.compose.foundation.Image as Image


@Composable
fun HomeScreen(navController: NavController) {
    Surface {
        NectarTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CustomTopBar(title = "Shop")
                LocationBar()
                CarouselBanner()
                ProductSection(
                    title = "Exclusive Offer",
                    products = sampleProducts,
                    navController = navController
                )
                ProductSection(
                    title = "Best Selling",
                    products = sampleProducts,
                    navController = navController
                )
                Spacer(modifier = Modifier.weight(0.9f))
                BottomNavigationBar()
            }
        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        }
        Text(text = "Shop", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LocationBar() {
    Text(
        text = "Dhaka, Banassre",
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = Modifier.padding(vertical = 8.dp)
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
                text = "See all",
                fontSize = 14.sp,
                color = Color(0xFF53B175)
            )
        }
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(products) { product ->
                ProductCard(navController = navController,
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
