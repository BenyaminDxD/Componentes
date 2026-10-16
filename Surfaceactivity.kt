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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class SurfaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                // 13. Surface como fondo de la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Titulo("1. Surface básico")
                            EjemploSurfaceBasico()

                            Titulo("2. Surface con color")
                            EjemploSurfaceColor()

                            Titulo("3. Surface con color de contenido personalizado")
                            EjemploSurfaceContentColor()

                            Titulo("4. Surface con forma")
                            EjemploSurfaceForma()

                            Titulo("5. Surface con sombra")
                            EjemploSurfaceSombra()

                            Titulo("6. Surface con elevación tonal")
                            EjemploSurfaceElevacionTonal()

                            Titulo("7. Surface con borde")
                            EjemploSurfaceBorde()

                            Titulo("8. Surface circular")
                            EjemploSurfaceCircular()

                            Titulo("9. Surface clicable")
                            EjemploSurfaceClicable()

                            Titulo("10. Surface deshabilitado")
                            EjemploSurfaceDeshabilitado()

                            Titulo("11. Surface seleccionable")
                            EjemploSurfaceSeleccionable()

                            Titulo("12. Surface con varios elementos")
                            EjemploSurfaceContenido()
                        }
                    }
                }
            }
        }
    }
}

// 1. Surface básico
@Composable
fun EjemploSurfaceBasico() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Este es un Surface básico",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 2. Surface con color
@Composable
fun EjemploSurfaceColor() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "Texto con color automático",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 3. Surface con color de contenido personalizado
@Composable
fun EjemploSurfaceContentColor() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF212121),
        contentColor = Color(0xFFFFC107)
    ) {
        Text(
            text = "Texto amarillo sobre fondo oscuro",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 4. Surface con forma
@Composable
fun EjemploSurfaceForma() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Text(
            text = "Surface con esquinas diferentes",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 5. Surface con sombra
@Composable
fun EjemploSurfaceSombra() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 8.dp
    ) {
        Text(
            text = "Surface con sombra",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 6. Surface con elevación tonal
@Composable
fun EjemploSurfaceElevacionTonal() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        listOf(0.dp, 4.dp, 16.dp).forEach { elevacion ->
            Surface(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                tonalElevation = elevacion
            ) {
                Text(
                    text = "${elevacion.value.toInt()} dp",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

// 7. Surface con borde
@Composable
fun EjemploSurfaceBorde() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(
            text = "Surface con borde rojo",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 8. Surface circular
@Composable
fun EjemploSurfaceCircular() {
    Surface(
        modifier = Modifier.size(64.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Perfil",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

// 9. Surface clicable
@Composable
fun EjemploSurfaceClicable() {
    var toques by remember { mutableIntStateOf(0) }

    Surface(
        onClick = { toques++ },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Text(
            text = "Toques: $toques",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 10. Surface deshabilitado
@Composable
fun EjemploSurfaceDeshabilitado() {
    val habilitado = false

    Surface(
        onClick = {},
        enabled = habilitado,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = if (habilitado) 1f else 0.38f)
    ) {
        Text(
            text = "Surface deshabilitado",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 11. Surface seleccionable
@Composable
fun EjemploSurfaceSeleccionable() {
    val opciones = listOf("Kotlin", "Python", "Java")
    var seleccionada by remember { mutableIntStateOf(0) }

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        opciones.forEachIndexed { indice, nombre ->
            val activa = seleccionada == indice

            Surface(
                selected = activa,
                onClick = { seleccionada = indice },
                shape = RoundedCornerShape(50),
                color = if (activa) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surfaceVariant
            ) {
                Text(
                    text = nombre,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

// 12. Surface con varios elementos
@Composable
fun EjemploSurfaceContenido() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 2.dp,
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Usuario",
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Juan Pérez",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text("Estudiante de Ingeniería")
            }
        }
    }
}