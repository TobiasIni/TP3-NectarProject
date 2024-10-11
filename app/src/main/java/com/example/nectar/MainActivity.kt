package com.example.nectar

import android.graphics.fonts.FontStyle
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.NectarTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
val verdePersonalizado = Color(0xFF00B36F)

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
    val verdePersonalizado = Color(0xFF00B36F)

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
                containerColor = verdePersonalizado,
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
                containerColor = verdePersonalizado,
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
@Preview(showBackground = true)
fun OnBoardScreen() {
    NectarTheme {
        OnBoard()
    }
}

@Composable
fun OnBoard() {
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
            BotonPrincipal(body = "Get Started", color = verdePersonalizado , onClick = {})
        }
        }
    }



