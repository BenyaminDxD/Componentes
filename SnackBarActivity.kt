package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlinx.coroutines.launch

class SnackBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploSnackbar(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploSnackbar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE SNACKBAR",
            fontSize = 22.sp
        )

        Text("1. SnackBar básico")
        EjemploSnackbarBasico()

        Text("2. SnackBar con duración")
        EjemploSnackbarDuracion()

        Text("3. SnackBar con botón de acción")
        EjemploSnackbarAccion()

        Text("4. SnackBar con botón para cerrar")
        EjemploSnackbarCerrar()

        Text("5. SnackBar que detecta qué hizo el usuario")
        EjemploSnackbarResultado()

        Text("6. SnackBar con mensaje desde un TextField")
        EjemploSnackbarValidacion()

        Text("7. SnackBar con botón flotante")
        EjemploSnackbarConFab()

        Text("8. SnackBar que reemplaza el mensaje anterior")
        EjemploSnackbarReemplazar()

        Text("9. SnackBar personalizado")
        EjemploSnackbarPersonalizado()

        Text("10. SnackBar para deshacer una eliminación")
        EjemploSnackbarDeshacer()
    }
}

// Marco con altura fija para mostrar cada Scaffold dentro de una pantalla con scroll
@Composable
fun MarcoEjemploSnackbar(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .border(2.dp, Color.Gray)
    ) {
        content()
    }
}

// 1. SnackBar básico
@Composable
fun EjemploSnackbarBasico() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Mensaje enviado")
                        }
                    }
                ) {
                    Text("Mostrar mensaje")
                }
            }
        }
    }
}

// 2. SnackBar con duración
@Composable
fun EjemploSnackbarDuracion() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Mensaje corto",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                ) {
                    Text("Corto")
                }

                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Mensaje largo",
                                duration = SnackbarDuration.Long
                            )
                        }
                    }
                ) {
                    Text("Largo")
                }

                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Mensaje indefinido",
                                withDismissAction = true,
                                duration = SnackbarDuration.Indefinite
                            )
                        }
                    }
                ) {
                    Text("Indefinido")
                }
            }
        }
    }
}

// 3. SnackBar con botón de acción
@Composable
fun EjemploSnackbarAccion() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Archivo eliminado",
                                actionLabel = "Deshacer"
                            )
                        }
                    }
                ) {
                    Text("Eliminar archivo")
                }
            }
        }
    }
}

// 4. SnackBar con botón para cerrar
@Composable
fun EjemploSnackbarCerrar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Sin conexión a internet",
                                withDismissAction = true,
                                duration = SnackbarDuration.Long
                            )
                        }
                    }
                ) {
                    Text("Mostrar aviso")
                }
            }
        }
    }
}

// 5. SnackBar que detecta qué hizo el usuario
@Composable
fun EjemploSnackbarResultado() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var estado by remember { mutableStateOf("Sin acciones") }

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Estado: $estado")

                Button(
                    onClick = {
                        scope.launch {
                            val resultado = snackbarHostState.showSnackbar(
                                message = "Se envió el correo",
                                actionLabel = "Deshacer"
                            )

                            estado = when (resultado) {
                                SnackbarResult.ActionPerformed -> "Envío deshecho"
                                SnackbarResult.Dismissed -> "Envío confirmado"
                            }
                        }
                    }
                ) {
                    Text("Enviar correo")
                }
            }
        }
    }
}

// 6. SnackBar con mensaje desde un TextField
@Composable
fun EjemploSnackbarValidacion() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var nombre by remember { mutableStateOf("") }

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        scope.launch {
                            if (nombre.isBlank()) {
                                snackbarHostState.showSnackbar("El campo está vacío")
                            } else {
                                snackbarHostState.showSnackbar("Hola, $nombre")
                            }
                        }
                    }
                ) {
                    Text("Enviar")
                }
            }
        }
    }
}

// 7. SnackBar con botón flotante
@Composable
fun EjemploSnackbarConFab() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var contador by remember { mutableIntStateOf(0) }

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        contador++
                        scope.launch {
                            snackbarHostState.showSnackbar("Elementos: $contador")
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar"
                    )
                }
            }
        ) { innerPadding ->
            Text(
                text = "Presiona el botón +",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 8. SnackBar que reemplaza el mensaje anterior
@Composable
fun EjemploSnackbarReemplazar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var contador by remember { mutableIntStateOf(0) }

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        contador++
                        scope.launch {
                            snackbarHostState.currentSnackbarData?.dismiss()
                            snackbarHostState.showSnackbar("Clic número $contador")
                        }
                    }
                ) {
                    Text("Presionar varias veces")
                }
            }
        }
    }
}

// 9. SnackBar personalizado
@Composable
fun EjemploSnackbarPersonalizado() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) { data ->
                    Snackbar(
                        snackbarData = data,
                        containerColor = Color(0xFF2E7D32),
                        contentColor = Color.White,
                        actionColor = Color.Yellow,
                        shape = RoundedCornerShape(16.dp)
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Guardado correctamente",
                                actionLabel = "Ver"
                            )
                        }
                    }
                ) {
                    Text("Guardar")
                }
            }
        }
    }
}

// 10. SnackBar para deshacer una eliminación
@Composable
fun EjemploSnackbarDeshacer() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val tareas = remember {
        mutableStateListOf("Estudiar Kotlin", "Hacer la práctica", "Subir al repositorio", "Revisar correo")
    }

    MarcoEjemploSnackbar {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                tareas.toList().forEachIndexed { indice, tarea ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(tarea)

                        TextButton(
                            onClick = {
                                val eliminada = tareas.removeAt(indice)

                                scope.launch {
                                    snackbarHostState.currentSnackbarData?.dismiss()

                                    val resultado = snackbarHostState.showSnackbar(
                                        message = "\"$eliminada\" eliminada",
                                        actionLabel = "Deshacer"
                                    )

                                    if (resultado == SnackbarResult.ActionPerformed) {
                                        tareas.add(indice.coerceAtMost(tareas.size), eliminada)
                                    }
                                }
                            }
                        ) {
                            Text("Eliminar")
                        }
                    }
                }

                if (tareas.isEmpty()) {
                    Text("No quedan tareas")
                }
            }
        }
    }
}