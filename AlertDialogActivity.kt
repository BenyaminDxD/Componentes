package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.componentes.ui.theme.ComponentesTheme

class AlertDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploAlertDialog(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploAlertDialog(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE ALERTDIALOG",
            fontSize = 22.sp
        )

        Text("1. AlertDialog básico")
        EjemploAlertDialogBasico()

        Text("2. AlertDialog con título")
        EjemploAlertDialogTitulo()

        Text("3. AlertDialog con confirmar y cancelar")
        EjemploAlertDialogDosBotones()

        Text("4. AlertDialog con icono")
        EjemploAlertDialogIcono()

        Text("5. AlertDialog que ejecuta una acción")
        EjemploAlertDialogAccion()

        Text("6. AlertDialog con opciones para elegir")
        EjemploAlertDialogOpciones()

        Text("7. AlertDialog con campo de texto")
        EjemploAlertDialogTexto()

        Text("8. AlertDialog con colores y forma personalizados")
        EjemploAlertDialogPersonalizado()

        Text("9. AlertDialog para confirmar eliminación")
        EjemploAlertDialogEliminar()
    }
}

// 1. AlertDialog básico
@Composable
fun EjemploAlertDialogBasico() {
    var mostrar by remember { mutableStateOf(false) }

    Button(onClick = { mostrar = true }) {
        Text("Mostrar diálogo")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Aceptar")
                }
            },
            text = { Text("Este es un mensaje de ejemplo.") }
        )
    }
}

// 2. AlertDialog con título
@Composable
fun EjemploAlertDialogTitulo() {
    var mostrar by remember { mutableStateOf(false) }

    Button(onClick = { mostrar = true }) {
        Text("Mostrar con título")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Aviso") },
            text = { Text("Tu sesión se cerrará en 5 minutos.") },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Entendido")
                }
            }
        )
    }
}

// 3. AlertDialog con confirmar y cancelar
@Composable
fun EjemploAlertDialogDosBotones() {
    var mostrar by remember { mutableStateOf(false) }

    Button(onClick = { mostrar = true }) {
        Text("Mostrar con dos botones")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Guardar cambios") },
            text = { Text("¿Quieres guardar los cambios antes de salir?") },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

// 4. AlertDialog con icono
@Composable
fun EjemploAlertDialogIcono() {
    var mostrar by remember { mutableStateOf(false) }

    Button(onClick = { mostrar = true }) {
        Text("Mostrar con icono")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null
                )
            },
            title = { Text("Sin conexión") },
            text = { Text("Revisa tu conexión a internet e inténtalo de nuevo.") },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Reintentar")
                }
            }
        )
    }
}

// 5. AlertDialog que ejecuta una acción
@Composable
fun EjemploAlertDialogAccion() {
    var mostrar by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("Sin decisión") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Resultado: $resultado")
        Button(onClick = { mostrar = true }) {
            Text("Aceptar términos")
        }
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Términos y condiciones") },
            text = { Text("¿Aceptas los términos para continuar?") },
            confirmButton = {
                TextButton(onClick = {
                    resultado = "Aceptado"
                    mostrar = false
                }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    resultado = "Rechazado"
                    mostrar = false
                }) {
                    Text("Rechazar")
                }
            }
        )
    }
}

// 6. AlertDialog con opciones para elegir
@Composable
fun EjemploAlertDialogOpciones() {
    var mostrar by remember { mutableStateOf(false) }
    val opciones = listOf("Español", "Inglés", "Francés")
    var seleccion by remember { mutableStateOf(opciones[0]) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Idioma: $seleccion")
        Button(onClick = { mostrar = true }) {
            Text("Elegir idioma")
        }
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Idioma") },
            text = {
                Column {
                    opciones.forEach { opcion ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { seleccion = opcion }
                        ) {
                            RadioButton(
                                selected = opcion == seleccion,
                                onClick = { seleccion = opcion }
                            )
                            Text(opcion)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Aceptar")
                }
            }
        )
    }
}

// 7. AlertDialog con campo de texto
@Composable
fun EjemploAlertDialogTexto() {
    var mostrar by remember { mutableStateOf(false) }
    var nombre by remember { mutableStateOf("") }
    var saludo by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (saludo.isNotEmpty()) {
            Text("Hola, $saludo")
        }
        Button(onClick = { mostrar = true }) {
            Text("Escribir nombre")
        }
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Tu nombre") },
            text = {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    singleLine = true
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    saludo = nombre
                    mostrar = false
                }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

// 8. AlertDialog con colores y forma personalizados
@Composable
fun EjemploAlertDialogPersonalizado() {
    var mostrar by remember { mutableStateOf(false) }

    Button(onClick = { mostrar = true }) {
        Text("Mostrar personalizado")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            containerColor = Color(0xFF1E3A5F),
            titleContentColor = Color.White,
            textContentColor = Color.LightGray,
            shape = RoundedCornerShape(24.dp),
            properties = DialogProperties(dismissOnClickOutside = false),
            title = { Text("Diálogo azul") },
            text = { Text("Solo se cierra con el botón.") },
            confirmButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Cerrar", color = Color.White)
                }
            }
        )
    }
}

// 9. AlertDialog para confirmar eliminación
@Composable
fun EjemploAlertDialogEliminar() {
    var mostrar by remember { mutableStateOf(false) }
    var eliminado by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(if (eliminado) "Archivo eliminado" else "informe_final.pdf")
        Button(
            onClick = { mostrar = true },
            enabled = !eliminado
        ) {
            Text("Eliminar archivo")
        }
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null
                )
            },
            title = { Text("¿Eliminar archivo?") },
            text = { Text("Esta acción no se puede deshacer.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        eliminado = true
                        mostrar = false
                    },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrar = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}