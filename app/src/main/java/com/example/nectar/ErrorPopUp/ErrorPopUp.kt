package com.example.nectar.ErrorPopUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.VerdePersonalizado

@Composable
fun PopupErrorContent(navController: NavController, showDialog: Boolean) {
    if (showDialog) {
        Box(
            modifier = Modifier
                .size(350.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botón de cerrar en la esquina superior izquierda
                IconButton(
                    onClick = { /* Manejo de cerrar */ },
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_close),
                        contentDescription = "Close",
                        modifier = Modifier.size(14.dp)
                    )
                }

                // Imagen superior (la bolsa de compra)
                Image(
                    painter = painterResource(id = R.drawable.shopping_bag),
                    contentDescription = "Bag",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Oops! Order Failed", fontSize = 18.sp, color = Color.Black)

                Text(
                    text = "Something went terribly wrong.",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botón "Please try again"
                BotonPrincipal(
                    body = "Please try again",
                    color = VerdePersonalizado,
                    onClick = { navController.navigate(AppScreems.HomeScreen.route) }
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Botón "Back to Home"
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

@Composable
fun PopupError(navController: NavController) {
    var showDialog by remember { mutableStateOf(true) }

    PopupErrorContent(navController, showDialog)
}

@Preview(showBackground = true)
@Composable
fun PopupErrorPreview() {
    // Simulamos un NavController
    val mockNavController = rememberNavController()

    // Pasamos el controlador simulado a PopupError
    PopupErrorContent(navController = mockNavController, showDialog = true)
}

