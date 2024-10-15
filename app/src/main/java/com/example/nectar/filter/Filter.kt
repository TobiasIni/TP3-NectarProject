package com.example.nectar.filter

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BottomNavBarPreview
import com.example.nectar.CustomTopBar
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.verde
import com.example.nectar.navigation.AppScreems

data class Category(
    val name: String,
    val isSelected: Boolean = false
)

@Composable
fun FilterScreen(navController: NavController) {
    val initialCategories = listOf(
        Category("Almacen", isSelected = false),
        Category("Verduleria", isSelected = true),
        Category("Carniceria", isSelected = false),
        Category("Limpieza", isSelected = false),
        Category("Lacteos", isSelected = false),
        Category("Cocina", isSelected = false),
        Category("Consumo Consciente", isSelected = false),
        Category("Vegetariano/Vegano", isSelected = false)
    )

    // Estado mutable para almacenar el estado de las categorías
    var categoryStates by remember { mutableStateOf(initialCategories) }

    NectarTheme {
        Scaffold(
            topBar = { CustomTopBar("Filtros") },
            bottomBar = { BottomNavBarPreview() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .border(width = 2.dp, color = Color(0xFFDC220), shape = RoundedCornerShape(10.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Para que ocupe el espacio restante
                ) {
                    LazyColumn {
                        items(categoryStates) { category ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                Checkbox(
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF53B175), // Color cuando está marcado
                                        uncheckedColor = Color.Gray, // Color cuando está desmarcado
                                        checkmarkColor = Color.White // Color de la marca de verificación
                                    ),
                                    checked = category.isSelected,
                                    onCheckedChange = { isChecked ->
                                        categoryStates = categoryStates.map {
                                            if (it.name == category.name)
                                                it.copy(isSelected = isChecked)
                                            else it
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = category.name)
                            }
                        }
                    }
                }

                Button(
                    onClick = {
                        // Filtra las categorías seleccionadas
                        val selectedCategories = categoryStates.filter { it.isSelected }

                        // Aquí podrías manejar lo que quieres hacer con las categorías seleccionadas
                        // Por ejemplo, navegar a otra pantalla o mostrar un mensaje
                        navController.navigate(AppScreems.HomeScreen.route) // Navegar a la HomeScreen o a otra pantalla

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = buttonColors(
                        containerColor = verde,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Aplicar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    val navController = rememberNavController()
    FilterScreen(navController = navController)
}
