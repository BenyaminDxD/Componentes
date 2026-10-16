package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class BottomBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploBottomBar(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploBottomBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE BOTTOMBAR",
            fontSize = 22.sp
        )

        Text("1. BottomAppBar básico")
        EjemploBottomBarBasico()

        Text("2. BottomAppBar con acciones")
        EjemploBottomBarAcciones()

        Text("3. BottomAppBar con botón flotante integrado")
        EjemploBottomBarConFab()

        Text("4. BottomAppBar con colores personalizados")
        EjemploBottomBarColores()

        Text("5. NavigationBar básica")
        EjemploBottomBarNavegacionBasica()

        Text("6. NavigationBar que cambia el contenido")
        EjemploBottomBarContenido()

        Text("7. NavigationBar con etiqueta solo en la opción activa")
        EjemploBottomBarEtiqueta()

        Text("8. NavigationBar con colores personalizados")
        EjemploBottomBarColoresNavegacion()

        Text("9. NavigationBar con iconos rellenos y de contorno")
        EjemploBottomBarIconosRellenos()

        Text("10. NavigationBar con insignias")
        EjemploBottomBarInsignias()

        Text("11. BottomAppBar que se oculta al desplazar")
        EjemploBottomBarScrollOculta()

        Text("12. Pantalla completa con barra superior e inferior")
        EjemploBottomBarCompleto()
    }
}

// Marco con altura fija para mostrar cada Scaffold dentro de una pantalla con scroll
@Composable
fun MarcoEjemploBottomBar(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .border(2.dp, Color.Gray)
    ) {
        content()
    }
}

// 1. BottomAppBar básico
@Composable
fun EjemploBottomBarBasico() {
    MarcoEjemploBottomBar {
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
                text = "Contenido de la pantalla",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 2. BottomAppBar con acciones
@Composable
fun EjemploBottomBarAcciones() {
    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menú")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Search, contentDescription = "Buscar")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Edit, contentDescription = "Editar")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra con tres acciones",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 3. BottomAppBar con botón flotante integrado
@Composable
fun EjemploBottomBarConFab() {
    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Share, contentDescription = "Compartir")
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Agregar")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra con botón flotante",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 4. BottomAppBar con colores personalizados
@Composable
fun EjemploBottomBarColores() {
    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    containerColor = Color(0xFF1565C0),
                    contentColor = Color.White,
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Home, contentDescription = "Inicio")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Favorite, contentDescription = "Favoritos")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                text = "Barra azul con iconos blancos",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 5. NavigationBar básica
@Composable
fun EjemploBottomBarNavegacionBasica() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Buscar" to Icons.Default.Search,
        "Perfil" to Icons.Default.Person
    )

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = { Icon(icono, contentDescription = nombre) },
                            label = { Text(nombre) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Text(
                text = "Opción elegida: ${items[seleccionado].first}",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 6. NavigationBar que cambia el contenido
@Composable
fun EjemploBottomBarContenido() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Buscar" to Icons.Default.Search,
        "Perfil" to Icons.Default.Person
    )

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = { Icon(icono, contentDescription = nombre) },
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
                        1 -> "Pantalla de búsqueda"
                        else -> "Pantalla de perfil"
                    },
                    fontSize = 20.sp
                )
            }
        }
    }
}

// 7. NavigationBar con etiqueta solo en la opción activa
@Composable
fun EjemploBottomBarEtiqueta() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Favoritos" to Icons.Default.Favorite,
        "Ajustes" to Icons.Default.Settings
    )

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = { Icon(icono, contentDescription = nombre) },
                            label = { Text(nombre) },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        ) { innerPadding ->
            Text(
                text = "El texto solo aparece en la opción activa",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 8. NavigationBar con colores personalizados
@Composable
fun EjemploBottomBarColoresNavegacion() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Favoritos" to Icons.Default.Favorite,
        "Perfil" to Icons.Default.Person
    )

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar(containerColor = Color(0xFF263238)) {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = { Icon(icono, contentDescription = nombre) },
                            label = { Text(nombre) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Black,
                                selectedTextColor = Color(0xFF80DEEA),
                                indicatorColor = Color(0xFF80DEEA),
                                unselectedIconColor = Color.Gray,
                                unselectedTextColor = Color.Gray
                            )
                        )
                    }
                }
            }
        ) { innerPadding ->
            Text(
                text = "Barra oscura con opción activa celeste",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 9. NavigationBar con iconos rellenos y de contorno
@Composable
fun EjemploBottomBarIconosRellenos() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        Triple("Inicio", Icons.Filled.Home, Icons.Outlined.Home),
        Triple("Perfil", Icons.Filled.Person, Icons.Outlined.Person),
        Triple("Ajustes", Icons.Filled.Settings, Icons.Outlined.Settings)
    )

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, relleno, contorno) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = {
                                Icon(
                                    imageVector = if (seleccionado == indice) relleno else contorno,
                                    contentDescription = nombre
                                )
                            },
                            label = { Text(nombre) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Text(
                text = "El icono activo se ve relleno",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 10. NavigationBar con insignias
@Composable
fun EjemploBottomBarInsignias() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Mensajes" to Icons.Default.Email,
        "Alertas" to Icons.Default.Notifications
    )
    val avisos = listOf(0, 4, 12)

    MarcoEjemploBottomBar {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (avisos[indice] > 0) {
                                            Badge { Text("${avisos[indice]}") }
                                        }
                                    }
                                ) {
                                    Icon(icono, contentDescription = nombre)
                                }
                            },
                            label = { Text(nombre) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Text(
                text = "Avisos en Mensajes y Alertas",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        }
    }
}

// 11. BottomAppBar que se oculta al desplazar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploBottomBarScrollOculta() {
    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()

    MarcoEjemploBottomBar {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            bottomBar = {
                BottomAppBar(
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Home, contentDescription = "Inicio")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Search, contentDescription = "Buscar")
                        }
                    },
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

// 12. Pantalla completa con barra superior e inferior
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploBottomBarCompleto() {
    var seleccionado by remember { mutableIntStateOf(0) }

    val items = listOf(
        "Inicio" to Icons.Default.Home,
        "Favoritos" to Icons.Default.Favorite,
        "Perfil" to Icons.Default.Person
    )

    MarcoEjemploBottomBar {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(items[seleccionado].first) })
            },
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { indice, (nombre, icono) ->
                        NavigationBarItem(
                            selected = seleccionado == indice,
                            onClick = { seleccionado = indice },
                            icon = { Icon(icono, contentDescription = nombre) },
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
                        0 -> "Bienvenido a la pantalla de inicio"
                        1 -> "Aquí aparecen tus favoritos"
                        else -> "Datos de tu perfil"
                    }
                )
            }
        }
    }
}