package com.example.nectar.SuccessScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.VerdePersonalizado
import androidx.compose.material3.Button
import androidx.compose.material3.Text



@Composable
fun SuccessScreen(navController: NavController, modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente todo el contenido
        ) {
            // Imagen centrada
            Image(
                painter = painterResource(id = R.drawable.success_icon1),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 16.dp)
            )

            // Texto centrado
            Text(
                text = "Your Order has been accepted",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(), // Asegúrate de que el texto ocupe todo el ancho disponible
                textAlign = TextAlign.Center // Alinea el texto en el centro
            )

            // Texto adicional centrado
            Text(
                text = "Your items have been placed and are on \n" +
                        "their way to being processed",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                textAlign = TextAlign.Center, // Asegura que el texto se centre
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Alinea el texto en el centro
                    .fillMaxWidth()
            )

            // Puedes eliminar el Spacer que empuja los botones hacia abajo
            // Spacer(modifier = Modifier.weight(1f)) // Este empuja los botones hacia abajo

            // Botones uno encima del otro
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón "Track Order" reutilizando BotonPrincipal
                BotonPrincipal(
                    body = "Track Order",
                    color = VerdePersonalizado,
                    onClick = { /* Acción para track order */ }
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espacio reducido entre los botones

                // Botón "Back to Home" reutilizando el botón de popup error
                val customButtonColors = ButtonDefaults.buttonColors(
                    containerColor = Color.White // Color de fondo
                )
                Button(
                    onClick = { navController.navigate(AppScreems.HomeScreen.route) },
                    modifier = Modifier.fillMaxWidth(), // Cambié fillMaxSize() por fillMaxWidth()
                    colors = customButtonColors
                ) {
                    Text(text = "Back to Home", color = Color.Black)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    // Simulamos un NavController
    val mockNavController = rememberNavController()


    SuccessScreen(navController = mockNavController)
}