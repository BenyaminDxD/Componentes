package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class CardActivity : ComponentActivity() {
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
                        Titulo("1. Card básico")
                        EjemploCardBasico()

                        Titulo("2. Card con color personalizado")
                        EjemploCardColor()

                        Titulo("3. Card con elevación")
                        EjemploCardElevacion()

                        Titulo("4. Card con borde")
                        EjemploCardBorde()

                        Titulo("5. Card con esquinas personalizadas")
                        EjemploCardForma()

                        Titulo("6. Card con icono y texto")
                        EjemploCardIconoTexto()

                        Titulo("7. Card con botones")
                        EjemploCardBotones()

                        Titulo("8. Card clicable")
                        EjemploCardClicable()

                        Titulo("9. ElevatedCard y OutlinedCard")
                        EjemploCardVariantes()

                        Titulo("10. Card de perfil")
                        EjemploCardPerfil()

                        Titulo("11. Card expandible")
                        EjemploCardExpandible()

                        Titulo("12. Lista de Cards")
                        EjemploCardLista()
                    }
                }
            }
        }
    }
}

// 1. Card básico
@Composable
fun EjemploCardBasico() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Este es un Card básico",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 2. Card con color personalizado
@Composable
fun EjemploCardColor() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3F51B5),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Card con fondo azul",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 3. Card con elevación
@Composable
fun EjemploCardElevacion() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = "Card con sombra",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 4. Card con borde
@Composable
fun EjemploCardBorde() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, Color.Red),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Text(
            text = "Card con borde rojo",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 5. Card con esquinas personalizadas
@Composable
fun EjemploCardForma() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp)
    ) {
        Text(
            text = "Card con esquinas diferentes",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 6. Card con icono y texto
@Composable
fun EjemploCardIconoTexto() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Destacado",
                tint = Color(0xFFFFA000),
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Título destacado",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Descripción breve del contenido",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// 7. Card con botones
@Composable
fun EjemploCardBotones() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "¿Eliminar archivo?",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Esta acción no se puede deshacer.")

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
            ) {
                TextButton(onClick = {}) {
                    Text("Cancelar")
                }

                Button(onClick = {}) {
                    Text("Eliminar")
                }
            }
        }
    }
}

// 8. Card clicable
@Composable
fun EjemploCardClicable() {
    var toques by remember { mutableIntStateOf(0) }

    Card(
        onClick = { toques++ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Toques: $toques",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// 9. ElevatedCard y OutlinedCard
@Composable
fun EjemploCardVariantes() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "ElevatedCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        OutlinedCard(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "OutlinedCard",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

// 10. Card de perfil
@Composable
fun EjemploCardPerfil() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF3F51B5)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Juan Pérez",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text("Estudiante de Ingeniería")
            }
        }
    }
}

// 11. Card expandible
@Composable
fun EjemploCardExpandible() {
    var expandido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver detalles",
                    style = MaterialTheme.typography.titleMedium
                )

                IconButton(onClick = { expandido = !expandido }) {
                    Icon(
                        imageVector = if (expandido) Icons.Default.KeyboardArrowUp
                        else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expandido) "Contraer" else "Expandir"
                    )
                }
            }

            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Aquí aparece la información adicional que estaba oculta.")
            }
        }
    }
}

// 12. Lista de Cards
@Composable
fun EjemploCardLista() {
    val tareas = listOf(
        "Informe de POO" to "Pendiente",
        "Práctica de geoestadística" to "En curso",
        "Lectura del capítulo 3" to "Completada"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tareas.forEach { (titulo, estado) ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(titulo)
                    Text(estado, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}