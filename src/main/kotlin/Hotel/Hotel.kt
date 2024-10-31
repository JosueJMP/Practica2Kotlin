package org.example.Hotel

class Hotel {
    private val habitaciones = mutableListOf<Habitacion>()

    fun agregarHabitacion(habitacion: Habitacion) {
        habitaciones.add(habitacion)
        println("Habitación ${habitacion.numero} agregada al hotel.")
    }

    fun reservarHabitacion(cliente: Cliente, numeroHabitacion: String) {
        val habitacion = habitaciones.find { it.numero == numeroHabitacion && !it.reservada }
        if (habitacion != null) {
            habitacion.reservada = true
            println("Habitación ${habitacion.numero} reservada por ${cliente.nombre}.")
        } else {
            println("La habitación $numeroHabitacion no está disponible.")
        }
    }

    fun cancelarReserva(cliente: Cliente, numeroHabitacion: String) {
        val habitacion = habitaciones.find { it.numero == numeroHabitacion && it.reservada }
        if (habitacion != null) {
            habitacion.reservada = false
            println("Reserva de la habitación ${habitacion.numero} cancelada por ${cliente.nombre}.")
        } else {
            println("La habitación $numeroHabitacion no está reservada.")
        }
    }

    fun mostrarReservasActivas() {
        val reservas = habitaciones.filter { it.reservada }
        if (reservas.isNotEmpty()) {
            println("Reservas activas:")
            reservas.forEach { println("Habitación ${it.numero}") }
        } else {
            println("No hay reservas activas.")
        }
    }
}