package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlinx.coroutines.delay

class ProgressBarAvanzadoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploProgressBarAvanzado(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploProgressBarAvanzado(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DE PROGRESSBAR AVANZADO",
            fontSize = 22.sp
        )

        Text("1. Animación con duración (tween)")
        EjemploAvanzadoTween()

        Text("2. Color que cambia según el valor")
        EjemploAvanzadoColorDinamico()

        Text("3. Mensaje de estado")
        EjemploAvanzadoEstadoTexto()

        Text("4. Progreso por pasos")
        EjemploAvanzadoPasos()

        Text("5. Barra con degradado")
        EjemploAvanzadoDegradado()

        Text("6. Lista de barras")
        EjemploAvanzadoListaBarras()

        Text("7. Progreso de un formulario")
        EjemploAvanzadoFormulario()

        Text("8. Carga con pausa y cancelar")
        EjemploAvanzadoPausaReanudar()

        Text("9. Temporizador circular")
        EjemploAvanzadoTemporizador()

        Text("10. Circular con icono al completar")
        EjemploAvanzadoCompletado()
    }
}

// 1. Animación con duración (tween)
@Composable
fun EjemploAvanzadoTween() {
    var objetivo by remember { mutableFloatStateOf(0f) }
    val animado by animateFloatAsState(
        targetValue = objetivo,
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
        label = "tween"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinearProgressIndicator(
            progress = { animado },
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        Text("${(animado * 100).toInt()}%")

        Button(onClick = { objetivo = if (objetivo >= 1f) 0f else 1f }) {
            Text(if (objetivo >= 1f) "Reiniciar" else "Llenar en 1.5 s")
        }
    }
}

// 2. Color que cambia según el valor
@Composable
fun EjemploAvanzadoColorDinamico() {
    var progreso by remember { mutableFloatStateOf(0.2f) }

    val color = when {
        progreso < 0.4f -> Color.Red
        progreso < 0.8f -> Color(0xFFFFA000)
        else -> Color(0xFF2E7D32)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinearProgressIndicator(
            progress = { progreso },
            color = color,
            trackColor = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        Text("${(progreso * 100).toInt()}%")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { progreso = (progreso - 0.1f).coerceAtLeast(0f) }) {
                Text("-10%")
            }

            Button(onClick = { progreso = (progreso + 0.1f).coerceAtMost(1f) }) {
                Text("+10%")
            }
        }
    }
}

// 3. Mensaje de estado
@Composable
fun EjemploAvanzadoEstadoTexto() {
    var progreso by remember { mutableFloatStateOf(0f) }

    val estado = when {
        progreso == 0f -> "Sin iniciar"
        progreso < 0.5f -> "Iniciando..."
        progreso < 1f -> "Casi listo..."
        else -> "¡Completado!"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(estado, fontWeight = FontWeight.Bold)

        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { progreso = (progreso + 0.25f).coerceAtMost(1f) }) {
                Text("+25%")
            }

            Button(onClick = { progreso = 0f }) {
                Text("Reset")
            }
        }
    }
}

// 4. Progreso por pasos
@Composable
fun EjemploAvanzadoPasos() {
    val totalPasos = 4
    var pasoActual by remember { mutableIntStateOf(1) }

    val progreso = pasoActual / totalPasos.toFloat()
    val animado by animateFloatAsState(targetValue = progreso, label = "pasos")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Paso $pasoActual de $totalPasos")

        LinearProgressIndicator(
            progress = { animado },
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = { pasoActual-- },
                enabled = pasoActual > 1
            ) {
                Text("Anterior")
            }

            Button(
                onClick = { pasoActual++ },
                enabled = pasoActual < totalPasos
            ) {
                Text("Siguiente")
            }
        }
    }
}

// 5. Barra con degradado (hecha con Box)
@Composable
fun EjemploAvanzadoDegradado() {
    var progreso by remember { mutableFloatStateOf(0.3f) }
    val animado by animateFloatAsState(targetValue = progreso, label = "degradado")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
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
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFF00BCD4), Color(0xFF3F51B5))
                        )
                    )
            )
        }

        Button(onClick = { progreso = if (progreso >= 1f) 0f else (progreso + 0.2f).coerceAtMost(1f) }) {
            Text("Avanzar")
        }
    }
}

