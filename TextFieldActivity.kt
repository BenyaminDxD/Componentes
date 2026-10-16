package com.example.componentes

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        EjemploTextFieldSimple()
                        EjemploTextFieldConEstilo()
                        TextFieldMultilinea()
                        TextFieldConSaludo()
                        //TextFieldConPlaceholder()
                        TextFieldContrasena()
                        TextFieldNumerico()
                        TextFieldDeshabilitado()
                        TextFieldControlado()
                    }
                }
            }
        }
    }
}

// 1. TextField básico
@Composable
fun EjemploTextFieldSimple() {
    var nombre by remember { mutableStateOf("") }

    TextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )
}

// 2. TextField con estilo
@Composable
fun EjemploTextFieldConEstilo() {
    var nombre by remember { mutableStateOf("") }

    TextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre completo") },
        placeholder = { Text("Ingrese su nombre") },
        textStyle = TextStyle(
            color = Color.Red,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}
@Composable
fun TextFieldMultilinea() {
    var descripcion by remember { mutableStateOf("") }

    TextField(
        value = descripcion,
        onValueChange = { descripcion = it },
        label = { Text("Descripción") },
        placeholder = { Text("Escriba una descripción") },
        singleLine = false,
        maxLines = 4,
        modifier = Modifier.fillMaxWidth()
    )
}

// 3. TextField con saludo
@Composable
fun TextFieldConSaludo() {
    var nombre by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Hola, $nombre")
    }
}

// 4. TextField con placeholder
@Composable
fun TextFieldConPlaceholder() {
    var correo by remember { mutableStateOf("") }

    TextField(
        value = correo,
        onValueChange = { correo = it },
        label = { Text("Correo") },
        placeholder = { Text("ejemplo@correo.com") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

// 5. TextField para contraseña
@Composable
fun TextFieldContrasena() {
    var clave by remember { mutableStateOf("") }

    TextField(
        value = clave,
        onValueChange = { clave = it },
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

// 6. TextField numérico
@Composable
fun TextFieldNumerico() {
    var edad by remember { mutableStateOf("") }

    TextField(
        value = edad,
        onValueChange = { edad = it },
        label = { Text("Edad") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

// 7. TextField deshabilitado
@Composable
fun TextFieldDeshabilitado() {
    TextField(
        value = "Texto fijo",
        onValueChange = {},
        label = { Text("Campo bloqueado") },
        modifier = Modifier.fillMaxWidth(),
        enabled = false
    )
}
@Composable
fun TextFieldControlado() {
    var codigo by remember { mutableStateOf("EST001") }

    TextField(
        value = codigo,
        onValueChange = { codigo = it },
        label = { Text("Código del estudiante") },
        readOnly = true,
        modifier = Modifier.fillMaxWidth()
    )
}