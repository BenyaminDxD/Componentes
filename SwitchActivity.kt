package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class SwitchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploSwitchGuia(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploSwitchGuia(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DE SWITCH",
            fontSize = 22.sp
        )

        Text("1. Switch básico")
        EjemploSwitchBasico()

        Text("2. Switch con texto")
        EjemploSwitchTexto()

        Text("3. Switch con mensaje de estado")
        EjemploSwitchEstado()

        Text("4. Switch con colores personalizados")
        EjemploSwitchColores()

        Text("5. Switch deshabilitado")
        EjemploSwitchDeshabilitado()

        Text("6. Switch con icono")
        EjemploSwitchIcono()

        Text("7. Switch que controla otro componente")
        EjemploSwitchControlaCampo()

        Text("8. Switch con fondo que cambia")
        EjemploSwitchFondo()

        Text("9. Lista de opciones con Switch")
        EjemploSwitchLista()

        Text("10. Switch con fila completa clicable")
        EjemploSwitchFilaClicable()
    }
}

// 1. Switch básico
@Composable
fun EjemploSwitchBasico() {
    var activado by remember { mutableStateOf(false) }

    Switch(
        checked = activado,
        onCheckedChange = { activado = it }
    )
}

// 2. Switch con texto
@Composable
fun EjemploSwitchTexto() {
    var activado by remember { mutableStateOf(true) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Notificaciones")

        Spacer(modifier = Modifier.width(8.dp))

        Switch(
            checked = activado,
            onCheckedChange = { activado = it }
        )
    }
}

// 3. Switch con mensaje de estado
@Composable
fun EjemploSwitchEstado() {
    var activado by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = if (activado) "Wi-Fi activado" else "Wi-Fi desactivado",
            fontWeight = FontWeight.Bold
        )

        Switch(
            checked = activado,
            onCheckedChange = { activado = it }
        )
    }
}

// 4. Switch con colores personalizados
@Composable
fun EjemploSwitchColores() {
    var activado by remember { mutableStateOf(true) }

    Switch(
        checked = activado,
        onCheckedChange = { activado = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Color(0xFF2E7D32),
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color.Gray,
            uncheckedBorderColor = Color.Gray
        )
    )
}

// 5. Switch deshabilitado
@Composable
fun EjemploSwitchDeshabilitado() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Desactivado y bloqueado")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = false,
                onCheckedChange = {},
                enabled = false
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Activado y bloqueado")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = true,
                onCheckedChange = {},
                enabled = false
            )
        }
    }
}

// 6. Switch con icono
@Composable
fun EjemploSwitchIcono() {
    var activado by remember { mutableStateOf(false) }

    Switch(
        checked = activado,
        onCheckedChange = { activado = it },
        thumbContent = {
            Icon(
                imageVector = if (activado) Icons.Default.Check else Icons.Default.Close,
                contentDescription = if (activado) "Activado" else "Desactivado",
                modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        }
    )
}

// 7. Switch que controla otro componente
@Composable
fun EjemploSwitchControlaCampo() {
    var activado by remember { mutableStateOf(false) }
    var correo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Recibir correos")

            Switch(
                checked = activado,
                onCheckedChange = { activado = it }
            )
        }

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            enabled = activado,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// 8. Switch con fondo que cambia
@Composable
fun EjemploSwitchFondo() {
    var oscuro by remember { mutableStateOf(false) }

    val fondo by animateColorAsState(
        targetValue = if (oscuro) Color(0xFF212121) else Color(0xFFFFF8E1),
        label = "fondo"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(fondo)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (oscuro) "Modo oscuro" else "Modo claro",
                color = if (oscuro) Color.White else Color.Black
            )

            Switch(
                checked = oscuro,
                onCheckedChange = { oscuro = it }
            )
        }
    }
}

// 9. Lista de opciones con Switch
@Composable
fun EjemploSwitchLista() {
    val opciones = listOf("Notificaciones", "Sonido", "Vibración", "Ubicación")
    val estados = remember { mutableStateListOf(true, true, false, false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        opciones.forEachIndexed { indice, nombre ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(nombre)

                Switch(
                    checked = estados[indice],
                    onCheckedChange = { estados[indice] = it }
                )
            }
        }
    }
}

// 10. Switch con fila completa clicable
@Composable
fun EjemploSwitchFilaClicable() {
    var activado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = activado,
                role = Role.Switch,
                onValueChange = { activado = it }
            )
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Guardar sesión")

        Switch(
            checked = activado,
            onCheckedChange = null
        )
    }
}