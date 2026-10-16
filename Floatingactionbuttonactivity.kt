package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class FloatingActionButtonActivity : ComponentActivity() {
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
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // ---------- NIVEL 1: apariencia ----------
                        Titulo("1. FloatingActionButton básico")
                        EjemploFabBasico()

                        Titulo("2. Colores (containerColor, contentColor)")
                        EjemploFabColores()

                        Titulo("3. Forma (shape)")
                        EjemploFabForma()

                        Titulo("4. Elevación (elevation)")
                        EjemploFabElevacion()

                        Titulo("5. SmallFloatingActionButton")
                        EjemploFabPequeno()

                        Titulo("6. LargeFloatingActionButton")
                        EjemploFabGrande()

                        Titulo("7. ExtendedFloatingActionButton")
                        EjemploFabExtendido()

                        Titulo("8. Extended solo con texto")
                        EjemploFabExtendidoTexto()

                        // ---------- NIVEL 2: con estado ----------
                        Titulo("9. Contador con FAB")
                        EjemploFabContador()

                        Titulo("10. FAB que se expande y se contrae")
                        EjemploFabExpandible()

                        Titulo("11. FAB dentro de un Scaffold (floatingActionButton)")
                        EjemploFabScaffold()
                    }
                }
            }
        }
    }
}

// 1. FAB básico
@Composable
fun EjemploFabBasico() {
    FloatingActionButton(
        onClick = { println("FAB presionado") }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )
    }
}

// 2. Colores
@Composable
fun EjemploFabColores() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color(0xFF2E7D32),
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Editar"
        )
    }
}

// 3. Forma
@Composable
fun EjemploFabForma() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        FloatingActionButton(
            onClick = {},
            shape = CircleShape
        ) {
            Icon(Icons.Default.Add, contentDescription = "Circular")
        }

        FloatingActionButton(
            onClick = {},
            shape = RoundedCornerShape(4.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Casi cuadrado")
        }
    }
}

// 4. Elevación
@Composable
fun EjemploFabElevacion() {
    FloatingActionButton(
        onClick = {},
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 16.dp,
            pressedElevation = 2.dp
        )
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorito"
        )
    }
}

// 5. Pequeño
@Composable
fun EjemploFabPequeno() {
    SmallFloatingActionButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )
    }
}

// 6. Grande
@Composable
fun EjemploFabGrande() {
    LargeFloatingActionButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar",
            modifier = Modifier.size(36.dp)
        )
    }
}

// 7. Extendido (icono + texto)
@Composable
fun EjemploFabExtendido() {
    ExtendedFloatingActionButton(
        onClick = {},
        icon = { Icon(Icons.Default.Add, contentDescription = "Agregar") },
        text = { Text("Nuevo") }
    )
}

// 8. Extendido solo con texto
@Composable
fun EjemploFabExtendidoTexto() {
    ExtendedFloatingActionButton(
        onClick = {},
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Text("Continuar")
    }
}

// =====================================================
// NIVEL 2: CON ESTADO
// =====================================================

// 9. Contador con FAB
@Composable
fun EjemploFabContador() {
    var contador by remember { mutableStateOf(0) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        FloatingActionButton(onClick = { contador++ }) {
            Icon(Icons.Default.Add, contentDescription = "Sumar")
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text("Contador: $contador")
    }
}

// 10. FAB que se expande (con texto) y se contrae (solo icono)
@Composable
fun EjemploFabExpandible() {
    var expandido by remember { mutableStateOf(true) }

    ExtendedFloatingActionButton(
        onClick = { expandido = !expandido },
        expanded = expandido,
        icon = { Icon(Icons.Default.Edit, contentDescription = "Editar") },
        text = { Text("Editar") }
    )
}

// 11. FAB dentro de un Scaffold
@Composable
fun EjemploFabScaffold() {
    var veces by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.height(220.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = { veces++ }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Presionaste el FAB $veces veces")
        }
    }
}