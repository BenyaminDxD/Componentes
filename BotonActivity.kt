package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme

class BotonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // ---------- NIVEL 1: apariencia (sin estado) ----------
                        Titulo("1. Button básico")
                        EjemploButtonBasico()

                        Titulo("2. Deshabilitado")
                        EjemploButtonDeshabilitado()

                        Titulo("3. Colores personalizados")
                        EjemploButtonColores()

                        Titulo("4. Bordes redondeados")
                        EjemploButtonForma()

                        Titulo("5. Tamaño personalizado")
                        EjemploButtonTamano()

                        Titulo("6. Borde personalizado")
                        EjemploButtonBorde()

                        Titulo("7. Elevación y sombra")
                        EjemploButtonSombra()

                        Titulo("8. Espacio interior")
                        EjemploButtonEspaciado()

                        Titulo("9. Con icono")
                        EjemploButtonIcono()

                        // ---------- NIVEL 2: con estado ----------
                        Titulo("10. Contador positivo (+)")
                        EjemploContadorMas()

                        Titulo("11. Contador negativo (-)")
                        EjemploContadorMenos()

                        Titulo("12. Aumentar de cinco en cinco")
                        EjemploContadorDeCinco()

                        Titulo("13. Aumentar de diez en diez")
                        EjemploContadorDiez()

                        Titulo("14. Muestra un mensaje")
                        EjemploButtonMensaje()

                        Titulo("15. Reiniciar contador")
                        EjemploReiniciarContador()

                        Titulo("16. Con límite mínimo")
                        EjemploContadorConLimite()

                        Titulo("17. Aumentar, disminuir y reiniciar")
                        EjemploContadorCompleto()

                        Titulo("18. Limpiar un campo de texto")
                        EjemploButtonLimpiar()
                    }
                }
            }
        }
    }
}

// Título pequeño para separar cada ejemplo
@Composable
fun Titulo(texto: String) {
    Text(
        text = texto,
        style = MaterialTheme.typography.titleMedium
    )
}

// =====================================================
// NIVEL 1: APARIENCIA (sin estado)
// =====================================================

// 1. Button básico
@Composable
fun EjemploButtonBasico() {
    Button(
        onClick = {
            println("Botón presionado")
        }
    ) {
        Text("Presionar")
    }
}

// 2. Deshabilitado
    @Composable
    fun EjemploButtonDeshabilitado() {
        Button(
            onClick = {},
            enabled = false
        ) {
            Text("No disponible")
        }
    }

// 3. Colores personalizados
@Composable
fun EjemploButtonColores() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text("Botón azul")
    }
}

// 4. Bordes redondeados
@Composable
fun EjemploButtonForma() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(20.dp)
    ) {
        Text("Ingresar")
    }
}

// 5. Tamaño personalizado
@Composable
fun EjemploButtonTamano() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(55.dp)
    ) {
        Text("Continuar")
    }
}

// 6. Borde personalizado
@Composable
fun EjemploButtonBorde() {
    Button(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text("Botón con borde")
    }
}

// 7. Elevación y sombra
@Composable
fun EjemploButtonSombra() {
    Button(
        onClick = {},
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        )
    ) {
        Text("Botón con sombra")
    }
}

// 8. Espacio interior
@Composable
fun EjemploButtonEspaciado() {
    Button(
        onClick = {},
        contentPadding = PaddingValues(
            horizontal = 32.dp,
            vertical = 16.dp
        )
    ) {
        Text("Aceptar")
    }
}

// 9. Con icono
@Composable
fun EjemploButtonIcono() {
    Button(onClick = {}) {
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
fun EjemploContadorMas() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Contador: $contador")

        Button(onClick = { contador++ }) {
            Text("+ Aumentar")
        }
    }
}

// 11. Contador negativo
@Composable
fun EjemploContadorMenos() {
    var contador by remember { mutableStateOf(10) }

    Column {
        Text("Contador: $contador")

        Button(onClick = { contador-- }) {
            Text("- Disminuir")
        }
    }
}

// 12. Aumentar de cinco en cinco
@Composable
fun EjemploContadorDeCinco() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Valor: $contador")

        Button(onClick = { contador += 5 }) {
            Text("+5 Aumentar")
        }
    }
}

// 13. Aumentar de diez en diez
@Composable
fun EjemploContadorDiez() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Total: $contador")

        Button(onClick = { contador += 10 }) {
            Text("+10")
        }
    }
}

// 14. Muestra un mensaje
@Composable
fun EjemploButtonMensaje() {
    var mensaje by remember { mutableStateOf("") }

    Column {
        Button(onClick = { mensaje = "¡Hola, bienvenido!" }) {
            Text("Saludar")
        }

        Text(mensaje)
    }
}

// 15. Reiniciar contador
@Composable
fun EjemploReiniciarContador() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Contador: $contador")

        Button(onClick = { contador++ }) {
            Text("+ Aumentar")
        }

        Button(onClick = { contador = 0 }) {
            Text("Reiniciar")
        }
    }
}

// 16. Límite mínimo (usa if)
@Composable
fun EjemploContadorConLimite() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Contador: $contador")

        Button(onClick = { contador++ }) {
            Text("+ Aumentar")
        }

        Button(
            onClick = {
                if (contador > 0) {
                    contador--
                }
            }
        ) {
            Text("- Disminuir")
        }
    }
}

// 17. Aumentar, disminuir y reiniciar
@Composable
fun EjemploContadorCompleto() {
    var contador by remember { mutableStateOf(0) }

    Column {
        Text("Contador: $contador")

        Button(onClick = { contador++ }) {
            Text("+ Aumentar")
        }

        Button(onClick = { contador-- }) {
            Text("- Disminuir")
        }

        Button(onClick = { contador = 0 }) {
            Text("Reiniciar")
        }
    }
}

// 18. Limpiar un campo de texto (combina TextField + estado + Button)
@Composable
fun EjemploButtonLimpiar() {
    var nombre by remember { mutableStateOf("") }

    Column {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        Button(onClick = { nombre = "" }) {
            Text("Limpiar")
        }
    }
}