package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Limonada()
                }
            }
        }
    }
}

@Composable
fun Limonada() {
    Column(
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
        ) {

            Text(
                text = "Limonada",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            boton()
        }

    }

}

@Composable
fun boton() {
    var estado by remember { mutableStateOf(0) }
    var clicks by remember { mutableStateOf(0) }
    val exprimir = (2..4).random()
    val imagenes = imagenes()
    val textos = textos()
    Button(
        onClick = {
            if (estado != 3 && estado != 1) {
                estado++
            } else if (estado == 1) {
                clicks++
                if (clicks == exprimir) {
                    estado++
                }
            } else {
                estado = 0
                clicks = 0
            }
        },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
    ) {
        Image(painter = painterResource(id = imagenes[estado]), contentDescription = null)
    }
    Spacer(modifier = Modifier.height(30.dp))
    Text(text = textos[estado])
}


fun imagenes(): ArrayList<Int> {
    var listaImagenes: ArrayList<Int> = ArrayList()
    listaImagenes.add(R.drawable.arbol)
    listaImagenes.add(R.drawable.limon)
    listaImagenes.add(R.drawable.vaso_lleno)
    listaImagenes.add(R.drawable.vaso_vacio)
    return listaImagenes
}

fun textos(): ArrayList<String> {
    var listaImagenes: ArrayList<String> = ArrayList()
    listaImagenes.add("Dale al limonero")
    listaImagenes.add("Exprime el limon")
    listaImagenes.add("bebe")
    listaImagenes.add("empezamos de nuevo")
    return listaImagenes
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LimonadaTheme {
        Limonada()
    }
}