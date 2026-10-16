package com.example.componentes

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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

class TextButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploTextButton(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Pantalla: solo llama a cada ejemplo en orden
@Composable
fun EjemploTextButton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "TEXT BUTTON",
            style = MaterialTheme.typography.headlineSmall
        )

        // ---------- NIVEL 1: apariencia (sin estado) ----------
        Text("NIVEL 1: APARIENCIA (sin estado)")

        EjemploTextButtonBasico()
        EjemploTextButtonDeshabilitado()
        EjemploTextButtonColores()
        EjemploTextButtonForma()
        EjemploTextButtonTamano()
        EjemploTextButtonBorde()
        EjemploTextButtonElevacion()
        EjemploTextButtonEspaciado()
        EjemploTextButtonIcono()

        HorizontalDivider()

        // ---------- NIVEL 2: con estado ----------
        Text("NIVEL 2: CON ESTADO")

        EjemploTextButtonContadorMas()
        EjemploTextButtonContadorMenos()
        EjemploTextButtonContadorCinco()
        EjemploTextButtonContadorDiez()
        EjemploTextButtonMensaje()
        EjemploTextButtonReiniciar()
        EjemploTextButtonSinNegativos()
        EjemploTextButtonGrupo()
        EjemploTextButtonLimpiarTexto()
    }
}

// =====================================================
// NIVEL 1: APARIENCIA (sin estado)
// =====================================================

// 1. TextButton básico
@Composable
fun EjemploTextButtonBasico() {
    TextButton(
        onClick = {
            println("Botón presionado")
        }
    ) {
        Text("Botón básico")
    }
}

// 2. TextButton deshabilitado
@Composable
fun EjemploTextButtonDeshabilitado() {
    TextButton(
        onClick = {},
        enabled = false
    ) {
        Text("Botón deshabilitado")
    }
}

// 3. Colores personalizados
@Composable
fun EjemploTextButtonColores() {
    TextButton(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Blue
        )
    ) {
        Text("Botón azul")
    }
}

// 4. Bordes redondeados
@Composable
fun EjemploTextButtonForma() {
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(20.dp)
    ) {
        Text("Esquinas redondeadas")
    }
}

// 5. Tamaño personalizado
@Composable
fun EjemploTextButtonTamano() {
    TextButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        Text("Botón ancho")
    }
}

// 6. Borde personalizado
@Composable
fun EjemploTextButtonBorde() {
    TextButton(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text("Borde rojo")
    }
}

// 7. Elevación
@Composable
fun EjemploTextButtonElevacion() {
    TextButton(
        onClick = {},
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text("Botón con elevación")
    }
}

// 8. Espacio interior
@Composable
fun EjemploTextButtonEspaciado() {
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(
            horizontal = 32.dp,
            vertical = 16.dp
        )
    ) {
        Text("Aceptar")
    }
}

// 9. Icono y texto
@Composable
fun EjemploTextButtonIcono() {
    TextButton(onClick = {}) {
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

// 10. Contador positivo
@Composable
fun EjemploTextButtonContadorMas() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador++ }) {
            Text("+ Aumentar")
        }
    }
}

// 11. Contador negativo
@Composable
fun EjemploTextButtonContadorMenos() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador-- }) {
            Text("- Disminuir")
        }
    }
}

// 12. Aumentar de cinco en cinco
@Composable
fun EjemploTextButtonContadorCinco() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador += 5 }) {
            Text("Aumentar +5")
        }
    }
}

// 13. Aumentar de diez en diez
@Composable
fun EjemploTextButtonContadorDiez() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador += 10 }) {
            Text("Aumentar +10")
        }
    }
}

// 14. Mostrar mensaje
@Composable
fun EjemploTextButtonMensaje() {
    var mensaje by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextButton(
            onClick = {
                mensaje = "¡Hola, bienvenido!"
            }
        ) {
            Text("Saludar")
        }

        Text(mensaje)
    }
}

// 15. Reiniciar contador
@Composable
fun EjemploTextButtonReiniciar() {
    var contador by remember { mutableIntStateOf(0) }
    var mensaje by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador++ }) {
            Text("+ Aumentar")
        }

        TextButton(
            onClick = {
                contador = 0
                mensaje = "Contador reiniciado"
            }
        ) {
            Text("Reiniciar")
        }

        Text(mensaje)
    }
}

// 16. Contador con límite mínimo
@Composable
fun EjemploTextButtonSinNegativos() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        TextButton(onClick = { contador++ }) {
            Text("+ Aumentar")
        }

        TextButton(
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

// 17. Contador completo (grupo de botones)
@Composable
fun EjemploTextButtonGrupo() {
    var contador by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador: $contador")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextButton(onClick = { contador++ }) {
                Text("+1")
            }

            TextButton(
                onClick = {
                    if (contador > 0) {
                        contador--
                    }
                }
            ) {
                Text("-1")
            }

            TextButton(onClick = { contador = 0 }) {
                Text("Reset")
            }
        }
    }
}

// 18. Campo de texto y botón para limpiar
@Composable
fun EjemploTextButtonLimpiarTexto() {
    var nombre by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        TextButton(onClick = { nombre = "" }) {
            Text("Limpiar texto")
        }
    }
}