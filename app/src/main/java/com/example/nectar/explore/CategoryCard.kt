package com.example.nectar.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.nectar.ui.theme.lightGrayColor

data class Category (val imageRes: Int, val name: String)

val categories = listOf(
    Category(R.drawable.aceite, "Cooking Oil"),
    Category(R.drawable.frutas, "Fresh Fruits"),
    Category(R.drawable.gaseosas, "Beverages"),
    Category(R.drawable.huevos, "Dairy Eggs"),
    Category(R.drawable.pan, "Bakery"),
    Category(R.drawable.pescado, "Fish"),
)


@Composable
fun CategoryCard(category: Category, navController: NavController, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .width(150.dp)
            .height(180.dp)
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
                painter = painterResource(id = category.imageRes),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )
            Text(
                text = category.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CategoryList(categories: List<Category>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(categories.chunked(2)) { rowCategories ->
            // Creamos una fila para cada grupo de 2 categorías
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Espaciado entre las columnas
            ) {
                rowCategories.forEach { category ->
                    CategoryCard(
                        category = category,
                        navController = navController,
                        modifier = Modifier
                            .weight(1f) // Hace que cada tarjeta ocupe el mismo espacio
                            .padding(0.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
                // Si hay solo un elemento en la fila, agregamos un espacio vacío para el segundo elemento
                if (rowCategories.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryReview(navController: NavController = rememberNavController()) {
    CategoryList(categories = categories, navController = navController)
}