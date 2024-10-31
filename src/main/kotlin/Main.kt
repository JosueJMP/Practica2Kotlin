package org.example

import org.example.Biblioteca.*
import org.example.Hotel.*
import org.example.Rol.*
import org.example.Estudiantes.*
import org.example.Tareas.*
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val biblioteca = Biblioteca()
    val hotel = Hotel()
    val guerrero = Guerrero("Conan", 100, 10)
    val mago = Mago("Gandalf", 80, 8, 20)
    val usuarioTarea = UsuarioTarea("Josue")

    while (true) {
        println("\n--- Menú Principal ---")
        println("1. Biblioteca")
        println("2. Hotel")
        println("3. Rol")
        println("4. Estudiantes")
        println("5. Tareas")
        println("0. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> bibliotecaMenu(scanner, biblioteca)
            2 -> hotelMenu(scanner, hotel)
            3 -> rolMenu(guerrero, mago)
            4 -> estudiantesMenu(scanner)
            5 -> tareasMenu(scanner, usuarioTarea)
            0 -> {
                println("Saliendo del programa...")
                return
            }

            else -> println("Opción no válida. Intente nuevamente.")
        }
        scanner.nextLine() // Limpiar el buffer
    }
}

// Función del menú de Biblioteca
fun bibliotecaMenu(scanner: Scanner, biblioteca: Biblioteca) {
    println("\n--- Menú de Biblioteca ---")
    val libro1 = Libro("Spiderman", "Marvel", "123456789")
    val libro2 = Libro("Harry Potter", "J.K. Rowling", "987654321")

    biblioteca.agregarLibro(libro1)
    biblioteca.agregarLibro(libro2)

    val usuario1 = UsuarioBiblioteca("Josué", 1)
    val usuario2 = UsuarioBiblioteca("Angelote", 2)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.prestarLibro("123456789", usuario1)
    biblioteca.prestarLibro("987654321", usuario2)
    biblioteca.prestarLibro("123456789", usuario2)

    biblioteca.devolverLibro("123456789")
    biblioteca.devolverLibro("987654321")
    biblioteca.devolverLibro("987654321")
}

// Función del menú de Hotel
fun hotelMenu(scanner: Scanner, hotel: Hotel) {
    println("\n--- Menú de Hotel ---")
    hotel.agregarHabitacion(Habitacion("101"))
    hotel.agregarHabitacion(Habitacion("102"))
    hotel.agregarHabitacion(Habitacion("103"))

    val cliente1 = Cliente("Josué", 1)
    val cliente2 = Cliente("Raul", 2)

    hotel.reservarHabitacion(cliente1, "101")
    hotel.reservarHabitacion(cliente2, "102")
    hotel.reservarHabitacion(cliente1, "101")

    hotel.mostrarReservasActivas()

    hotel.cancelarReserva(cliente1, "101")
    hotel.cancelarReserva(cliente1, "101")

    hotel.mostrarReservasActivas()
}

// Función del menú de Rol
fun rolMenu(guerrero: Guerrero, mago: Mago) {
    println("\n--- Menú de Rol ---")
    val hechizoFuego = Hechizo("Fuego", 15, 5)

    while (guerrero.estaVivo() && mago.estaVivo()) {
        guerrero.atacar(mago)
        if (mago.estaVivo()) {
            mago.lanzarHechizo(hechizoFuego, guerrero)
        }
    }

    if (!guerrero.estaVivo()) {
        println("${guerrero.nombre} ha sido derrotado.")
    }

    if (!mago.estaVivo()) {
        println("${mago.nombre} ha sido derrotado.")
    }
}

// Función del menú de Estudiantes
fun estudiantesMenu(scanner: Scanner) {
    println("\n--- Menú de Estudiantes ---")
    val profesor1 = Profesor("Luis")
    val profesor2 = Profesor("Raul")

    val cursoMatematicas = Curso("Programación", profesor1)
    val cursoCiencias = Curso("Interfaces", profesor2)

    val estudiante1 = Estudiante("Josué")
    val estudiante2 = Estudiante("Angelote")

    profesor1.asignarCurso(estudiante1, cursoMatematicas)
    profesor2.asignarCurso(estudiante1, cursoCiencias)
    profesor1.asignarCurso(estudiante2, cursoMatematicas)

    profesor1.asignarCalificacion(cursoMatematicas, estudiante1, 90)
    profesor2.asignarCalificacion(cursoCiencias, estudiante1, 85)
    profesor1.asignarCalificacion(cursoMatematicas, estudiante2, 95)

    println("Promedio de ${estudiante1.nombre}: ${estudiante1.calcularPromedio()}")
    println("Promedio de ${estudiante2.nombre}: ${estudiante2.calcularPromedio()}")
}

// Función del menú de Tareas
fun tareasMenu(scanner: Scanner, usuarioTarea: UsuarioTarea) {
    println("\n--- Menú de Tareas ---")
    val proyectoPersonal = Proyecto("Proyecto Personal")
    val proyectoTrabajo = Proyecto("Proyecto de Trabajo")

    usuarioTarea.crearProyecto(proyectoPersonal)
    usuarioTarea.crearProyecto(proyectoTrabajo)

    val tarea1 = Tarea("Tarea de Programación")
    val tarea2 = Tarea("Enviar Tarea de Programación")
    val tarea3 = Tarea("Crear un repositorio")

    usuarioTarea.agregarTareaAProyecto(0, tarea1)
    usuarioTarea.agregarTareaAProyecto(1, tarea2)
    usuarioTarea.agregarTareaAProyecto(0, tarea3)

    println("\nProyectos y Tareas Iniciales:")
    usuarioTarea.mostrarProyectos()

    usuarioTarea.marcarTareaComoCompletada(0, 0)

    println("\nProyectos y Tareas Después de Completar una Tarea:")
    usuarioTarea.mostrarProyectos()
}

