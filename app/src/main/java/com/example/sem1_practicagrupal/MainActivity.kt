package com.example.sem1_practicagrupal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sem1_practicagrupal.ui.theme.Sem1_PracticaGrupalTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sem1_PracticaGrupalTheme {
                AppNavegacion()
            }
        }
    }
}
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            PantallaLista(
                estudiantes = estudiantesEjemplo,
                onVerPerfil = { estudiante ->
                    navController.navigate("perfil/${estudiante.id}")
                }
            )
        }
        composable("perfil/{estudianteId}",
            arguments = listOf(navArgument("estudianteId") {
                type = NavType.IntType })) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("estudianteId")
            val estudiante = estudiantesEjemplo.find { it.id == id }
            if (estudiante != null) {
                PantallaPerfil(
                    estudiante = estudiante,
                    onVolver = { navController.popBackStack() }
                )
            }
        }
    }
}