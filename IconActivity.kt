package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class IconActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploIcon(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploIcon(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "GUÍA DEL COMPONENTE ICON",
            fontSize = 22.sp
        )

        Text(text = "1. Icon básico")
        EjemploIconBasico()

        Text(text = "2. Icon con color personalizado")
        EjemploIconColor()

        Text(text = "3. Icon con tamaño personalizado")
        EjemploIconTamano()

        Text(text = "4. Icon con diferentes colores")
        EjemploIconColores()

        Text(text = "5. Icon dentro de un botón")
        EjemploIconEnBoton()

        Text(text = "6. IconButton")
        EjemploIconButtonIcono()

        Text(text = "7. Icon con fondo de color")
        EjemploIconFondo()

        Text(text = "8. Icon con fondo circular")
        EjemploIconFondoCircular()

        Text(text = "9. Icon con transparencia")
        EjemploIconTransparencia()

        Text(text = "10. Icon dentro de Row y Column")
        EjemploIconRowColumn()

        Text(text = "11. Icon con borde")
        EjemploIconBorde()

        Text(text = "12. Icon con tamaño y fondo personalizados")
        EjemploIconPersonalizado()
    }
}

// 1. Icon básico
@Composable
fun EjemploIconBasico() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Inicio"
    )
}

// 2. Icon con color personalizado
@Composable
fun EjemploIconColor() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito",
        tint = Color.Red
    )
}

// 3. Icon con tamaño personalizado
@Composable
fun EjemploIconTamano() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Inicio grande",
        modifier = Modifier.size(48.dp)
    )
}

// 4. Icon con diferentes colores
@Composable
fun EjemploIconColores() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Correcto",
            tint = Color.Green,
            modifier = Modifier.size(40.dp)
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Cerrar",
            tint = Color.Red,
            modifier = Modifier.size(40.dp)
        )
    }
}

// 5. Icon dentro de un botón
@Composable
fun EjemploIconEnBoton() {
    Button(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Enviar"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "Enviar")
    }
}

// 6. Icon dentro de IconButton
@Composable
fun EjemploIconButtonIcono() {
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Me gusta",
            tint = Color.Red,
            modifier = Modifier.size(32.dp)
        )
    }
}

// 7. Icon con fondo de color
@Composable
fun EjemploIconFondo() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Usuario",
            tint = Color.Blue,
            modifier = Modifier.size(40.dp)
        )
    }
}

// 8. Icon con fondo circular
@Composable
fun EjemploIconFondoCircular() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(40.dp)
        )
    }
}

// 9. Icon con transparencia
@Composable
fun EjemploIconTransparencia() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Inicio transparente",
        modifier = Modifier
            .size(48.dp)
            .alpha(0.5f)
    )
}

// 10. Icon dentro de Row y Column
@Composable
fun EjemploIconRowColumn() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Correo",
                tint = Color.Blue
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Correo electrónico")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Teléfono",
                tint = Color.Green
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Número de teléfono")
        }
    }
}

// 11. Icon con borde
@Composable
fun EjemploIconBorde() {
    Box(
        modifier = Modifier
            .border(
                BorderStroke(2.dp, Color.Red),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Inicio con borde",
            tint = Color.Red,
            modifier = Modifier.size(40.dp)
        )
    }
}

// 12. Icon con tamaño y fondo personalizados
@Composable
fun EjemploIconPersonalizado() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Blue)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorito",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}