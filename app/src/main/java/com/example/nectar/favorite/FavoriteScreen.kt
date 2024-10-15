package com.example.nectar.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BottomNavigationBar
import com.example.nectar.CustomTopBar
import com.example.nectar.ErrorPopUp.PopupError
import com.example.nectar.R

import com.example.nectar.navigation.AppNavigation
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.VerdePersonalizado
import com.example.nectar.ui.theme.components.Product
import com.example.nectar.ui.theme.lightGrayColor
import com.example.nectar.ui.theme.verde
import kotlinx.coroutines.delay

@Composable
fun ProductScreen(navController: NavController) {
    // Lista de productos de ejemplo
    val sampleProducts = listOf(
        Product(R.drawable.banana, "Bananas", "Verduleria", "1 kg.", 2000),
        Product(R.drawable.servilletas, "Servilletas", "Limpieza", "1 kg.", 2500),
        Product(R.drawable.uvas, "Uvas", "Verduleria", "1 kg.", 2500),
        Product(R.drawable.frutillas, "Frutillas", "Verduleria", "1 kg.", 2500),
        Product(R.drawable.apples, "Mnanzanas", "Verduleria", "1 kg.", 2500)
    )
    var showErrorPopup by remember { mutableStateOf(false) }

    NectarTheme {
        Scaffold(
            topBar = { CustomTopBar("Favoritos") }, // Top Bar
            bottomBar = { BottomNavigationBar(navController) } // Bottom Navigation Bar
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Mostrar la lista de productos
                LazyColumn {
                    items(sampleProducts) { product ->
                        ProductItem(product)
                    }
                }

                // Botón principal
                Button(
                    onClick = { showErrorPopup },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)) // Color verde
                ) {
                    Text(text = "Agregar Todo al Carrito", color = Color.White)
                }
            }
        }
        if (showErrorPopup) {
            PopupError(navController)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Mostrar la imagen del producto
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp)
        )
        // Mostrar el nombre del producto
        Text(
            product.name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f) // Para ocupar el espacio restante
                .align(Alignment.CenterVertically)
        )
        // Ícono de expansión
        IconButton(onClick = { /* Acción al hacer clic en el ícono de expansión */ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight, // Puedes usar otro ícono si lo prefieres
                contentDescription = "Expandir",
                modifier = Modifier.size(24.dp) // Tamaño del ícono
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    // Mock NavController para el Preview
    val navController = rememberNavController()
    ProductScreen(navController)
}
