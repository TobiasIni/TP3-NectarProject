package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.nectar.navigation.AppNavigation
import com.example.nectar.navigation.AppScreens
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.lightGrayColor
import com.example.nectar.ui.theme.verde
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun BotonPrincipal(
    body: String,
    color: Color,
    onClick: () -> Unit
){
    Button( onClick = onClick,
        colors = buttonColors(containerColor = color),
        modifier = Modifier.size(width = 350.dp, height = 60.dp)
    ){
        Text(text = body , fontSize = 20.sp, color = Color.White)
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun addItem() {
    // Estado para almacenar el valor del Int
    var quantity by remember { mutableStateOf(0) }

    Spacer(modifier = Modifier.padding(25.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start, // Centra los elementos en la fila
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón "-"
        Button(
            onClick = {
                if (quantity > 0) quantity-- // Decrementar el valor
            }
        , colors = buttonColors(
                containerColor = verde,
                contentColor = Color.White
            )
        ) {
            Text(text = "-", fontSize = 25.sp)
        }

        Spacer(modifier = Modifier.width(16.dp)) // Espacio entre el botón y el texto

        // Campo de texto que muestra el valor de la cantidad
        Text(
            text = quantity.toString(),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.width(16.dp)) // Espacio entre el texto y el botón

        // Botón "+"
        Button(
            onClick = {
                quantity++ // Incrementar el valor
            },
        colors = buttonColors(
                containerColor = verde,
                contentColor = Color.White
            )
        ) {
            Text(text = "+", fontSize = 18.sp)
        }
    }
}

@Composable
fun ExpandableText(
    title: @Composable () -> Unit, // Parámetro para el título
    body: @Composable () -> Unit,  // Parámetro para el cuerpo
    icon: @Composable (Boolean) -> Unit // Parámetro para el ícono, que recibe el estado expandido
) {
    // Estado que controla si está expandido o no
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Fila con el título y el ícono para expandir/colapsar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }, // Hacer clic en la fila para expandir/colapsar
            verticalAlignment = Alignment.CenterVertically // Alinear el contenido en el centro vertical
        ) {
            // Título proporcionado por el parámetro
            title()

            Spacer(modifier = Modifier.weight(0.5f)) // Espacio entre el título y el ícono

            // Ícono proporcionado por el parámetro, dependiendo del estado de expansión
            icon(expanded)
        }

        // Cuerpo que se expande o colapsa según el estado
        if (expanded) {
            body()
        }
    }
}
@Composable
fun ExampleUsage() {
    ExpandableText(
        title = { Text(text = "My Custom Title", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
        body = {
            Text(
                text = "This is the body content that gets shown when expanded.",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        },
        icon = { expanded ->
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                contentDescription = if (expanded) "Collapse" else "Expand",
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AddItem() {
    NectarTheme {
        Spacer(modifier = Modifier.padding(25.dp))
        addItem()
    }
}

@Preview(showBackground = true)
@Composable
fun CampoExpandible() {
    NectarTheme {
        ExampleUsage()
    }
}

@Preview(showBackground = true)
@Composable
fun Searchbox(){
    NectarTheme {
        SearchBar()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf( value = "" )}
    var active by remember { mutableStateOf(value = false)}
    androidx.compose.material3.SearchBar(
        query = text,
        onQueryChange =  {
            text = it
        },
        onSearch = {
            active = false
        },
        active = active ,
        onActiveChange = {
            active = it
        },
     placeholder = {
         Text(text = "Search")
     },
     leadingIcon = {
         Icon(
             imageVector = Icons.Default.Search, contentDescription = "Search Icon")
     }
    ){

    }
}
@Composable
fun OnBoardPreview(){
    OnBoard(navController = rememberNavController()) //no navegamos
}

@Composable
@Preview(showBackground = true)
fun OnBoardScreen() {
    NectarTheme {
        OnBoardPreview()
    }
}

@Composable
fun OnBoard(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen de fondo desde una URL
        Image(
            painter = painterResource(id = R.drawable.img_onboard),  // Reemplaza con tu imagen
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,  // Ajusta para llenar todo el fondo
            modifier = Modifier.fillMaxSize()
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
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)

            )

            // Botón principal
            BotonPrincipal(body = "Get Started", color = verde , onClick = {navController.navigate(AppScreens.SignInScreen.route)})
        }
        }

    }
@Composable
fun SuccessScreen(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Añadir padding general
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente todo el contenido
        ) {
            // Imagen centrada
            Image(
                painter = painterResource(id = R.drawable.success_icon1),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 100.dp)
            )

            // Texto centrado
            Text(
                text = "Your Order has been accepted",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.CenterHorizontally) // Alinea el texto en el centro

            )
            Text(
                text="Your items has been placed and is on \n" +
                        "it’s way to being processed",
                style = MaterialTheme.typography.labelSmall,
                color= Color.Gray
            )

            // Botones uno encima del otro
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón "Track Order"
                Button(
                    onClick = { /* Acción para track order */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp) // Separación entre los botones
                ) {
                    Text(text = "Track Order", color = Color.White)
                }

                // Botón "Back to Home"
                Button(
                    onClick = { /* Acción para back to home */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Back to Home", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun ThemeSwitcher() {
    // Estado que determina si el tema es oscuro (true) o claro (false)
    var isDarkTheme by remember { mutableStateOf(false) }

    // Definimos los esquemas de colores para los modos oscuro y claro
    val darkColors = darkColorScheme(
        primary = Color(0xFFBB86FC),
        onPrimary = Color.White,
        background = Color(0xFF121212),
        onBackground = Color.White
    )
    val lightColors = lightColorScheme(
        primary = Color(0xFF6200EE),
        onPrimary = Color.White,
        background = Color(0xFFFFFFFF),
        onBackground = Color.Black
    )

    // Aplicamos el tema correspondiente según el estado (oscuro o claro)
    MaterialTheme(colorScheme = if (isDarkTheme) darkColors else lightColors) {
        // Contenedor principal de la pantalla
        Surface(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),  // Añadir padding para separar el contenido de los bordes
                verticalAlignment = Alignment.CenterVertically, // Centra verticalmente los elementos
                horizontalArrangement = Arrangement.SpaceBetween // Distribuye los elementos
            ) {
                // Texto de "Dark mode" alineado a la izquierda
                Text(text = "Dark mode")

                // Agregamos el icono clicable para cambiar el tema, alineado a la derecha
                val icon: Painter = painterResource(id = R.drawable.darkmode_icon)
                Image(
                    painter = icon,
                    contentDescription = "Toggle Dark Mode", // Descripción para accesibilidad
                    modifier = Modifier
                        .size(40.dp) // Ajusta el tamaño del icono si es necesario
                        .clickable {
                            // Al hacer clic, cambiamos entre los temas oscuro y claro
                            isDarkTheme = !isDarkTheme
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewThemeSwitcher() {
    ThemeSwitcher()
}


@Composable
fun SplashScreen(navController:NavHostController){
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack() //no deja volver atras al splash
        navController.navigate(AppScreens.OnBoard.route)
    }

    Splash()
}

@Composable
fun Splash(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF53B175)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center
    ){
        val icon: Painter = painterResource(id = R.drawable.icon_nectar)
        Image(
            painter = icon,
            contentDescription = "Logo Nectar", // Descripción para accesibilidad
            modifier = Modifier
                .size(150.dp,100.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )// Ajusta el tamaño del icono si es necesario

        Text(
            "online groceriet",
            fontSize =10.sp,
            fontWeight=FontWeight.Bold,
            color = Color.White

        )
    }


}

@Preview(showBackground=true)
@Composable
fun SplashScreenPreview(){

    Splash()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { /* Acción para abrir el menú */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),

        )
}

@Preview
@Composable
fun PreviewTopBar() {
    CustomTopBar(title = "Shop")
}

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }

    // Lista de elementos de navegación con títulos y recursos de íconos
    val items = listOf(
        BottomNavItem("Shop", R.drawable.icon_shop),
        BottomNavItem("Explore", R.drawable.icon_search),
        BottomNavItem("Cart", R.drawable.icon_cart),
        BottomNavItem("Favourite", R.drawable.icon_like),
        BottomNavItem("Account", R.drawable.icon_user)
    )

    val selectedColor = Color(0xFF53B175) // Verde oscuro
    val unselectedColor = Color.Black

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.border(1.dp, color = lightGrayColor)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.title,
                        colorFilter = if (selectedItem == index) {
                            ColorFilter.tint(selectedColor) // Cambia a verde si está seleccionado
                        } else {
                            ColorFilter.tint(unselectedColor) // Color original si no está seleccionado
                        }
                    )
                },
                label = { Text(item.title) },
                selected = selectedItem == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    selectedTextColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    unselectedTextColor = unselectedColor.copy(0.7f)
                ),
                onClick = { selectedItem = index }
            )
        }
    }
}


data class BottomNavItem(val title: String, val iconRes: Int)

@Preview
@Composable
fun BottomNavBarPreview(){
    BottomNavigationBar()
}



