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
import com.example.nectar.R
import com.example.nectar.ui.theme.lightGrayColor
import com.example.nectar.ui.theme.verde

data class Product(val imageRes: Int, val name: String, val details: String, val price: String)

val sampleProducts = listOf(
    Product(R.drawable.banana, "Bananas", "1 kg.", "$2.000"),
    Product(R.drawable.apples, "Manzana dulce", "1 kg.", "$1.800"),
    Product(R.drawable.banana, "Frutillas", "1 kg.", "$2.500")
)

val product = Product(R.drawable.banana, "Bananas", "1 kg.", "$2.000")

    @Composable
    fun ProductCard(product: Product, modifier: Modifier = Modifier) {
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
                        text = product.price,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold

                    )

                    Button(
                        onClick = {

                        },
                        modifier = Modifier.size(60.dp),
                        colors = buttonColors(
                            containerColor = verde,
                            contentColor = Color.White
                        ),
                        ) {
                        Text(
                            text = "+",
                            fontSize = 18.sp,
                            //modifier = Modifier.align(Arrangement.)
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ProductPreview() {
        ProductCard(product = product)
    }

    @Composable
    fun ProductList(products: List<Product>, modifier: Modifier = Modifier) {
        LazyRow(modifier = modifier.padding(16.dp)) {
            items(products) { product ->
                ProductCard(
                    product = product,
                    modifier = Modifier.padding(0.dp, 0.dp,8.dp,0.dp))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ProductListPreview() {
        ProductList(products = sampleProducts)
    }
