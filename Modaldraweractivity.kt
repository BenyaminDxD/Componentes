package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlinx.coroutines.launch

class ModalDrawerActivity : ComponentActivity() {
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
                        Titulo("1. ModalNavigationDrawer básico (drawerState)")
                        EjemploDrawerBasico()

                        Titulo("2. Ancho del menú (modifier)")
                        EjemploDrawerAncho()

                        Titulo("3. Colores del menú (drawerContainerColor)")
                        EjemploDrawerColores()

                        Titulo("4. Con encabezado y Divider")
                        EjemploDrawerEncabezado()

                        Titulo("5. Con iconos (icon)")
                        EjemploDrawerIconos()

                        Titulo("6. Sin gestos (gesturesEnabled)")
                        EjemploDrawerSinGestos()

                        // ---------- NIVEL 2: con estado ----------
                        Titulo("7. Opción seleccionada (selected)")
                        EjemploDrawerSeleccion()

                        Titulo("8. Cerrar al elegir una opción")
                        EjemploDrawerCerrar()

                        Titulo("9. Con badge en la opción")
                        EjemploDrawerBadge()
                    }
                }
            }
        }
    }
}

// 1. Drawer básico: se abre con un botón
@Composable
fun EjemploDrawerBasico() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menú", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 2. Ancho del menú
@Composable
fun EjemploDrawerAncho() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(200.dp)) {
                Text("Menú angosto", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 3. Colores del menú
@Composable
fun EjemploDrawerColores() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF1565C0),
                drawerContentColor = Color.White
            ) {
                Text("Menú azul", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 4. Con encabezado y Divider
@Composable
fun EjemploDrawerEncabezado() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Mi aplicación",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text("Perfil") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 5. Con iconos
@Composable
fun EjemploDrawerIconos() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text("Ajustes") },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Ajustes") },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text("Acerca de") },
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 6. Sin gestos: solo se abre con el botón
@Composable
fun EjemploDrawerSinGestos() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet {
                Text("No se abre deslizando", modifier = Modifier.padding(16.dp))
                Button(
                    onClick = { scope.launch { drawerState.close() } },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Cerrar")
                }
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// =====================================================
// NIVEL 2: CON ESTADO
// =====================================================

// 7. Opción seleccionada
@Composable
fun EjemploDrawerSeleccion() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var seleccionado by remember { mutableStateOf("Inicio") }

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                listOf("Inicio", "Perfil", "Ajustes").forEach { opcion ->
                    NavigationDrawerItem(
                        label = { Text(opcion) },
                        selected = seleccionado == opcion,
                        onClick = { seleccionado = opcion }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Pantalla: $seleccionado")
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 8. Cerrar al elegir una opción
@Composable
fun EjemploDrawerCerrar() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var seleccionado by remember { mutableStateOf("Inicio") }

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                listOf("Inicio", "Perfil", "Ajustes").forEach { opcion ->
                    NavigationDrawerItem(
                        label = { Text(opcion) },
                        selected = seleccionado == opcion,
                        onClick = {
                            seleccionado = opcion
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Elegiste: $seleccionado")
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}

// 9. Con badge en la opción
@Composable
fun EjemploDrawerBadge() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier.height(260.dp),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text("Mensajes") },
                    selected = false,
                    onClick = {},
                    badge = { Text("3") }
                )
                NavigationDrawerItem(
                    label = { Text("Avisos") },
                    selected = false,
                    onClick = {},
                    badge = { Text("12") }
                )
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Abrir menú")
            }
        }
    }
}