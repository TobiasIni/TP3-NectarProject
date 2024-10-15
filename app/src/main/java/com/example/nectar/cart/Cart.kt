package com.example.nectar.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.BottomNavBarPreview
import com.example.nectar.CustomTopBar
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.components.AddItemCarrito
import com.example.nectar.ui.theme.components.Product
import com.example.nectar.ui.theme.grisCarrito
import com.example.nectar.ui.theme.verde


data class CartItem(val product: Product, var quantity: Int)

val sampleCartItems = listOf(
    CartItem((Product(R.drawable.banana, "Bananas", "Verduleria","1 kg.", 2000)), 2),
    CartItem(Product(R.drawable.servilletas, "Servilletas", "Limpieza", "1 kg.", 2500), 4),
    CartItem(Product(R.drawable.uvas, "Uvas", "Verduleria","1 kg.", 2500), 2),
    CartItem(Product(R.drawable.frutillas, "Frutillas", "Verduleria", "1 kg.", 2500),1)
)

@Preview
@Composable
fun CartScreen() {
    var cartItems by remember { mutableStateOf(sampleCartItems.toMutableList()) } // La lista de items en el carrito

    NectarTheme {
        Scaffold(
            topBar = { CustomTopBar("Carrito") },
            bottomBar = { BottomNavBarPreview() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(grisCarrito, shape = RoundedCornerShape(20f, 20f))
                    .border(0.dp, color = grisCarrito, shape = RoundedCornerShape(20f, 20f))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(cartItems) { cartItem ->
                        CartItemRow(
                            item = cartItem,
                            onQuantityChange = { newQuantity ->
                                if (newQuantity > 0) {
                                    cartItems = cartItems.map {
                                        if (it.product == cartItem.product) it.copy(quantity = newQuantity) else it
                                    }.toMutableList()
                                } else {
                                    cartItems = cartItems.filter { it.product != cartItem.product }.toMutableList()
                                }
                            }
                        )
                    }
                }
                CheckoutButton(totalPrice = SumarPrecios(cartItems))
            }
        }
    }
}

fun SumarPrecios(cartItems: List<CartItem>): Int {
    return cartItems.sumOf { it.product.price.toInt() * it.quantity }
}

@Composable
fun CartItemRow(
    item: CartItem,
    onQuantityChange: (Int) -> Unit
) {
//    var quantity by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .border(1.dp, color = grisCarrito, shape = RoundedCornerShape(10f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = item.product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
            )
            Column(modifier = Modifier
                .weight(1f)
            ) {
                Text(
                    item.product.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "${item.product.details}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 10.dp)

            ) {
               AddItemCarrito(
                    quantity = item.quantity,
                   onQuantityChange = onQuantityChange
               )

            Text(
                text = "$${item.product.price}",
                modifier = Modifier.padding(start = 5.dp)
                    .padding(end = 16.dp),
                fontWeight = FontWeight.Bold
            )}
        }
    }
}


@Composable
fun CheckoutButton(totalPrice: Int) {
    Button(
        onClick = { /* Acción para proceder al pago */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = verde)
    ) {
        Text(text = "Finalizar compra - $${totalPrice}")
    }
}





