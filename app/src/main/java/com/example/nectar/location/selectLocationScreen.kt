package com.example.nectar.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.ui.theme.VerdePersonalizado

@Composable
fun LocationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Imagen centrada horizontalmente
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "location_logo",
                modifier = Modifier.size(200.dp)
            )
        }

        // Caja con el título y subtítulo
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(180.dp)
        ) {
            Column {
                // Título
                Text(
                    text = "Select your location",
                    style = MaterialTheme.typography.headlineSmall, // Estilo de título
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp)) // Ajusta el espacio entre los textos

                // Subtítulo
                Text(
                    text = "Switch on your location to stay in tune with what's happening in your area",
                    style = MaterialTheme.typography.bodyMedium, // Estilo de subtítulo
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        // Llamada a la función que muestra las listas desplegables
        ListasDesplegables()
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListasDesplegables() {
    // Estados para los valores seleccionados en ambos desplegables
    var selectedZone by remember { mutableStateOf("Selecciona una zona") }
    var expandedZone by remember { mutableStateOf(false) }

    var selectedArea by remember { mutableStateOf("Selecciona un área") }
    var expandedArea by remember { mutableStateOf(false) }

    // Lista de valores para "Your Zone"
    val zones = listOf("Capital Federal", "Gran Buenos Aires", "Partido de La Matanza")

    // Lista de valores para "Your Area"
    val areas = listOf("Area 1", "Area 2", "Area 3", "Area 4", "Area 5")

    Column(modifier = Modifier.padding(16.dp)) {
        // Dropdown para "Your Zone"
        ExposedDropdownMenuBox(
            expanded = expandedZone,
            onExpandedChange = { expandedZone = !expandedZone }
        ) {
            TextField(
                value = selectedZone,
                onValueChange = {},
                readOnly = true,
                label = { Text("Your Zone") },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),  // Cambiado a .menuAnchor() para la compatibilidad con el menú
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedZone)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expandedZone,
                onDismissRequest = { expandedZone = false }
            ) {
                zones.forEach { zone ->
                    DropdownMenuItem(
                        text = { Text(zone) },
                        onClick = {
                            selectedZone = zone
                            expandedZone = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown para "Your Area"
        ExposedDropdownMenuBox(
            expanded = expandedArea,
            onExpandedChange = { expandedArea = !expandedArea }
        ) {
            TextField(
                value = selectedArea,
                onValueChange = {},
                readOnly = true,
                label = { Text("Your Area") },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedArea)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expandedArea,
                onDismissRequest = { expandedArea = false }
            ) {
                areas.forEach { area ->
                    DropdownMenuItem(
                        text = { Text(area) },
                        onClick = {
                            selectedArea = area
                            expandedArea = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 25.dp))
        BotonPrincipal(body = "Submit", color = VerdePersonalizado, onClick = {})
    }
}




@Composable
@Preview(showBackground = true)
    fun LocationScreenPreview (){
        LocationScreen()
    }

