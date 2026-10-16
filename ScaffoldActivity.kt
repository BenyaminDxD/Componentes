package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploScaffold(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploScaffold(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE SCAFFOLD",
            fontSize = 22.sp
        )

        Text("1. Scaffold básico (content)")
        EjemploScaffoldBasico()

        Text("2. Scaffold con modifier")
        EjemploScaffoldModifier()

        Text("3. Scaffold con barra superior (topBar)")
        EjemploScaffoldTopBar()

        Text("4. Scaffold con barra inferior (bottomBar)")
        EjemploScaffoldBottomBar()

        Text("5. Scaffold con botón flotante (floatingActionButton)")
        EjemploScaffoldFab()

        Text("6. Posición del botón flotante (floatingActionButtonPosition)")
        EjemploScaffoldFabPosicion()

        Text("7. Color de fondo (containerColor)")
        EjemploScaffoldContainerColor()

        Text("8. Color del contenido (contentColor)")
        EjemploScaffoldContentColor()

        Text("9. Mensaje emergente (snackbarHost)")
        EjemploScaffoldSnackbar()

        Text("10. Márgenes del sistema (contentWindowInsets)")
        EjemploScaffoldInsets()

        Text("11. Lista que respeta innerPadding")
        EjemploScaffoldLista()

        Text("12. Barra de navegación que cambia el contenido")
        EjemploScaffoldNavegacion()

        Text("13. Scaffold completo con contador")
        EjemploScaffoldCompleto()
    }
}

// Marco con altura fija para mostrar cada Scaffold dentro de una pantalla con scroll
@Composable
fun MarcoEjemploScaffold(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .border(2.dp, Color.Gray)
    ) {
        content()
    }
}

// 1. Scaffold básico
@Composable
fun EjemploScaffoldBasico() {
    MarcoEjemploScaffold {
        Scaffold { innerPadding ->
            Text(
                text = "Contenido de la pantalla",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 2. Scaffold con modifier
@Composable
fun EjemploScaffoldModifier() {
    MarcoEjemploScaffold {
        Scaffold(
            modifier = Modifier
                .padding(24.dp)
                .border(2.dp, Color.Red)
        ) { innerPadding ->
            Text(
                text = "Scaffold con margen y borde rojo",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 3. Scaffold con barra superior
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploScaffoldTopBar() {
    MarcoEjemploScaffold {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mi aplicación") }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Contenido debajo de la barra",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 4. Scaffold con barra inferior
@Composable
fun EjemploScaffoldBottomBar() {
    MarcoEjemploScaffold {
        Scaffold(
            bottomBar = {
                BottomAppBar {
                    Text(
                        text = "Barra inferior",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        ) { innerPadding ->
            Text(
                text = "Contenido encima de la barra",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 5. Scaffold con botón flotante
@Composable
fun EjemploScaffoldFab() {
    MarcoEjemploScaffold {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar"
                    )
                }
            }
        ) { innerPadding ->
            Text(
                text = "Pantalla con botón flotante",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 6. Posición del botón flotante
@Composable
fun EjemploScaffoldFabPosicion() {
    var centrado by remember { mutableStateOf(true) }

    MarcoEjemploScaffold {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { centrado = !centrado }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Mover botón"
                    )
                }
            },
            floatingActionButtonPosition = if (centrado) FabPosition.Center else FabPosition.End
        ) { innerPadding ->
            Text(
                text = if (centrado) "Botón al centro (toca para moverlo)"
                else "Botón a la derecha (toca para moverlo)",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 7. Color de fondo
@Composable
fun EjemploScaffoldContainerColor() {
    MarcoEjemploScaffold {
        Scaffold(
            containerColor = Color(0xFFE3F2FD)
        ) { innerPadding ->
            Text(
                text = "Fondo celeste",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 8. Color del contenido
@Composable
fun EjemploScaffoldContentColor() {
    MarcoEjemploScaffold {
        Scaffold(
            containerColor = Color(0xFF212121),
            contentColor = Color(0xFFFFC107)
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text("Estos textos no indican color,")
                Text("pero toman el amarillo de contentColor")
            }
        }
    }
}

// 9. Mensaje emergente (Snackbar)
@Composable
fun EjemploScaffoldSnackbar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploScaffold {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Mensaje enviado")
                    }
                },
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text("Mostrar mensaje")
            }
        }
    }
}

// 10. Márgenes del sistema
@Composable
fun EjemploScaffoldInsets() {
    var sinMargenes by remember { mutableStateOf(false) }

    MarcoEjemploScaffold {
        Scaffold(
            contentWindowInsets = if (sinMargenes) WindowInsets(0.dp)
            else ScaffoldDefaults.contentWindowInsets
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Margen superior: ${innerPadding.calculateTopPadding()}")
                Text("Margen inferior: ${innerPadding.calculateBottomPadding()}")

                Button(onClick = { sinMargenes = !sinMargenes }) {
                    Text(if (sinMargenes) "Usar márgenes del sistema" else "Quitar márgenes")
                }
            }
        }
    }
}

// 11. Lista que respeta innerPadding
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploScaffoldLista() {
    MarcoEjemploScaffold {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Lista") })
            }
        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(20) { indice ->
                    Text(
                        text = "Elemento ${indice + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

// 12. Barra de navegación que cambia el contenido
@Composable
fun EjemploScaffoldNavegacion() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Favoritos" to Icons.Default.Favorite,
        "Perfil" to Icons.Default.Person
    )

    MarcoEjemploScaffold {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = {
                                Icon(
                                    imageVector = icono,
                                    contentDescription = nombre
                                )
                            },
                            label = { Text(nombre) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (seleccionado) {
                        0 -> "Pantalla de inicio"
                        1 -> "Pantalla de favoritos"
                        else -> "Pantalla de perfil"
                    },
                    fontSize = 20.sp
                )
            }
        }
    }
}

// 13. Scaffold completo con contador
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploScaffoldCompleto() {
    var contador by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    MarcoEjemploScaffold {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Contador") },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú",
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Text(
                        text = "Total de clics: $contador",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            },
            snackbarHost = { SnackbarHost(snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        contador++
                        if (contador % 5 == 0) {
                            scope.launch {
                                snackbarHostState.showSnackbar("¡Llegaste a $contador clics!")
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Sumar"
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            containerColor = Color(0xFFF3E5F5)
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$contador",
                    fontSize = 48.sp
                )
            }
        }
    }
}