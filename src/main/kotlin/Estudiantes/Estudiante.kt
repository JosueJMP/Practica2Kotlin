package org.example.Estudiantes

class Estudiante(val nombre: String) {
    private val calificaciones = mutableMapOf<Curso, Int>()

    fun agregarCalificacion(curso: Curso, nota: Int) {
        calificaciones[curso] = nota
    }

    fun calcularPromedio(): Double {
        return if (calificaciones.isNotEmpty()) {
            calificaciones.values.average()
        } else {
            0.0
        }
    }
}