package com.example.nectar.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.lightGrayColor
import com.example.nectar.ui.theme.verde

data class Product(val imageRes: Int, val name: String, val categoria: String, val details: String, val price: Int)

val sampleProducts = listOf(
    Product(R.drawable.banana, "Bananas", "Verduleria", "1 kg.", 2000),
    Product(R.drawable.apples, "Manzana dulce", "Verduleria", "1 kg.", 1800),
    Product(R.drawable.frutillas, "Frutillas", "Verduleria", "1 kg.", 2500),
    Product(R.drawable.lentejas, "Lentejas", "Almacen", "1 kg.", 2500),
    Product(R.drawable.servilletas, "Servilletas", "Limpieza", "1 kg.", 2500),
    Product(R.drawable.uvas, "Uvas", "Verduleria","1 kg.", 2500),
    Product(R.drawable.uvas, "Uvas", "Verduleria","1 kg.", 2500),
    Product(R.drawable.uvas, "Uvas", "Verduleria","1 kg.", 2500)
)

val product = Product(R.drawable.banana, "Bananas", "Verduleria","1 kg.", 2000)

@Composable
fun ProductCard(product: Product, navController: NavController, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .width(150.dp)
            .height(225.dp)
            .border(1.dp, lightGrayColor, shape = RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp, 10.dp, 16.dp, 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )
            Text(
                text = product.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.details,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .width(150.dp)
                    .height(90.dp)
                    .padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${product.price}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = {
                        navController.navigate(AppScreems.DetailsScreen.route)
                    },
                    modifier = Modifier.size(60.dp),
                    colors = buttonColors(
                        containerColor = verde,
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = "+",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview(navController: NavController = rememberNavController()) {
    ProductCard(product = product, navController = navController)
}

@Composable
fun ProductList(products: List<Product>, navController: NavController, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier.padding(16.dp)) {
        items(products) { product ->
            ProductCard(
                product = product,
                navController = navController, // Asegúrate de pasar navController aquí
                modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListPreview(navController: NavController = rememberNavController()) {
    ProductList(products = sampleProducts, navController = navController)
}
