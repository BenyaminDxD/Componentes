package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class DropdownMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploDropdownMenu(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploDropdownMenu(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE DROPDOWNMENU",
            fontSize = 22.sp
        )

        Text("1. DropdownMenu básico")
        EjemploDropdownMenuBasico()

        Text("2. DropdownMenu con icono de tres puntos")
        EjemploDropdownMenuTresPuntos()

        Text("3. DropdownMenu que cambia el texto del botón")
        EjemploDropdownMenuSeleccion()

        Text("4. DropdownMenu con iconos")
        EjemploDropdownMenuIconos()

        Text("5. DropdownMenu con divisor y opción deshabilitada")
        EjemploDropdownMenuDivisor()

        Text("6. DropdownMenu con lista y marca de selección")
        EjemploDropdownMenuLista()

        Text("7. DropdownMenu con posición y ancho personalizados")
        EjemploDropdownMenuPosicion()

        Text("8. Selector de formulario con ExposedDropdownMenuBox")
        EjemploDropdownMenuFormulario()

        Text("9. DropdownMenu en una barra superior")
        EjemploDropdownMenuBarra()
    }
}

// 1. DropdownMenu básico
@Composable
fun EjemploDropdownMenuBasico() {
    var expandido by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expandido = true }) {
            Text("Abrir menú")
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            DropdownMenuItem(
                text = { Text("Opción 1") },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Opción 2") },
                onClick = { expandido = false }
            )
        }
    }
}

// 2. DropdownMenu con icono de tres puntos
@Composable
fun EjemploDropdownMenuTresPuntos() {
    var expandido by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expandido = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Más opciones"
            )
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            DropdownMenuItem(
                text = { Text("Ver perfil") },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Cerrar sesión") },
                onClick = { expandido = false }
            )
        }
    }
}

// 3. DropdownMenu que cambia el texto del botón
@Composable
fun EjemploDropdownMenuSeleccion() {
    var expandido by remember { mutableStateOf(false) }
    var seleccion by remember { mutableStateOf("Tamaño") }

    Box {
        OutlinedButton(onClick = { expandido = true }) {
            Text(seleccion)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            DropdownMenuItem(
                text = { Text("Pequeño") },
                onClick = {
                    seleccion = "Pequeño"
                    expandido = false
                }
            )
            DropdownMenuItem(
                text = { Text("Mediano") },
                onClick = {
                    seleccion = "Mediano"
                    expandido = false
                }
            )
            DropdownMenuItem(
                text = { Text("Grande") },
                onClick = {
                    seleccion = "Grande"
                    expandido = false
                }
            )
        }
    }
}

// 4. DropdownMenu con iconos
@Composable
fun EjemploDropdownMenuIconos() {
    var expandido by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expandido = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Acciones")
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            DropdownMenuItem(
                text = { Text("Editar") },
                leadingIcon = {
                    Icon(Icons.Default.Edit, contentDescription = null)
                },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Compartir") },
                leadingIcon = {
                    Icon(Icons.Default.Share, contentDescription = null)
                },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Eliminar") },
                leadingIcon = {
                    Icon(Icons.Default.Delete, contentDescription = null)
                },
                onClick = { expandido = false }
            )
        }
    }
}

// 5. DropdownMenu con divisor y opción deshabilitada
@Composable
fun EjemploDropdownMenuDivisor() {
    var expandido by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expandido = true }) {
            Text("Acciones")
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            DropdownMenuItem(
                text = { Text("Editar") },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Duplicar (no disponible)") },
                enabled = false,
                onClick = { }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = { Text("Eliminar") },
                onClick = { expandido = false }
            )
        }
    }
}

// 6. DropdownMenu con lista y marca de selección
@Composable
fun EjemploDropdownMenuLista() {
    var expandido by remember { mutableStateOf(false) }
    val idiomas = listOf("Español", "Inglés", "Francés")
    var seleccion by remember { mutableStateOf(idiomas[0]) }

    Box {
        TextButton(onClick = { expandido = true }) {
            Text("Idioma: $seleccion")
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            idiomas.forEach { idioma ->
                DropdownMenuItem(
                    text = { Text(idioma) },
                    trailingIcon = {
                        if (idioma == seleccion) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Seleccionado"
                            )
                        }
                    },
                    onClick = {
                        seleccion = idioma
                        expandido = false
                    }
                )
            }
        }
    }
}

// 7. DropdownMenu con posición y ancho personalizados
@Composable
fun EjemploDropdownMenuPosicion() {
    var expandido by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expandido = true }) {
            Text("Menú desplazado")
        }

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            offset = DpOffset(0.dp, 8.dp),
            modifier = Modifier.width(200.dp)
        ) {
            DropdownMenuItem(
                text = { Text("Primera opción") },
                onClick = { expandido = false }
            )
            DropdownMenuItem(
                text = { Text("Segunda opción") },
                onClick = { expandido = false }
            )
        }
    }
}

// 8. Selector de formulario con ExposedDropdownMenuBox
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploDropdownMenuFormulario() {
    var expandido by remember { mutableStateOf(false) }
    val opciones = listOf("Rojo", "Verde", "Azul")
    var seleccion by remember { mutableStateOf(opciones[0]) }

    ExposedDropdownMenuBox(
        expanded = expandido,
        onExpandedChange = { expandido = it }
    ) {
        OutlinedTextField(
            value = seleccion,
            onValueChange = { },
            readOnly = true,
            label = { Text("Color") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido)
            },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(opcion) },
                    onClick = {
                        seleccion = opcion
                        expandido = false
                    }
                )
            }
        }
    }
}

// 9. DropdownMenu en una barra superior
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploDropdownMenuBarra() {
    var expandido by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Mi aplicación") },
        actions = {
            IconButton(onClick = { expandido = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Más opciones"
                )
            }

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Configuración") },
                    leadingIcon = {
                        Icon(Icons.Default.Settings, contentDescription = null)
                    },
                    onClick = { expandido = false }
                )
                DropdownMenuItem(
                    text = { Text("Acerca de") },
                    onClick = { expandido = false }
                )
            }
        }
    )
}