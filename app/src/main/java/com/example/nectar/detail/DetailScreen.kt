package com.example.nectar.detail

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.AddItem
import com.example.nectar.BotonPrincipal
import com.example.nectar.CampoExpandible
import com.example.nectar.CustomTopBar
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.VerdePersonalizado


@Composable
@Preview(showBackground = true)
fun DetailScreen(navController: NavController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize()) {
        // CustomTopBar ocupa su espacio en la parte superior
        CustomTopBar(title = "Detail Screen")

        // Agregamos un Spacer para que la CustomTopBar y la Box no se solapen
        Spacer(modifier = Modifier.height(16.dp))

        // Box que ocupa 1/4 de la pantalla
        Box(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho
                .height(250.dp) // Ajusta la altura, que sería aproximadamente 1/4 de una pantalla de móvil típico
                .align(Alignment.CenterHorizontally) // Centra horizontalmente
        ) {
            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "IconDeNectar",
                Modifier
                    .size(400.dp) // Tamaño del ícono dentro de la Box
                    .padding(top = 10.dp)
            )
        }
        Spacer(modifier = Modifier.size(45.dp))

            Descripcion(navController)
    }
}

@Composable
fun Descripcion(navController:NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // Margen general
    ) {
        // Fila para el título y el ícono de corazón a la derecha
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Red Apple",
                style = MaterialTheme.typography.titleLarge, // Estilo para el título
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_like), // Cambia por el recurso del ícono
                contentDescription = "Heart Icon",
                tint = Color.Gray, // Color del ícono
                modifier = Modifier.size(24.dp)
            )
        }

        // Subtítulo debajo del título
        Text(
            text = "1kg, Price",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        // Fila para los botones de cantidad y el precio a la derecha
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Componente para agregar o disminuir cantidad
            AddItem()

            // Precio
            Text(
                text = "$4.99",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
    CampoExpandible()
    CampoExpandible()
    CampoExpandible()
    Spacer(modifier = Modifier.size(25.dp))
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        BotonPrincipal(body = "Add To Basket", color = VerdePersonalizado){
            navController.navigate(AppScreems.HomeScreen.route)
    }
    }

}



