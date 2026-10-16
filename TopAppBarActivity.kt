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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploTopAppBar(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploTopAppBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE TOPAPPBAR",
            fontSize = 22.sp
        )

        Text("1. TopAppBar básico")
        EjemploTopAppBarBasico()

        Text("2. TopAppBar con icono de navegación")
        EjemploTopAppBarNavegacion()

        Text("3. TopAppBar con acciones")
        EjemploTopAppBarAcciones()

        Text("4. TopAppBar con colores personalizados")
        EjemploTopAppBarColores()

        Text("5. CenterAlignedTopAppBar")
        EjemploTopAppBarCentrado()

        Text("6. MediumTopAppBar")
        EjemploTopAppBarMediana()

        Text("7. LargeTopAppBar")
        EjemploTopAppBarGrande()

        Text("8. TopAppBar con acción que cambia de estado")
        EjemploTopAppBarFavorito()

        Text("9. TopAppBar con menú desplegable")
        EjemploTopAppBarMenu()

        Text("10. TopAppBar con búsqueda")
        EjemploTopAppBarBusqueda()

        Text("11. TopAppBar que se oculta al desplazar")
        EjemploTopAppBarScrollOculta()

        Text("12. LargeTopAppBar que se contrae al desplazar")
        EjemploTopAppBarContraible()
    }
}

// Marco con altura fija para mostrar cada TopAppBar (dentro de un Scaffold)
// en una pantalla con scroll
@Composable
fun MarcoEjemploTopAppBar(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .border(2.dp, Color.Gray)
    ) {
        content()
    }
}

// 1. TopAppBar básico
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarBasico() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mi aplicación") }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Contenido de la pantalla",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 2. TopAppBar con icono de navegación
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("DEPRECATION")
@Composable
fun EjemploTopAppBarNavegacion() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Detalle") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Volver"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Pantalla con flecha para volver",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 3. TopAppBar con acciones
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarAcciones() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Inicio") },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar"
                            )
                        }

                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Ajustes"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra con dos acciones",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 4. TopAppBar con colores personalizados
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarColores() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Barra azul") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menú"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorito"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF1565C0),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra con colores propios",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 5. CenterAlignedTopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarCentrado() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Título centrado") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menú"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra con título centrado",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 6. MediumTopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarMediana() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = { Text("Barra mediana") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menú"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra de tamaño mediano",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 7. LargeTopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarGrande() {
    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                LargeTopAppBar(
                    title = { Text("Barra grande") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menú"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra de tamaño grande",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 8. TopAppBar con acción que cambia de estado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarFavorito() {
    var favorito by remember { mutableStateOf(false) }

    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Publicación") },
                    actions = {
                        IconButton(onClick = { favorito = !favorito }) {
                            Icon(
                                imageVector = if (favorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favorito",
                                tint = if (favorito) Color.Red else LocalContentColor.current
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = if (favorito) "Marcado como favorito" else "No está en favoritos",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 9. TopAppBar con menú desplegable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarMenu() {
    var expandido by remember { mutableStateOf(false) }
    var opcion by remember { mutableStateOf("Ninguna") }

    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Con menú") },
                    actions = {
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
                                    text = { Text("Compartir") },
                                    onClick = {
                                        opcion = "Compartir"
                                        expandido = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = { Text("Ajustes") },
                                    onClick = {
                                        opcion = "Ajustes"
                                        expandido = false
                                    }
                                )
                            }
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Opción elegida: $opcion",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 10. TopAppBar con búsqueda
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarBusqueda() {
    var buscando by remember { mutableStateOf(false) }
    var texto by remember { mutableStateOf("") }

    MarcoEjemploTopAppBar {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        if (buscando) {
                            TextField(
                                value = texto,
                                onValueChange = { texto = it },
                                placeholder = { Text("Buscar...") },
                                singleLine = true
                            )
                        } else {
                            Text("Contactos")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                buscando = !buscando
                                if (!buscando) texto = ""
                            }
                        ) {
                            Icon(
                                imageVector = if (buscando) Icons.Default.Close else Icons.Default.Search,
                                contentDescription = if (buscando) "Cerrar búsqueda" else "Buscar"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = if (texto.isEmpty()) "Sin búsqueda" else "Buscando: $texto",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 11. TopAppBar que se oculta al desplazar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarScrollOculta() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    MarcoEjemploTopAppBar {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = { Text("Se oculta al bajar") },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(30) { indice ->
                    Text(
                        text = "Elemento ${indice + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

// 12. LargeTopAppBar que se contrae al desplazar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBarContraible() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    MarcoEjemploTopAppBar {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                LargeTopAppBar(
                    title = { Text("Se contrae") },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(30) { indice ->
                    Text(
                        text = "Elemento ${indice + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}