package com.example.sem1_practicagrupal

data class Estudiante(
    val id: Int,
    val nombre: String,
    val email: String,
    val carrera: String,
    var activo: Boolean = true
)

val estudiantesEjemplo = listOf(
    Estudiante(1, "Ana García", "ana@utp.edu.pe", "Ing. de Sistemas"),
    Estudiante(2, "Luis Torres", "luis@utp.edu.pe", "Ing. de Software"),
    Estudiante(3, "María Rojas", "maria@utp.edu.pe", "Ing. de Sistemas"),
    Estudiante(4, "Carlos Díaz", "carlos@utp.edu.pe", "Ing. Industrial"),
    Estudiante(5, "Sofía Mendoza", "sofia@utp.edu.pe", "Ing. de Software")
)