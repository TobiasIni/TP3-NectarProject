package com.example.nectar.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.BottomNavigationBar
import com.example.nectar.CustomTopBar
import com.example.nectar.R
import com.example.nectar.ThemeSwitcher
import com.example.nectar.navigation.AppScreems

@Composable
@Preview(showBackground = true)
fun AccountPreview(navController: NavController = rememberNavController()) {
    AccountScreen(navController)
}

@Composable
fun AccountScreen(navController: NavController) {
    CustomTopBar(title = "Account")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.size(50.dp))
        // Imagen de perfil, nombre y correo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile_picture), // Imagen de perfil
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Afsar Hossen",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "lmshuvo97@gmail.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }

        // Lista de opciones con imágenes en lugar de íconos
        Column(
            modifier = Modifier
                .weight(1f) // Ocupa el espacio disponible
                .fillMaxWidth()
        ) {
            AccountOption(imageResId = R.drawable.order, title = "Orders")
            AccountOption(imageResId = R.drawable.details, title = "My Details")
            AccountOption(imageResId = R.drawable.ubication, title = "Delivery Address")
            AccountOption(imageResId = R.drawable.creditcard_icon, title = "Payment Methods")
            AccountOption(imageResId = R.drawable.cupon, title = "Promo Cord")
            AccountOption(imageResId = R.drawable.notification, title = "Notifications")
            AccountOption(imageResId = R.drawable.helpicon, title = "Help")

            // Dark mode toggle
            var darkModeEnabled = remember { false } // Estado del modo oscuro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dark mode",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                ThemeSwitcher()
            }
        }

        // Botón de Log Out
        BotonLogout(navController)
        Spacer(modifier = Modifier.size(50.dp))
        BottomNavigationBar(navController)
    }

}

@Composable
fun BotonLogout(navController: NavController) {
    Button(
        onClick = { navController.navigate(AppScreems.SignInScreen.route) },
        colors = ButtonDefaults.buttonColors(
            Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 8.dp) // Espacio entre las opciones y el botón
    ) {
        Text(text = "Log Out")
    }
}

@Composable
fun AccountOption(imageResId: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { /* Acción al hacer clic */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen en lugar de ícono
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}





