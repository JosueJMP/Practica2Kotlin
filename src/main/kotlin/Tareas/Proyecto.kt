package org.example.Tareas

class Proyecto(val nombre: String) {
    private val tareas = mutableListOf<Tarea>()

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
        println("Tarea '${tarea.nombre}' agregada al proyecto $nombre.")
    }

    fun mostrarTareas() {
        tareas.forEachIndexed { index, tarea ->
            val estado = if (tarea.completada) "Completada" else "Pendiente"
            println("$index: ${tarea.nombre} - $estado")
        }
    }

    fun completarTarea(indice: Int) {
        if (indice in tareas.indices) {
            tareas[indice].completada = true
            println("Tarea '${tareas[indice].nombre}' marcada como completada.")
        } else {
            println("Índice de tarea no válido.")
        }
    }
}