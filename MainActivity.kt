package com.example.componentes

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.ui.theme.ComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

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
                        EjemploTextSimple()
                        EjemploTextConEstilo()
                        LimitarLineaText()
                        BotonIrATextField()
                        BotonIrAOutlinedTextField()
                        BotonIrABoton()
                        BotonIrAOutlinedButton()
                        BotonIrATextButton()
                        BotonIrAImage()
                        BotonIrAIcon()
                        BotonIrAProgressBar()
                        BotonIrAProgressBarAvanzado()
                        BotonIrASwitch()
                        BotonIrADivider()
                        BotonIrADropdownMenu()
                        BotonIrASlider()
                        BotonIrASectionSlider()
                        BotonIrAAlertDialog()
                        BotonIrAScaffold()
                        BotonIrATopAppBar()
                        BotonIrASnackBar()
                        BotonIrABottomBar()
                        BotonIrACheckBox()
                        BotonIrACheckBoxConTexto()
                        BotonIrACard()
                        BotonIrASurface()
                        BotonIrABadgeBox()
                        BotonIrAFloatingActionButton()
                        BotonIrAModalDrawer()
                    }
                }
            }
        }
    }
}

@Composable
fun EjemploTextSimple() {
    Text(text = "Hola mundo, bienvenido a mi guia")
}

@Composable
fun EjemploTextConEstilo() {
    Text(
        text = "Hola mundo pero a color :v",
        color = Color.Red,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LimitarLineaText() {
    Text(
        text = "Hola mundo pero mas largo y limitado y sin corte para que no ocupe toda la pantalla",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun BotonIrATextField() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, TextFieldActivity::class.java))
    }) {
        Text("Ir a TextField")
    }
}

@Composable
fun BotonIrAOutlinedTextField() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, OutlinedTextFieldActivity::class.java))
    }) {
        Text("Ir a OutlinedTextField")
    }
}

@Composable
fun BotonIrABoton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, BotonActivity::class.java))
    }) {
        Text("Ir a Button")
    }
}

@Composable
fun BotonIrAOutlinedButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, OutlinedButtonActivity::class.java))
    }) {
        Text("Ir a OutlinedButton")
    }
}

@Composable
fun BotonIrATextButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, TextButtonActivity::class.java))
    }) {
        Text("Ir a TextButton")
    }
}

@Composable
fun BotonIrAImage() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, ImageActivity::class.java))
    }) {
        Text("Ir a Image")
    }
}

@Composable
fun BotonIrAIcon() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, IconActivity::class.java))
    }) {
        Text("Ir a Icon")
    }
}
@Composable
fun BotonIrAProgressBar() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, ProgressBarActivity::class.java))
    }) {
        Text("Ir a ProgressBar")
    }
}
@Composable
fun BotonIrAProgressBarAvanzado() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, ProgressBarAvanzadoActivity::class.java))
    }) {
        Text("Ir a ProgressBar avanzado")
    }
}
@Composable
fun BotonIrASwitch() {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(
                Intent(context, SwitchActivity::class.java)
            )
        }
    ) {
        Text("Ir a Switch")
    }
}
@Composable
fun BotonIrADivider() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, DividerActivity::class.java))
    }) {
        Text("Ir a Divider")
    }
}
@Composable
fun BotonIrADropdownMenu() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, DropdownMenuActivity::class.java))
    }) {
        Text("Ir a DropdownMenu")
    }
}
@Composable
fun BotonIrASlider() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, SliderActivity::class.java))
    }) {
        Text("Ir a Slider")
    }
}
@Composable
fun BotonIrASectionSlider() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, SectionSliderActivity::class.java))
    }) {
        Text("Ir a Section Slider")
    }
}
@Composable
fun BotonIrAAlertDialog() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, AlertDialogActivity::class.java))
    }) {
        Text("Ir a AlertDialog")
    }
}
@Composable
fun BotonIrAScaffold() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, ScaffoldActivity::class.java))
    }) {
        Text("Ir a Scaffold")
    }
}
@Composable
fun BotonIrATopAppBar() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, TopAppBarActivity::class.java))
    }) {
        Text("Ir a TopAppBar")
    }
}
@Composable
fun BotonIrASnackBar() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, SnackBarActivity::class.java))
    }) {
        Text("Ir a SnackBar")
    }
}
@Composable
fun BotonIrABottomBar() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, BottomBarActivity::class.java))
    }) {
        Text("Ir a BottomBar")
    }
}
@Composable
fun BotonIrACheckBox() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, CheckBoxActivity::class.java))
    }) {
        Text("Ir a CheckBox")
    }
}
@Composable
fun BotonIrACheckBoxConTexto() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, CheckBoxConTextoActivity::class.java))
    }) {
        Text("Ir a CheckBox con texto")
    }
}
@Composable
fun BotonIrACard() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, CardActivity::class.java))
    }) {
        Text("Ir a Card")
    }
}
@Composable
fun BotonIrASurface() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, SurfaceActivity::class.java))
    }) {
        Text("Ir a Surface")
    }
}
@Composable
fun BotonIrABadgeBox() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, BadgeBoxActivity::class.java))
    }) {
        Text("Ir a BadgeBox")
    }
}
@Composable
fun BotonIrAFloatingActionButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, FloatingActionButtonActivity::class.java))
    }) {
        Text("Ir a FloatingActionButton")
    }
}
@Composable
fun BotonIrAModalDrawer() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, ModalDrawerActivity::class.java))
    }) {
        Text("Ir a ModalDrawer")
    }
}