package org.example.Tareas

class UsuarioTarea(val nombre: String) {
    private val proyectos = mutableListOf<Proyecto>()

    fun crearProyecto(proyecto: Proyecto) {
        proyectos.add(proyecto)
        println("Proyecto '${proyecto.nombre}' creado por $nombre.")
    }

    fun agregarTareaAProyecto(indiceProyecto: Int, tarea: Tarea) {
        if (indiceProyecto in proyectos.indices) {
            proyectos[indiceProyecto].agregarTarea(tarea)
        } else {
            println("Índice de proyecto no válido.")
        }
    }

    fun mostrarProyectos() {
        proyectos.forEachIndexed { index, proyecto ->
            println("Proyecto $index: ${proyecto.nombre}")
            proyecto.mostrarTareas()
        }
    }

    fun marcarTareaComoCompletada(indiceProyecto: Int, indiceTarea: Int) {
        if (indiceProyecto in proyectos.indices) {
            proyectos[indiceProyecto].completarTarea(indiceTarea)
        } else {
            println("Índice de proyecto no válido.")
        }
    }
}