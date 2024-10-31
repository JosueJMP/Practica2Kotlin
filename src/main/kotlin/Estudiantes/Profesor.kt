package org.example.Estudiantes

class Profesor(val nombre: String) {
    fun asignarCurso(estudiante: Estudiante, curso: Curso) {
        println("Curso ${curso.nombre} asignado a ${estudiante.nombre}.")
    }

    fun asignarCalificacion(curso: Curso, estudiante: Estudiante, nota: Int) {
        estudiante.agregarCalificacion(curso, nota)
        println("Calificación $nota asignada a ${estudiante.nombre} en el curso ${curso.nombre}.")
    }
}