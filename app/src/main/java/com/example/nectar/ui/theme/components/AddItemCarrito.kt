package com.example.nectar.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.ui.theme.grisCarrito
import com.example.nectar.ui.theme.verde
@Composable
fun AddItemCarrito(
    quantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            if (quantity > 0)
                onQuantityChange(quantity - 1) // Decrementar el valor y actualizar
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_minus),
                contentDescription = "Remove item",
                tint = Color.Gray,
                modifier = Modifier
                    .border(2.dp, color = grisCarrito, shape = RoundedCornerShape(30f))
                    .padding(8.dp)
            )
        }
        Text(text = "${quantity}", fontWeight = FontWeight.Bold)
        IconButton(onClick = {
            onQuantityChange(quantity + 1) // Incrementar el valor y actualizar
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_plus),
                contentDescription = "Add item",
                tint = verde,
                modifier = Modifier
                    .border(2.dp, color = grisCarrito, shape = RoundedCornerShape(30f))
                    .padding(8.dp)
            )
        }
    }
}
@Preview (showBackground = true)
@Composable
fun AddItemCarritoPreview(){
    AddItemCarrito(
        quantity = 1,
        onQuantityChange = {}
    )
}