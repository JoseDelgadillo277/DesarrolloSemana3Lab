package com.example.sem1_practicagrupal

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PantallaPerfil(estudiante: Estudiante, onVolver: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") },
                navigationIcon = {
                    IconButton(onClick = onVolver) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(padding).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(shape = MaterialTheme.shapes.extraLarge,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(100.dp)) {
                Icon(Icons.Default.Person, null,
                            Modifier.padding(22.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }
            Spacer(Modifier.height(20.dp))
            Text(estudiante.nombre, fontSize = 26.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(24.dp))
            Card(modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(2.dp)) {
                Column(Modifier.padding(20.dp)) {
                    FilaDato(Icons.Default.School, "Carrera", estudiante.carrera)
                    HorizontalDivider(Modifier.padding(vertical = 12.dp))
                    FilaDato(Icons.Default.Email, "Correo", estudiante.email)
                    HorizontalDivider(Modifier.padding(vertical = 12.dp))
                    FilaDato(Icons.Default.Person, "ID", "#${estudiante.id}")
                }
            }
            Spacer(Modifier.height(32.dp))
            Button(onClick = onVolver,
                modifier = Modifier.fillMaxWidth()) {
                Text("Volver a la lista")
            }
        }
    }
}
@Composable
fun FilaDato(
    icono: androidx.compose.ui.graphics.vector.ImageVector,
    etiqueta: String, valor: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icono, null, tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp))
        Spacer(Modifier.width(12.dp))
        Column {
            Text(etiqueta, fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(valor, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        }
    }
}