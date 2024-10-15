package com.example.nectar.singin
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.navigation.AppScreems
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.VerdePersonalizado


@Composable
@Preview(showBackground = true)
fun LoginPreview(navController: NavController = rememberNavController()) {
    NectarTheme {
        // Crear un NavController falso para la previsualización
        Login(navController)
    }
}


@Composable
fun Login(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {
        // Imagen
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = R.drawable.icon_nectar_fullcolor),
                contentDescription = "IconDeNectar",
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 10.dp)
            )
        }

        // Texto de "Sign In"
        Text(
            text = "Sign In",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp, start = 25.dp)
        )

        // Texto descriptivo
        Text(
            text = "Enter your email and password",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 5.dp, start = 25.dp)
        )

        // Campos de email y contraseña
        CamposEmail()

        // Texto "forgot password?"
        Text(
            text = "forgot password?",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 10.dp, end = 25.dp)
        )

        // Espaciado
        Spacer(modifier = Modifier.padding(15.dp))

        // Botón de inicio de sesión
        Box(modifier = Modifier.padding(horizontal = 20.dp)) {
            BotonPrincipal(
                body = "Sign In",
                color = VerdePersonalizado,
                onClick = { navController.navigate(AppScreems.HomeScreen.route) }
            )
        }

        // Spacer para separar los elementos
        Spacer(modifier = Modifier.height(20.dp))

        // Texto "Don’t have an account?" y "Sign Up" clickeable
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(text = "Don’t have an account?")
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Sign Up",
                color = VerdePersonalizado, // Color personalizado
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    // Navegar a la pantalla de registro
                    navController.navigate(AppScreems.SignUp.route)
                }
            )
        }
    }
}

@Composable
fun CamposEmail() {
    // Estado para almacenar el valor del email y la contraseña
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) } // Para mostrar u ocultar la contraseña

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Primera fila: Campo de texto para el email
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Ingresa tu email") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Segunda fila: Campo de texto para la contraseña
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Contraseña") },
                placeholder = { Text(text = "Ingresa tu contraseña") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_eye),
                        contentDescription = "See password",
                        Modifier.size(20.dp)
                    )
                }
            )
        }
    }
}



