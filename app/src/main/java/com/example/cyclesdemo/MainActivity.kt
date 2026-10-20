package com.example.cyclesdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cyclesdemo.ui.theme.CyclesDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CyclesDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    var epsilonInput by remember { mutableStateOf("0.000001") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = epsilonInput,
            onValueChange = { epsilonInput = it },
            label = { Text("Введите ε (малое число)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            val eps = epsilonInput.trim().replace(',', '.').toDoubleOrNull()
            result = if (eps == null || eps <= 0.0) {
                "Ошибка: ε должно быть положительным числом"
            } else {
                computeSum(eps)
            }
        }) {
            Text("OK")
        }
        Spacer(Modifier.height(16.dp))
        Text(text = result, fontSize = 18.sp)
    }
}

fun computeSum(epsilon: Double): String {
    return "Заглушка"
}