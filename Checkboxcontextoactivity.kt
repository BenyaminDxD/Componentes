package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class CheckBoxConTextoActivity : ComponentActivity() {
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
                        Titulo("1. Checkbox + Text en un Row")
                        EjemploCheckConTextoBasico()

                        Titulo("2. Texto clickeable (onCheckedChange = null)")
                        EjemploCheckConTextoClickeable()

                        Titulo("3. Toda la fila con toggleable")
                        EjemploCheckConTextoToggleable()

                        Titulo("4. Texto a la izquierda, check a la derecha")
                        EjemploCheckConTextoSpaceBetween()

                        Titulo("5. Colores del check y del texto")
                        EjemploCheckConTextoColores()

                        // ---------- NIVEL 2: con estado ----------
                        Titulo("6. Tarea tachada al marcar")
                        EjemploCheckConTextoTachado()

                        Titulo("7. Aceptar términos habilita el botón")
                        EjemploCheckConTextoTerminos()

                        Titulo("8. Seleccionar todo")
                        EjemploCheckConTextoTodos()

                        Titulo("9. Mostrar lo seleccionado")
                        EjemploCheckConTextoHobbies()
                    }
                }
            }
        }
    }
}

// 1. Checkbox + Text en un Row
@Composable
fun EjemploCheckConTextoBasico() {
    var marcado by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it }
        )
        Text("Recordarme")
    }
}

// 2. Texto clickeable: al tocar el texto también se marca
@Composable
fun EjemploCheckConTextoClickeable() {
    var marcado by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { marcado = !marcado }
    ) {
        Checkbox(
            checked = marcado,
            onCheckedChange = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Toca el texto o el cuadro")
    }
}

// 3. Toda la fila con toggleable (accesible)
@Composable
fun EjemploCheckConTextoToggleable() {
    var marcado by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = marcado,
                onValueChange = { marcado = it },
                role = Role.Checkbox
            )
            .padding(8.dp)
    ) {
        Checkbox(checked = marcado, onCheckedChange = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Fila completa seleccionable")
    }
}

// 4. Texto a la izquierda, check a la derecha
@Composable
fun EjemploCheckConTextoSpaceBetween() {
    var marcado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Recibir notificaciones")
        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it }
        )
    }
}

// 5. Colores del check y del texto
@Composable
fun EjemploCheckConTextoColores() {
    var marcado by remember { mutableStateOf(true) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it },
            colors = CheckboxDefaults.colors(checkedColor = Color.Blue)
        )
        Text(
            text = "Opción azul",
            color = if (marcado) Color.Blue else Color.Gray
        )
    }
}

// =====================================================
// NIVEL 2: CON ESTADO
// =====================================================

// 6. Tarea tachada al marcar
@Composable
fun EjemploCheckConTextoTachado() {
    var hecho by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = hecho,
            onCheckedChange = { hecho = it }
        )
        Text(
            text = "Estudiar Compose",
            textDecoration = if (hecho) TextDecoration.LineThrough else TextDecoration.None
        )
    }
}

// 7. Aceptar términos habilita el botón
@Composable
fun EjemploCheckConTextoTerminos() {
    var acepto by remember { mutableStateOf(false) }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = acepto,
                onCheckedChange = { acepto = it }
            )
            Text("Acepto los términos y condiciones")
        }

        Button(
            onClick = {},
            enabled = acepto
        ) {
            Text("Continuar")
        }
    }
}

// 8. Seleccionar todo
@Composable
fun EjemploCheckConTextoTodos() {
    var a by remember { mutableStateOf(false) }
    var b by remember { mutableStateOf(false) }
    var c by remember { mutableStateOf(false) }

    val todos = a && b && c

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = todos,
                onCheckedChange = { a = it; b = it; c = it }
            )
            Text("Seleccionar todo")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = a, onCheckedChange = { a = it })
            Text("Opción A")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = b, onCheckedChange = { b = it })
            Text("Opción B")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = c, onCheckedChange = { c = it })
            Text("Opción C")
        }
    }
}

// 9. Mostrar lo seleccionado
@Composable
fun EjemploCheckConTextoHobbies() {
    var musica by remember { mutableStateOf(false) }
    var deporte by remember { mutableStateOf(false) }
    var lectura by remember { mutableStateOf(false) }

    val elegidos = buildList {
        if (musica) add("Música")
        if (deporte) add("Deporte")
        if (lectura) add("Lectura")
    }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = musica, onCheckedChange = { musica = it })
            Text("Música")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = deporte, onCheckedChange = { deporte = it })
            Text("Deporte")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = lectura, onCheckedChange = { lectura = it })
            Text("Lectura")
        }

        Text(
            if (elegidos.isEmpty()) "Nada seleccionado"
            else "Elegiste: ${elegidos.joinToString(", ")}"
        )
    }
}