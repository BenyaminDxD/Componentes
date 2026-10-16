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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class DividerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploDivider(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploDivider(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE DIVIDER",
            fontSize = 22.sp
        )

        Text("1. Divider básico")
        EjemploDividerBasico()

        Text("2. Divider con grosor")
        EjemploDividerGrosor()

        Text("3. Divider con color")
        EjemploDividerColor()

        Text("4. Divider con margen lateral")
        EjemploDividerMargen()

        Text("5. Divider de ancho parcial")
        EjemploDividerAnchoParcial()

        Text("6. Divider entre textos")
        EjemploDividerEntreTextos()

        Text("7. Divider con texto en medio")
        EjemploDividerConTexto()

        Text("8. VerticalDivider")
        EjemploDividerVertical()

        Text("9. Lista con divisores")
        EjemploDividerLista()

        Text("10. Divider dentro de una Card")
        EjemploDividerEnCard()

        Text("11. Grosor controlado con botones")
        EjemploDividerControlado()

        Text("12. Hairline")
        EjemploDividerHairline()

        Text("13. DividerDefaults")
        EjemploDividerDefaults()

        Text("14. Divider (versión antigua)")
        EjemploDividerAntiguo()
    }
}

// 1. Divider básico
@Composable
fun EjemploDividerBasico() {
    Column {
        Text("Arriba")
        HorizontalDivider()
        Text("Abajo")
    }
}

// 2. Divider con grosor
@Composable
fun EjemploDividerGrosor() {
    HorizontalDivider(thickness = 4.dp)
}

// 3. Divider con color
@Composable
fun EjemploDividerColor() {
    HorizontalDivider(
        thickness = 2.dp,
        color = Color.Red
    )
}

// 4. Divider con margen lateral
@Composable
fun EjemploDividerMargen() {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}

// 5. Divider de ancho parcial
@Composable
fun EjemploDividerAnchoParcial() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(0.5f),
            thickness = 3.dp,
            color = Color.Blue
        )
    }
}

// 6. Divider entre textos
@Composable
fun EjemploDividerEntreTextos() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Nombre: Benjamin")
        HorizontalDivider()
        Text("Carrera: Ingeniería de Sistemas")
        HorizontalDivider()
        Text("Ciudad: Puno")
    }
}

// 7. Divider con texto en medio
@Composable
fun EjemploDividerConTexto() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f))

        Text(
            text = "  O  ",
            color = Color.Gray
        )

        HorizontalDivider(modifier = Modifier.weight(1f))
    }
}

// 8. VerticalDivider
@Composable
fun EjemploDividerVertical() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Inicio")
        VerticalDivider()
        Text("Perfil")
        VerticalDivider()
        Text("Ajustes")
    }
}

// 9. Lista con divisores
@Composable
fun EjemploDividerLista() {
    val frutas = listOf("Manzana", "Plátano", "Naranja", "Uva")

    Column {
        frutas.forEachIndexed { indice, fruta ->
            Text(
                text = fruta,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // No se dibuja divisor después del último elemento
            if (indice < frutas.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}

// 10. Divider dentro de una Card
@Composable
fun EjemploDividerEnCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Resumen del pedido",
                fontWeight = FontWeight.Bold
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Producto")
                Text("S/ 40.00")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Envío")
                Text("S/ 5.00")
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", fontWeight = FontWeight.Bold)
                Text("S/ 45.00", fontWeight = FontWeight.Bold)
            }
        }
    }
}

// 11. Grosor controlado con botones (usa estado)
@Composable
fun EjemploDividerControlado() {
    var grosor by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Grosor: $grosor dp")

        HorizontalDivider(
            thickness = grosor.dp,
            color = Color.Magenta
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { grosor-- },
                enabled = grosor > 1
            ) {
                Text("- Grosor")
            }

            Button(
                onClick = { grosor++ },
                enabled = grosor < 20
            ) {
                Text("+ Grosor")
            }
        }
    }
}

// 12. Hairline: una línea de un solo píxel, sin importar la densidad de pantalla
@Composable
fun EjemploDividerHairline() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Hairline (1 píxel)")
        HorizontalDivider(thickness = Dp.Hairline)

        Text("Grosor normal (1 dp)")
        HorizontalDivider(thickness = 1.dp)
    }
}

// 13. DividerDefaults: valores por defecto del componente
@Composable
fun EjemploDividerDefaults() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Grosor por defecto: ${DividerDefaults.Thickness}")

        // Equivale a HorizontalDivider() sin parámetros
        HorizontalDivider(
            thickness = DividerDefaults.Thickness,
            color = DividerDefaults.color
        )

        // Triple de grosor, mismo color por defecto
        HorizontalDivider(
            thickness = DividerDefaults.Thickness * 3,
            color = DividerDefaults.color
        )

        // Color del tema en lugar del color por defecto
        HorizontalDivider(
            thickness = 3.dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

// 14. Divider (versión antigua, deprecada)
@Suppress("DEPRECATION")
@Composable
fun EjemploDividerAntiguo() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Divider (antiguo)")
        Divider(thickness = 2.dp, color = Color.Gray)
    }
}