package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlinx.coroutines.delay

class ProgressBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploProgressBar(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EjemploProgressBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE PROGRESSBAR",
            fontSize = 22.sp
        )

        Text("NIVEL 1: BÁSICO")

        Text("1. Circular básico")
        EjemploProgressCircular()

        Text("2. Circular con color y grosor")
        EjemploProgressCircularColor()

        Text("3. Circular con tamaño")
        EjemploProgressCircularTamano()

        Text("4. Lineal básico")
        EjemploProgressLineal()

        Text("5. Lineal con colores")
        EjemploProgressLinealColor()

        Text("6. Lineal redondeado")
        EjemploProgressLinealRedondeado()

        Text("7. Lineal con progreso fijo")
        EjemploProgressLinealFijo()

        Text("8. Circular con progreso fijo")
        EjemploProgressCircularFijo()

        HorizontalDivider()

        Text("NIVEL 2: AVANZADO")

        Text("9. Con porcentaje")
        EjemploProgressPorcentaje()

        Text("10. Controlado con botones")
        EjemploProgressControlado()

        Text("11. Progreso animado")
        EjemploProgressAnimado()

        Text("12. Carga simulada")
        EjemploProgressSimulado()

        Text("13. Indicador dentro de un botón")
        EjemploProgressEnBoton()

        Text("14. Circular con porcentaje en el centro")
        EjemploProgressCircularPorcentaje()

        Text("15. Barra personalizada con Box")
        EjemploProgressPersonalizado()
    }
}

// 1
@Composable
fun EjemploProgressCircular() {
    CircularProgressIndicator()
}

// 2
@Composable
fun EjemploProgressCircularColor() {
    CircularProgressIndicator(
        color = Color.Red,
        strokeWidth = 8.dp
    )
}

// 3
@Composable
fun EjemploProgressCircularTamano() {
    CircularProgressIndicator(
        modifier = Modifier.size(80.dp)
    )
}

// 4
@Composable
fun EjemploProgressLineal() {
    LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth()
    )
}

// 5
@Composable
fun EjemploProgressLinealColor() {
    LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Blue,
        trackColor = Color.LightGray
    )
}

// 6
@Composable
fun EjemploProgressLinealRedondeado() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
            .clip(RoundedCornerShape(6.dp))
    )
}

// 7
@Composable
fun EjemploProgressLinealFijo() {
    LinearProgressIndicator(
        progress = { 0.5f },
        modifier = Modifier.fillMaxWidth()
    )
}

// 8
@Composable
fun EjemploProgressCircularFijo() {
    CircularProgressIndicator(
        progress = { 0.75f },
        color = Color(0xFF2E7D32),
        trackColor = Color.LightGray,
        strokeWidth = 8.dp,
        modifier = Modifier.size(80.dp)
    )
}

// 9
@Composable
fun EjemploProgressPorcentaje() {
    val progreso = 0.65f

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "${(progreso * 100).toInt()}%")
    }
}

// 10
@Composable
fun EjemploProgressControlado() {
    var progreso by remember { mutableFloatStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "${(progreso * 100).toInt()}%")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { progreso = (progreso - 0.1f).coerceAtLeast(0f) }) {
                Text("-10%")
            }

            Button(onClick = { progreso = (progreso + 0.1f).coerceAtMost(1f) }) {
                Text("+10%")
            }

            Button(onClick = { progreso = 0f }) {
                Text("Reset")
            }
        }
    }
}

// 11
@Composable
fun EjemploProgressAnimado() {
    var objetivo by remember { mutableFloatStateOf(0f) }
    val animado by animateFloatAsState(targetValue = objetivo, label = "progreso")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(
            progress = { animado },
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        Text(text = "${(animado * 100).toInt()}%")

        Button(onClick = { objetivo = if (objetivo >= 1f) 0f else objetivo + 0.25f }) {
            Text("Avanzar 25%")
        }
    }
}

// 12
@Composable
fun EjemploProgressSimulado() {
    var progreso by remember { mutableFloatStateOf(0f) }
    var cargando by remember { mutableStateOf(false) }

    LaunchedEffect(cargando) {
        if (cargando) {
            progreso = 0f
            while (progreso < 1f) {
                delay(100)
                progreso = (progreso + 0.05f).coerceAtMost(1f)
            }
            cargando = false
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "${(progreso * 100).toInt()}%")

        Button(
            onClick = { cargando = true },
            enabled = !cargando
        ) {
            Text(if (cargando) "Descargando..." else "Iniciar descarga")
        }
    }
}

// 13
@Composable
fun EjemploProgressEnBoton() {
    var cargando by remember { mutableStateOf(false) }

    LaunchedEffect(cargando) {
        if (cargando) {
            delay(2000)
            cargando = false
        }
    }

    Button(
        onClick = { cargando = true },
        enabled = !cargando
    ) {
        if (cargando) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text("Cargando...")
        } else {
            Text("Enviar")
        }
    }
}

// 14
@Composable
fun EjemploProgressCircularPorcentaje() {
    var progreso by remember { mutableFloatStateOf(0.7f) }
    val animado by animateFloatAsState(targetValue = progreso, label = "circular")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { animado },
                modifier = Modifier.size(100.dp),
                strokeWidth = 8.dp,
                trackColor = Color.LightGray
            )

            Text(text = "${(animado * 100).toInt()}%")
        }

        Button(onClick = { progreso = if (progreso >= 1f) 0f else (progreso + 0.1f).coerceAtMost(1f) }) {
            Text("+10%")
        }
    }
}

// 15
@Composable
fun EjemploProgressPersonalizado() {
    var progreso by remember { mutableFloatStateOf(0.4f) }
    val animado by animateFloatAsState(targetValue = progreso, label = "barra")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(animado)
                    .fillMaxHeight()
                    .background(Color(0xFF2E7D32))
            )
        }

        Button(onClick = { progreso = if (progreso >= 1f) 0f else (progreso + 0.2f).coerceAtMost(1f) }) {
            Text("Avanzar")
        }
    }
}