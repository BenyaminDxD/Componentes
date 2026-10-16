package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class SliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploSlider(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploSlider(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE SLIDER",
            fontSize = 22.sp
        )

        Text("1. Slider básico")
        EjemploSliderBasico()

        Text("2. Slider que muestra su valor")
        EjemploSliderValor()

        Text("3. Slider con pasos")
        EjemploSliderPasos()

        Text("4. Slider con colores personalizados")
        EjemploSliderColores()

        Text("5. Slider deshabilitado")
        EjemploSliderDeshabilitado()

        Text("6. Slider con valor final")
        EjemploSliderValorFinal()

        Text("7. RangeSlider con dos extremos")
        EjemploRangeSlider()

        Text("8. Slider que controla un texto")
        EjemploSliderControl()

        Text("9. Slider con etiqueta de porcentaje")
        EjemploSliderPorcentaje()
    }
}

// 1. Slider básico
@Composable
fun EjemploSliderBasico() {
    var valor by remember { mutableFloatStateOf(0.5f) }

    Slider(
        value = valor,
        onValueChange = { valor = it },
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}

// 2. Slider que muestra su valor
@Composable
fun EjemploSliderValor() {
    var valor by remember { mutableFloatStateOf(50f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Valor: ${valor.toInt()}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..100f,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 3. Slider con pasos
@Composable
fun EjemploSliderPasos() {
    var valor by remember { mutableFloatStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Nivel: ${valor.toInt()}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..5f,
            steps = 4,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 4. Slider con colores personalizados
@Composable
fun EjemploSliderColores() {
    var valor by remember { mutableFloatStateOf(0.3f) }

    Slider(
        value = valor,
        onValueChange = { valor = it },
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTrackColor = Color.Red,
            inactiveTrackColor = Color.LightGray
        ),
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}

// 5. Slider deshabilitado
@Composable
fun EjemploSliderDeshabilitado() {
    var valor by remember { mutableFloatStateOf(0.6f) }

    Slider(
        value = valor,
        onValueChange = { valor = it },
        enabled = false,
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}

// 6. Slider con valor final
@Composable
fun EjemploSliderValorFinal() {
    var valorActual by remember { mutableFloatStateOf(0f) }
    var valorFinal by remember { mutableFloatStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Arrastrando: ${valorActual.toInt()}")
        Text("Valor guardado: ${valorFinal.toInt()}")
        Slider(
            value = valorActual,
            onValueChange = { valorActual = it },
            onValueChangeFinished = { valorFinal = valorActual },
            valueRange = 0f..100f,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 7. RangeSlider con dos extremos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploRangeSlider() {
    var rango by remember { mutableStateOf(20f..80f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Desde ${rango.start.toInt()} hasta ${rango.endInclusive.toInt()}")
        RangeSlider(
            value = rango,
            onValueChange = { rango = it },
            valueRange = 0f..100f,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 8. Slider que controla un texto
@Composable
fun EjemploSliderControl() {
    var tamano by remember { mutableFloatStateOf(20f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Texto de ejemplo",
            fontSize = tamano.sp
        )
        Slider(
            value = tamano,
            onValueChange = { tamano = it },
            valueRange = 12f..36f,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 9. Slider con etiqueta de porcentaje
@Composable
fun EjemploSliderPorcentaje() {
    var valor by remember { mutableFloatStateOf(0.4f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Avance: ${(valor * 100).toInt()}%")
        LinearProgressIndicator(
            progress = { valor },
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Slider(
            value = valor,
            onValueChange = { valor = it },
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}