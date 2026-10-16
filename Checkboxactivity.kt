package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class CheckBoxActivity : ComponentActivity() {
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
                        // ---------- CHECKBOX ----------
                        Titulo("1. CheckBox básico")
                        EjemploCheckBoxBasico()

                        Titulo("2. CheckBox con color personalizado")
                        EjemploCheckBoxColores()

                        Titulo("3. CheckBox deshabilitado")
                        EjemploCheckBoxDeshabilitado()

                        Titulo("4. CheckBox con tamaño personalizado")
                        EjemploCheckBoxTamano()

                        Titulo("5. CheckBox con mensaje de estado")
                        EjemploCheckBoxEstado()

                        // ---------- CHECKBOX CON TEXTO ----------
                        Titulo("1. CheckBox con texto básico")
                        EjemploCheckBoxTexto()

                        Titulo("2. CheckBox con texto y fila clicable")
                        EjemploCheckBoxFilaClicable()

                        Titulo("3. CheckBox con texto que cambia de estilo")
                        EjemploCheckBoxTachado()

                        Titulo("4. Lista de opciones con CheckBox")
                        EjemploCheckBoxLista()

                        Titulo("5. CheckBox para aceptar términos")
                        EjemploCheckBoxTerminos()

                        Titulo("6. CheckBox \"Seleccionar todos\"")
                        EjemploCheckBoxSeleccionarTodos()
                    }
                }
            }
        }
    }
}

// =====================================================
// CHECKBOX
// =====================================================

// 1. CheckBox básico
@Composable
fun EjemploCheckBoxBasico() {
    var marcado by remember { mutableStateOf(false) }

    Checkbox(
        checked = marcado,
        onCheckedChange = { marcado = it }
    )
}

// 2. CheckBox con color personalizado
@Composable
fun EjemploCheckBoxColores() {
    var marcado by remember { mutableStateOf(true) }

    Checkbox(
        checked = marcado,
        onCheckedChange = { marcado = it },
        colors = CheckboxDefaults.colors(
            checkedColor = Color(0xFF2E7D32),
            uncheckedColor = Color.Gray,
            checkmarkColor = Color.White
        )
    )
}

// 3. CheckBox deshabilitado
@Composable
fun EjemploCheckBoxDeshabilitado() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Checkbox(
            checked = false,
            onCheckedChange = {},
            enabled = false
        )

        Checkbox(
            checked = true,
            onCheckedChange = {},
            enabled = false
        )
    }
}

// 4. CheckBox con tamaño personalizado
@Composable
fun EjemploCheckBoxTamano() {
    var marcado by remember { mutableStateOf(false) }

    Checkbox(
        checked = marcado,
        onCheckedChange = { marcado = it },
        modifier = Modifier
            .padding(12.dp)
            .scale(1.5f)
    )
}

// 5. CheckBox con mensaje de estado
@Composable
fun EjemploCheckBoxEstado() {
    var marcado by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = if (marcado) "Opción marcada" else "Opción sin marcar",
            fontWeight = FontWeight.Bold
        )

        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it }
        )
    }
}

// =====================================================
// CHECKBOX CON TEXTO
// =====================================================

// 1. CheckBox con texto básico
@Composable
fun EjemploCheckBoxTexto() {
    var marcado by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it }
        )

        Text("Recordar mis datos")
    }
}

// 2. CheckBox con texto y fila clicable
@Composable
fun EjemploCheckBoxFilaClicable() {
    var marcado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = marcado,
                role = Role.Checkbox,
                onValueChange = { marcado = it }
            )
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = marcado,
            onCheckedChange = null
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text("Recibir notificaciones")
    }
}

// 3. CheckBox con texto que cambia de estilo
@Composable
fun EjemploCheckBoxTachado() {
    var hecho by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = hecho,
            onCheckedChange = { hecho = it }
        )

        Text(
            text = "Entregar el trabajo de POO",
            textDecoration = if (hecho) TextDecoration.LineThrough else TextDecoration.None,
            color = if (hecho) Color.Gray else Color.Unspecified
        )
    }
}

// 4. Lista de opciones con CheckBox
@Composable
fun EjemploCheckBoxLista() {
    val opciones = listOf("Kotlin", "Python", "Java", "C++")
    val estados = remember { mutableStateListOf(false, false, false, false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Seleccionados: ${estados.count { it }} de ${opciones.size}")

        opciones.forEachIndexed { indice, nombre ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = estados[indice],
                    onCheckedChange = { estados[indice] = it }
                )

                Text(nombre)
            }
        }
    }
}

// 5. CheckBox para aceptar términos
@Composable
fun EjemploCheckBoxTerminos() {
    var aceptado by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = aceptado,
                onCheckedChange = { aceptado = it }
            )

            Text("Acepto los términos y condiciones")
        }

        Button(
            onClick = {},
            enabled = aceptado
        ) {
            Text("Continuar")
        }
    }
}

// 6. CheckBox “Seleccionar todos”
@Composable
fun EjemploCheckBoxSeleccionarTodos() {
    val opciones = listOf("Pan", "Leche", "Huevos")
    val estados = remember { mutableStateListOf(false, false, false) }

    val estadoGeneral = when {
        estados.all { it } -> ToggleableState.On
        estados.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = estadoGeneral,
                onClick = {
                    val nuevo = estadoGeneral != ToggleableState.On
                    for (i in estados.indices) estados[i] = nuevo
                }
            )

            Text("Seleccionar todos", fontWeight = FontWeight.Bold)
        }

        opciones.forEachIndexed { indice, nombre ->
            Row(
                modifier = Modifier.padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = estados[indice],
                    onCheckedChange = { estados[indice] = it }
                )

                Text(nombre)
            }
        }
    }
}