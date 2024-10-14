package com.example.nectar.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.BotonPrincipal
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.verdePersonalizado


@Composable
@Preview(showBackground = true)
    fun LoginPreview() {
        NectarTheme {
            Login()
        }

    }

@Composable
fun Login() {
    Column (modifier = Modifier.fillMaxSize()
        .padding(top = 100.dp)){
        /*Image(
            painter = painterResource(id = R.drawable.icon_nectar_fullcolor),
            contentDescription = "Login Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )*/
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(painter = painterResource(id = R.drawable.icon_nectar_fullcolor), contentDescription = "IconDeNectar",
                Modifier
                    .size(100.dp)
                    .padding(top = 10.dp))
        }
        Text(
            text = "Sign Up",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp, start = 25.dp))
        Text(
            text = "Enter your credentials to continue",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 5.dp, start = 25.dp)
        )
        CamposEmail()
        Text(
            text = "By continuing you agree to our Terms of Service and Privacy Policy",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 5.dp, start = 25.dp)
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
            BotonPrincipal(body = "Sign Up", color = verdePersonalizado , onClick = {})
            }
        Text(
            text = "Already have an account? SignUp",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, start = 25.dp)
        )

    }
}
@Composable
fun CamposEmail() {
    // Estado para almacenar el valor del email y la contraseña
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
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
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "Ingresa tu nombre de usuario") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        // Segunda fila: Campo de texto para el email
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



