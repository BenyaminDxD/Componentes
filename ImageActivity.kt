package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploImage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploImage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE IMAGE",
            fontSize = 22.sp
        )

        Text(text = "1. Image básico")
        EjemploImageBasico()

        Text(text = "2. Image con tamaño personalizado")
        EjemploImageTamano()

        Text(text = "3. Image con ancho y alto")
        EjemploImageAnchoAlto()

        Text(text = "4. Image con ContentScale.Crop")
        EjemploImageContentScale()

        Text(text = "5. Image con bordes redondeados")
        EjemploImageRedondeada()

        Text(text = "6. Image circular")
        EjemploImageCircular()

        Text(text = "7. Image con borde azul")
        EjemploImageBorde()

        Text(text = "8. Image con transparencia")
        EjemploImageTransparencia()

        Text(text = "9. Image dentro de Column")
        EjemploImageEnColumn()

        Text(text = "10. Image dentro de Row")
        EjemploImageEnRow()

        Text(text = "11. Image que cambia con un botón")
        EjemploImageCambiar()
    }
}

// 1. Imagen básica
@Composable
fun EjemploImageBasico() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen básica"
    )
}

// 2. Imagen con tamaño personalizado
@Composable
fun EjemploImageTamano() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen con tamaño personalizado",
        modifier = Modifier.size(150.dp)
    )
}

// 3. Imagen con ancho y alto diferentes
@Composable
fun EjemploImageAnchoAlto() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen rectangular",
        modifier = Modifier
            .width(200.dp)
            .height(120.dp)
    )
}

// 4. Imagen con ContentScale
@Composable
fun EjemploImageContentScale() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen ajustada",
        modifier = Modifier.size(200.dp),
        contentScale = ContentScale.Crop
    )
}

// 5. Imagen con bordes redondeados
@Composable
fun EjemploImageRedondeada() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen redondeada",
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

// 6. Imagen circular
@Composable
fun EjemploImageCircular() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen circular",
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

// 7. Imagen con borde de color
@Composable
fun EjemploImageBorde() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen con borde azul",
        modifier = Modifier
            .size(180.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 3.dp,
                color = Color.Blue,
                shape = RoundedCornerShape(12.dp)
            ),
        contentScale = ContentScale.Crop
    )
}

// 8. Imagen con transparencia
@Composable
fun EjemploImageTransparencia() {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen transparente",
        modifier = Modifier
            .size(200.dp)
            .alpha(0.5f)
    )
}

// 9. Imagen dentro de Column
@Composable
fun EjemploImageEnColumn() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.imagen),
            contentDescription = "Imagen dentro de Column",
            modifier = Modifier.size(120.dp)
        )

        Text(text = "Mi imagen")
    }
}

// 10. Imagen dentro de Row
@Composable
fun EjemploImageEnRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.imagen),
            contentDescription = "Imagen dentro de Row",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(text = "Descripción de la imagen")
    }
}

// 11. Cambiar imagen con un botón (usa estado)
@Composable
fun EjemploImageCambiar() {
    var cambiar by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(
                id = if (cambiar) {
                    R.drawable.imagen2
                } else {
                    R.drawable.imagen
                }
            ),
            contentDescription = "Imagen que cambia",
            modifier = Modifier.size(180.dp)
        )

        Button(onClick = { cambiar = !cambiar }) {
            Text(text = "Cambiar imagen")
        }
    }
}