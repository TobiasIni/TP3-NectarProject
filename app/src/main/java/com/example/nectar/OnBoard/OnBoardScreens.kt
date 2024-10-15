package com.example.nectar.onBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.VerdePersonalizado
import com.example.nectar.ui.theme.lightGrayColor
import com.example.nectar.ui.theme.verde

@Composable
fun OnBoard() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_onboard),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                .size(200.dp)

        )

        // Contenido encima del fondo
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)  // Ajuste para el espacio con la parte inferior
        ) {
            // Icono centrado
            Box(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_nectar_white),
                    contentDescription = "Logo Nectar",
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
            }

            // Título
            Text(
                text = "Welcome",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // Subtítulo
            Text(
                text = "To our store",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Eslogan
            Text(
                text = "Get your groceries in as fast as one hour",
                fontSize = 14.sp,
                color = lightGrayColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)

            )

            // Botón principal
            BotonPrincipal(body = "Get Started", color = verde , onClick = {})
        }
    }
}
@Composable
@Preview(showBackground = true)
fun OnBoardScreens() {
    NectarTheme {
        OnBoard()
    }
}