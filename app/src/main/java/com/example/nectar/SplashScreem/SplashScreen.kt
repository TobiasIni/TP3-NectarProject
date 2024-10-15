package com.example.nectar.SplashScreem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Delay de 3 segundos antes de navegar
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()  // No deja volver al splash
        navController.navigate(AppScreems.OnBoard.route)
    }

    Splash()  // Función para mostrar el contenido visual
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF53B175)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val icon: Painter = painterResource(id = R.drawable.icon_nectar)
        Image(
            painter = icon,
            contentDescription = "Logo Nectar", // Descripción para accesibilidad
            modifier = Modifier.size(150.dp, 100.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(
            "online groceriet",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
