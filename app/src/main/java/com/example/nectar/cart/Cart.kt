package com.example.nectar.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.AddItem
import com.example.nectar.BottomNavBarPreview
import com.example.nectar.R
import com.example.nectar.home.TopAppBar
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.components.Product
import org.w3c.dom.Text

data class CartItem(val product: Product, val quantity: Int)

val cartItem = CartItem((Product(R.drawable.banana, "Bananas", "1 kg.", "$2.000")), 4)

val cartItems = listOf(
    CartItem(Product(R.drawable.banana, "Bananas", "1 kg.", "$2.000"), 2),
    CartItem(Product(R.drawable.apples, "Manzana dulce", "1 kg.", "$2.500"), 2)
)

@Preview
@Composable
fun CartScreen() {
    Surface {
        NectarTheme {
            TopAppBar()
            Column(
                modifier = Modifier
                    .fillMaxSize(),

                    //.background(Color.White)
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                        .padding(0.dp,60.dp, 0.dp, 40.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(cartItems) { cartItem ->
                        CartItemRow(cartItem)
                    }
                }
                BottomNavBarPreview()
            }

        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        }
        Text(text = "Shop", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CartItemRow(item: CartItem) {
    Row(
        modifier = Modifier
            .height(80.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
       // horizontalArrangenment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = item.product.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(item.product.name)
            // style = MaterialTheme.typography.h6)
            Text(
                "${item.quantity} pcs, Price",
                //  style = MaterialTheme.typography.body,
                color = Color.Gray
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AddItem()
        }
        Text(
            text = "$${item.product.price}",
            //    style = MaterialTheme.typography.body,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun CheckoutButton(totalPrice: Text) {
    Button(
        onClick = { /* Acción para proceder al pago */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
    ) {
        Text(text = "Go to Checkout - $${totalPrice}")
    }
}




