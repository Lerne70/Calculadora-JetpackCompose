package com.lerne.calculate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lerne.calculate.ui.theme.CalculateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Buttons()
                }
            }
        }
    }
}

@Composable
fun Buttons() {

    val modifier = Modifier
        .height(100.dp)
        .width(100.dp)
        .padding(4.dp)

    val modifierColumn = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)

    var text by remember {
        mutableStateOf("")
    }

    MaterialTheme {
        Column(verticalArrangement = Arrangement.Bottom, modifier = modifierColumn) {
            Text(text = text, fontSize = 40.sp, modifier = Modifier.padding(8.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                Button(modifier = modifier, onClick = {
                    text = ""
                }) {
                    Text(text = "AC", fontSize = 24.sp)

                }
                Button(modifier = modifier, onClick = {
                    if(text.isNotEmpty()) {
                        text += "/"
                    }
                }) {
                    Text(text = "/", fontSize = 24.sp)
                }
            }
            Row() {
                Button(modifier = modifier, onClick = {
                    text += "7"
                }) {
                    Text("7", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "8"
                }) {
                    Text("8", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "9"
                }) {
                    Text("9", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    if(text.isNotEmpty()) {
                        text += "x"
                    }
                }) {
                    Text(text = "x", fontSize = 24.sp)
                }
            }
            Row() {
                Button(modifier = modifier, onClick = {
                    text += "4"
                }) {
                    Text("4", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "5"
                }) {
                    Text("5", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "6"
                }) {
                    Text("6", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    if(text.isNotEmpty()) {
                        text += "-"
                    }
                }) {
                    Text(text = "-", fontSize = 24.sp)
                }
            }
            Row() {
                Button(modifier = modifier, onClick = {
                    text += "1"
                }) {
                    Text("1", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "2"
                }) {
                    Text("2", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "3"
                }) {
                    Text("3", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    if(text.isNotEmpty()) {
                        text += "+"
                    }
                }) {
                    Text(text = "+", fontSize = 24.sp)
                }
            }
            Row() {
                Button(modifier = modifier, onClick = {
                    text += "0"
                }) {
                    Text("0", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text += "."
                }) {
                    Text(".", fontSize = 24.sp)
                }
                Button(modifier = modifier, onClick = {
                    text = backspace(text)
                }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Backspace", modifier = Modifier.size(ButtonDefaults.IconSize))
                }
                Button(modifier = modifier, onClick = {
                    text = operacion(texto = text)
                }) {
                    Text(text = "=", fontSize = 24.sp)
                }
            }
        }
    }
}

//var num: String = ""
fun operacion(texto: String): String {
    //num += texto
    val textoFinal: List<String>
    val resultado: Float

    if(texto.contains("+")) {
        textoFinal = texto.split("+")
        resultado = textoFinal[0].toFloat() + textoFinal[1].toFloat()
        return resultado.toString()

    } else if(texto.contains("-")) {
        textoFinal = texto.split("-")
        resultado = textoFinal[0].toFloat() - textoFinal[1].toFloat()
        return resultado.toString()

    } else if(texto.contains("x")) {
        textoFinal = texto.split("x")
        resultado = textoFinal[0].toFloat() * textoFinal[1].toFloat()
        return resultado.toString()

    }else if(texto.contains("/")) {
        textoFinal = texto.split("/")
        resultado = textoFinal[0].toFloat() / textoFinal[1].toFloat()
        return resultado.toString()

    }

    return texto
}

fun backspace(texto: String): String {
    val texto = texto.dropLast(1)

    return texto
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculateTheme {
        Buttons()
    }
}