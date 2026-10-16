package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

// En Material 3 el "BadgeBox" se llama BadgedBox
class BadgeBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Titulo("1. BadgedBox básico (punto)")
                        EjemploBadgedBoxBasico()

                        Titulo("2. BadgedBox con número")
                        EjemploBadgedBoxNumero()

                        Titulo("3. BadgedBox con texto")
                        EjemploBadgedBoxTexto()

                        Titulo("4. BadgedBox con color personalizado")
                        EjemploBadgedBoxColor()

                        Titulo("5. BadgedBox con posición ajustada")
                        EjemploBadgedBoxPosicion()

                        Titulo("6. BadgedBox con límite de cantidad")
                        EjemploBadgedBoxLimite()

                        Titulo("7. BadgedBox como contador de carrito")
                        EjemploBadgedBoxCarrito()

                        Titulo("8. BadgedBox dentro de IconButton")
                        EjemploBadgedBoxIconButton()

                        Titulo("9. BadgedBox con animación")
                        EjemploBadgedBoxAnimado()

                        Titulo("10. BadgedBox en una barra de navegación")
                        EjemploBadgedBoxNavegacion()
                    }
                }
            }
        }
    }
}

// 1. BadgedBox básico (punto)
@Composable
fun EjemploBadgedBoxBasico() {
    BadgedBox(
        badge = { Badge() }
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notificaciones"
        )
    }
}

// 2. BadgedBox con número
@Composable
fun EjemploBadgedBoxNumero() {
    BadgedBox(
        badge = {
            Badge { Text("3") }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "3 notificaciones nuevas"
        )
    }
}

// 3. BadgedBox con texto
@Composable
fun EjemploBadgedBoxTexto() {
    BadgedBox(
        badge = {
            Badge { Text("Nuevo") }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "Correo nuevo",
            modifier = Modifier.size(32.dp)
        )
    }
}

// 4. BadgedBox con color personalizado
@Composable
fun EjemploBadgedBoxColor() {
    Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
        BadgedBox(
            badge = {
                Badge(
                    containerColor = Color(0xFF2E7D32),
                    contentColor = Color.White
                ) {
                    Text("5")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Correos",
                modifier = Modifier.size(32.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(containerColor = Color(0xFF3F51B5))
            }
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificaciones",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

// 5. BadgedBox con posición ajustada
@Composable
fun EjemploBadgedBoxPosicion() {
    Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
        BadgedBox(
            badge = { Badge { Text("2") } }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Posición por defecto",
                modifier = Modifier.size(32.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    modifier = Modifier.offset(x = (-6).dp, y = 6.dp)
                ) {
                    Text("2")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Posición ajustada",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

// 6. BadgedBox con límite de cantidad
@Composable
fun EjemploBadgedBoxLimite() {
    var cantidad by remember { mutableIntStateOf(98) }
    val texto = if (cantidad > 99) "99+" else "$cantidad"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BadgedBox(
            badge = {
                Badge { Text(texto) }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Mensajes sin leer",
                modifier = Modifier.size(32.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { cantidad++ }) {
                Text("+1")
            }

            OutlinedButton(onClick = { cantidad = 98 }) {
                Text("Reiniciar")
            }
        }
    }
}

// 7. BadgedBox como contador de carrito
@Composable
fun EjemploBadgedBoxCarrito() {
    var cantidad by remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BadgedBox(
            badge = {
                if (cantidad > 0) {
                    Badge { Text("$cantidad") }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Carrito",
                modifier = Modifier.size(32.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { cantidad++ }) {
                Text("Agregar")
            }

            OutlinedButton(
                onClick = { cantidad = 0 },
                enabled = cantidad > 0
            ) {
                Text("Vaciar")
            }
        }
    }
}

// 8. BadgedBox dentro de IconButton
@Composable
fun EjemploBadgedBoxIconButton() {
    var pendientes by remember { mutableIntStateOf(4) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { pendientes = 0 }) {
            BadgedBox(
                badge = {
                    if (pendientes > 0) {
                        Badge { Text("$pendientes") }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Text(
            text = if (pendientes > 0) "Toca para marcar como leídas" else "Todo al día",
            fontWeight = FontWeight.Bold
        )
    }
}

// 9. BadgedBox con animación
@Composable
fun EjemploBadgedBoxAnimado() {
    var cantidad by remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BadgedBox(
            badge = { BadgeAnimado(cantidad) }
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Mensajes",
                modifier = Modifier.size(32.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { cantidad++ }) {
                Text("Sumar")
            }

            OutlinedButton(onClick = { cantidad = 0 }) {
                Text("Limpiar")
            }
        }
    }
}

// 10. BadgedBox en una barra de navegación
@Composable
fun EjemploBadgedBoxNavegacion() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Mensajes" to Icons.Default.Email,
        "Alertas" to Icons.Default.Notifications
    )
    val avisos = listOf(0, 5, 12)

    NavigationBar {
        items.forEachIndexed { indice, (nombre, icono) ->
            NavigationBarItem(
                selected = seleccionado == indice,
                onClick = { seleccionado = indice },
                icon = {
                    BadgedBox(
                        badge = {
                            if (avisos[indice] > 0) {
                                Badge { Text("${avisos[indice]}") }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = icono,
                            contentDescription = nombre
                        )
                    }
                },
                label = { Text(nombre) }
            )
        }
    }
}

// Badge que aparece y desaparece con animación.
// Va en su propia función para que AnimatedVisibility no quede dentro del Column
// (dentro de un Column, Kotlin intenta usar la versión ColumnScope y da error).
@Composable
private fun BadgeAnimado(cantidad: Int) {
    AnimatedVisibility(visible = cantidad > 0) {
        Badge { Text("$cantidad") }
    }
}