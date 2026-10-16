package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class OutlinedButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploOutlinedButton(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploOutlinedButton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "OUTLINED BUTTON",
            style = MaterialTheme.typography.headlineSmall
        )

        // ---------- NIVEL 1: apariencia (sin estado) ----------
        Text("NIVEL 1: APARIENCIA (sin estado)")

        EjemploOutlinedBasico()
        EjemploOutlinedDeshabilitado()
        EjemploOutlinedColores()
        EjemploOutlinedForma()
        EjemploOutlinedTamano()
        EjemploOutlinedBorde()
        EjemploOutlinedElevacion()
        EjemploOutlinedEspaciado()
        EjemploOutlinedIcono()

        HorizontalDivider()

        // ---------- NIVEL 2: con estado ----------
        Text("NIVEL 2: CON ESTADO")

        EjemploOutlinedContadorMas()
        EjemploOutlinedContadorMenos()
        EjemploOutlinedContadorCinco()
        EjemploOutlinedContadorDiez()
        EjemploOutlinedMensaje()
        EjemploOutlinedReiniciar()
        EjemploOutlinedSinNegativos()
        EjemploOutlinedGrupo()
        EjemploOutlinedLimpiarTexto()
        EjemploOutlinedInteractionSource()
    }
}

// =====================================================
// NIVEL 1: APARIENCIA (sin estado)
// =====================================================

// 1. Botón básico
@Composable
fun EjemploOutlinedBasico() {
    OutlinedButton(onClick = { }) {
        Text("Botón básico")
    }
}

// 2. Botón deshabilitado
@Composable
fun EjemploOutlinedDeshabilitado() {
    OutlinedButton(
        onClick = { },
        enabled = false
    ) {
        Text("Botón deshabilitado")
    }
}

// 3. Cambiar colores
@Composable
fun EjemploOutlinedColores() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Color.Blue
        )
    ) {
        Text("Botón azul")
    }
}

// 4. Cambiar forma
@Composable
fun EjemploOutlinedForma() {
    OutlinedButton(
        onClick = { },
        shape = RoundedCornerShape(5.dp)
    ) {
        Text("Esquinas pequeñas")
    }
}

// 5. Cambiar tamaño
@Composable
fun EjemploOutlinedTamano() {
    OutlinedButton(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        Text("Botón ancho")
    }
}

// 6. Cambiar borde
@Composable
fun EjemploOutlinedBorde() {
    OutlinedButton(
        onClick = { },
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text("Borde rojo")
    }
}

// 7. Cambiar elevación
@Composable
fun EjemploOutlinedElevacion() {
    OutlinedButton(
        onClick = { },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text("Botón con elevación")
    }
}

// 8. Cambiar espacio interior
@Composable
fun EjemploOutlinedEspaciado() {
    OutlinedButton(
        onClick = { },
        contentPadding = PaddingValues(
            horizontal = 30.dp,
            vertical = 15.dp
        )
    ) {
        Text("Más espacio interior")
    }
}

// 9. Botón con icono
@Composable
fun EjemploOutlinedIcono() {
    OutlinedButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorito"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text("Me gusta")
    }
}

// =====================================================
// NIVEL 2: CON ESTADO
// =====================================================

// 10. Incrementar contador
@Composable
fun EjemploOutlinedContadorMas() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        OutlinedButton(onClick = { contador++ }) {
            Text("Aumentar +1")
        }
    }
}

// 11. Decrementar contador
@Composable
fun EjemploOutlinedContadorMenos() {
    var contador by remember { mutableIntStateOf(10) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        OutlinedButton(onClick = { contador-- }) {
            Text("Disminuir -1")
        }
    }
}

// 12. Aumentar de cinco en cinco
@Composable
fun EjemploOutlinedContadorCinco() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Valor: $contador")

        OutlinedButton(onClick = { contador += 5 }) {
            Text("Aumentar +5")
        }
    }
}

// 13. Aumentar de diez en diez
@Composable
fun EjemploOutlinedContadorDiez() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Total: $contador")

        OutlinedButton(onClick = { contador += 10 }) {
            Text("Aumentar +10")
        }
    }
}

// 14. Mostrar mensaje
@Composable
fun EjemploOutlinedMensaje() {
    var mensaje by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(onClick = { mensaje = "¡Botón presionado!" }) {
            Text("Mostrar mensaje")
        }

        Text(text = mensaje)
    }
}

// 15. Reiniciar contador
@Composable
fun EjemploOutlinedReiniciar() {
    var contador by remember { mutableIntStateOf(0) }
    var mensaje by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        OutlinedButton(onClick = { contador++ }) {
            Text("Aumentar +1")
        }

        OutlinedButton(
            onClick = {
                contador = 0
                mensaje = "Contador reiniciado"
            }
        ) {
            Text("Reiniciar")
        }

        Text(text = mensaje)
    }
}

// 16. No permitir valores negativos
@Composable
fun EjemploOutlinedSinNegativos() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        OutlinedButton(onClick = { contador++ }) {
            Text("Aumentar +1")
        }

        OutlinedButton(
            onClick = {
                if (contador > 0) {
                    contador--
                }
            }
        ) {
            Text("Disminuir sin negativos")
        }
    }
}

// 17. Grupo de botones
@Composable
fun EjemploOutlinedGrupo() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = { contador++ }) {
                Text("+1")
            }

            OutlinedButton(
                onClick = {
                    if (contador > 0) {
                        contador--
                    }
                }
            ) {
                Text("-1")
            }

            OutlinedButton(onClick = { contador = 0 }) {
                Text("Reset")
            }
        }
    }
}

// 18. Limpiar un TextField
@Composable
fun EjemploOutlinedLimpiarTexto() {
    var nombre by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(onClick = { nombre = "" }) {
            Text("Limpiar texto")
        }
    }
}

// 19. Usar interactionSource
@Composable
fun EjemploOutlinedInteractionSource() {
    var mensaje by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(
            onClick = { mensaje = "Interacción detectada" },
            interactionSource = interactionSource
        ) {
            Text("Botón con interacción")
        }

        Text(text = mensaje)
    }
}