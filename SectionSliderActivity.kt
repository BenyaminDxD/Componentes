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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme
import kotlin.math.roundToInt

class SectionSliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploSectionSlider(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploSectionSlider(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE SECTION SLIDER",
            fontSize = 22.sp
        )

        Text("1. Section Slider básico")
        EjemploSectionSliderBasico()

        Text("2. Section Slider con nombres")
        EjemploSectionSliderNombres()

        Text("3. Section Slider con etiquetas bajo la barra")
        EjemploSectionSliderEtiquetas()

        Text("4. Section Slider con etiqueta resaltada")
        EjemploSectionSliderResaltado()

        Text("5. Section Slider con botones para saltar")
        EjemploSectionSliderBotones()

        Text("6. Section Slider con marcas personalizadas")
        EjemploSectionSliderMarcas()

        Text("7. Section Slider que cambia de color por sección")
        EjemploSectionSliderColorSeccion()

        Text("8. Section Slider que cambia el contenido")
        EjemploSectionSliderContenido()

        Text("9. Section Slider en una tarjeta de ajustes")
        EjemploSectionSliderTarjeta()
    }
}

// 1. Section Slider básico
@Composable
fun EjemploSectionSliderBasico() {
    var valor by remember { mutableFloatStateOf(1f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Sección: ${valor.roundToInt()}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 1f..4f,
            steps = 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 2. Section Slider con nombres
@Composable
fun EjemploSectionSliderNombres() {
    val secciones = listOf("Bajo", "Medio", "Alto")
    var valor by remember { mutableFloatStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Nivel: ${secciones[valor.roundToInt()]}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(secciones.size - 1).toFloat(),
            steps = secciones.size - 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 3. Section Slider con etiquetas bajo la barra
@Composable
fun EjemploSectionSliderEtiquetas() {
    val secciones = listOf("Bajo", "Medio", "Alto")
    var valor by remember { mutableFloatStateOf(1f) }

    Column {
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(secciones.size - 1).toFloat(),
            steps = secciones.size - 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            secciones.forEach { nombre ->
                Text(nombre)
            }
        }
    }
}

// 4. Section Slider con etiqueta resaltada
@Composable
fun EjemploSectionSliderResaltado() {
    val secciones = listOf("Pequeño", "Mediano", "Grande", "Enorme")
    var valor by remember { mutableFloatStateOf(0f) }

    Column {
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(secciones.size - 1).toFloat(),
            steps = secciones.size - 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            secciones.forEachIndexed { indice, nombre ->
                val activa = indice == valor.roundToInt()
                Text(
                    text = nombre,
                    fontWeight = if (activa) FontWeight.Bold else FontWeight.Normal,
                    color = if (activa) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

// 5. Section Slider con botones para saltar
@Composable
fun EjemploSectionSliderBotones() {
    val secciones = listOf("Mañana", "Tarde", "Noche")
    var valor by remember { mutableFloatStateOf(0f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Horario: ${secciones[valor.roundToInt()]}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(secciones.size - 1).toFloat(),
            steps = secciones.size - 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            secciones.forEachIndexed { indice, nombre ->
                OutlinedButton(onClick = { valor = indice.toFloat() }) {
                    Text(nombre)
                }
            }
        }
    }
}

// 6. Section Slider con marcas personalizadas
@Composable
fun EjemploSectionSliderMarcas() {
    var valor by remember { mutableFloatStateOf(2f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Sección: ${valor.roundToInt()}")
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 1f..5f,
            steps = 3,
            colors = SliderDefaults.colors(
                activeTrackColor = Color(0xFF1565C0),
                inactiveTrackColor = Color.LightGray,
                activeTickColor = Color.White,
                inactiveTickColor = Color.DarkGray
            ),
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 7. Section Slider que cambia de color por sección
@Composable
fun EjemploSectionSliderColorSeccion() {
    val secciones = listOf("Bajo", "Medio", "Alto")
    var valor by remember { mutableFloatStateOf(0f) }

    val color = when (valor.roundToInt()) {
        0 -> Color(0xFF2E7D32)
        1 -> Color(0xFFF9A825)
        else -> Color(0xFFC62828)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Riesgo: ${secciones[valor.roundToInt()]}", color = color)
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(secciones.size - 1).toFloat(),
            steps = secciones.size - 2,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTrackColor = color
            ),
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 8. Section Slider que cambia el contenido
@Composable
fun EjemploSectionSliderContenido() {
    val niveles = listOf(
        "Fácil" to "Ideal para empezar",
        "Normal" to "Equilibrado para la mayoría",
        "Difícil" to "Solo para expertos"
    )
    var valor by remember { mutableFloatStateOf(0f) }
    val indice = valor.roundToInt()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(niveles[indice].first, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(niveles[indice].second)
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..(niveles.size - 1).toFloat(),
            steps = niveles.size - 2,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

// 9. Section Slider en una tarjeta de ajustes
@Composable
fun EjemploSectionSliderTarjeta() {
    val secciones = listOf("Baja", "Media", "Alta")
    var valor by remember { mutableFloatStateOf(1f) }

    Card(modifier = Modifier.padding(horizontal = 16.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Calidad de imagen", fontWeight = FontWeight.Bold)
                Text(
                    text = secciones[valor.roundToInt()],
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Slider(
                value = valor,
                onValueChange = { valor = it },
                valueRange = 0f..(secciones.size - 1).toFloat(),
                steps = secciones.size - 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                secciones.forEach { nombre ->
                    Text(nombre, fontSize = 12.sp)
                }
            }
        }
    }
}