// 6. Lista de barras
@Composable
fun EjemploAvanzadoListaBarras() {
    val habilidades = listOf(
        "Kotlin" to 0.8f,
        "Python" to 0.9f,
        "C++" to 0.6f,
        "SQL" to 0.7f
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        habilidades.forEach { (nombre, nivel) ->
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(nombre)
                    Text("${(nivel * 100).toInt()}%")
                }

                LinearProgressIndicator(
                    progress = { nivel },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }
        }
    }
}

// 7. Progreso de un formulario
@Composable
fun EjemploAvanzadoFormulario() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    val llenos = listOf(nombre, correo, telefono).count { it.isNotBlank() }
    val progreso by animateFloatAsState(targetValue = llenos / 3f, label = "formulario")

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Completado: $llenos de 3 campos")

        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// 8. Carga con pausa y cancelar
@Composable
fun EjemploAvanzadoPausaReanudar() {
    var progreso by remember { mutableFloatStateOf(0f) }
    var corriendo by remember { mutableStateOf(false) }

    LaunchedEffect(corriendo) {
        while (corriendo && progreso < 1f) {
            delay(100)
            progreso = (progreso + 0.02f).coerceAtMost(1f)
        }
        if (progreso >= 1f) corriendo = false
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )

        Text("${(progreso * 100).toInt()}%")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { corriendo = !corriendo },
                enabled = progreso < 1f
            ) {
                Text(
                    when {
                        progreso >= 1f -> "Completado"
                        corriendo -> "Pausar"
                        progreso > 0f -> "Reanudar"
                        else -> "Iniciar"
                    }
                )
            }

            OutlinedButton(
                onClick = {
                    corriendo = false
                    progreso = 0f
                }
            ) {
                Text("Cancelar")
            }
        }
    }
}

// 9. Temporizador circular
@Composable
fun EjemploAvanzadoTemporizador() {
    val total = 10
    var restante by remember { mutableIntStateOf(total) }
    var activo by remember { mutableStateOf(false) }

    LaunchedEffect(activo) {
        while (activo && restante > 0) {
            delay(1000)
            restante--
        }
        activo = false
    }

    val progreso by animateFloatAsState(
        targetValue = restante / total.toFloat(),
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "tiempo"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { progreso },
                modifier = Modifier.size(120.dp),
                strokeWidth = 10.dp,
                trackColor = Color.LightGray
            )

            Text(
                text = "$restante s",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { activo = true },
                enabled = !activo && restante > 0
            ) {
                Text("Iniciar")
            }

            OutlinedButton(
                onClick = {
                    activo = false
                    restante = total
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}

// 10. Circular con icono al completar
@Composable
fun EjemploAvanzadoCompletado() {
    var progreso by remember { mutableFloatStateOf(0f) }
    var cargando by remember { mutableStateOf(false) }

    LaunchedEffect(cargando) {
        if (cargando) {
            progreso = 0f
            while (progreso < 1f) {
                delay(80)
                progreso = (progreso + 0.05f).coerceAtMost(1f)
            }
            cargando = false
        }
    }

    val verde = Color(0xFF2E7D32)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { progreso },
                modifier = Modifier.size(100.dp),
                strokeWidth = 8.dp,
                color = if (progreso >= 1f) verde else MaterialTheme.colorScheme.primary,
                trackColor = Color.LightGray
            )

            if (progreso >= 1f) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Completado",
                    tint = verde,
                    modifier = Modifier.size(48.dp)
                )
            } else {
                Text("${(progreso * 100).toInt()}%")
            }
        }

        Button(
            onClick = { cargando = true },
            enabled = !cargando
        ) {
            Text(
                when {
                    cargando -> "Cargando..."
                    progreso >= 1f -> "Repetir"
                    else -> "Iniciar"
                }
            )
        }
    }
}