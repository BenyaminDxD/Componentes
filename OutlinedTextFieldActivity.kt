package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.material3.TextButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
class OutlinedTextFieldActivity : ComponentActivity() {
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
                        OutlinedTextFieldBasico()
                        CampoConContador()
                        CampoConIcono()
                        CampoBusqueda()
                        CampoConValidacion()
                        CampoConLimpiar()
                        OutlinedTextFieldDeshabilitado()
                        OutlinedTextFieldSoloLectura()
                    }
                }
            }
        }
    }
}

// 1. OutlinedTextField básico
@Composable
fun OutlinedTextFieldBasico() {
    var nombre by remember { mutableStateOf("") }

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )
}

// 2. OutlinedTextField con estilos
@Composable
fun CampoConContador() {
    var mensaje by remember { mutableStateOf("") }

    OutlinedTextField(
        value = mensaje,
        onValueChange = {
            if (it.length <= 50) mensaje = it
        },
        label = { Text("Mensaje") },
        supportingText = {
            Text("${mensaje.length}/50 caracteres")
        },
        modifier = Modifier.fillMaxWidth()
    )
}

// 3. OutlinedTextField de varias líneas
@Composable
fun CampoConIcono() {
    var correo by remember { mutableStateOf("") }

    OutlinedTextField(
        value = correo,
        onValueChange = { correo = it },
        label = { Text("Correo electrónico") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Correo"
            )
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

// 4. OutlinedTextField con saludo
@Composable
fun CampoBusqueda() {
    var busqueda by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            label = { Text("Buscar curso") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Text(text = "Buscando: $busqueda")
    }
}

// 5. OutlinedTextField para contraseña
@Composable
fun CampoConValidacion() {
    var correo by remember { mutableStateOf("") }

    val correoValido = correo.contains("@") &&
            correo.contains(".")
    OutlinedTextField(
        value = correo,
        onValueChange = { correo = it },
        label = { Text("Correo electrónico") },
        isError = correo.isNotEmpty() && !correoValido,
        supportingText = {
            if (correo.isNotEmpty() && !correoValido) {
                Text("Ingrese un correo válido")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

// 6. OutlinedTextField numérico
@Composable
fun CampoConLimpiar() {
    var nombre by remember { mutableStateOf("") }

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") },
        trailingIcon = {
            TextButton(
                onClick = { nombre = "" }
            ) {
                Text("Limpiar")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

// 7. OutlinedTextField deshabilitado
@Composable
fun OutlinedTextFieldDeshabilitado() {
    OutlinedTextField(
        value = "Texto fijo",
        onValueChange = {},
        label = { Text("Campo bloqueado") },
        modifier = Modifier.fillMaxWidth(),
        enabled = false
    )
}

// 8. OutlinedTextField de solo lectura
@Composable
fun OutlinedTextFieldSoloLectura() {
    OutlinedTextField(
        value = "EST001",
        onValueChange = {},
        label = { Text("Código del estudiante") },
        modifier = Modifier.fillMaxWidth(),
        readOnly = true
    )
}
