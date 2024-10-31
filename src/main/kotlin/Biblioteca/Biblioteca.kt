package org.example.Biblioteca

class Biblioteca {
    private val libros = mutableListOf<Libro>()
    private val usuarios = mutableListOf<UsuarioBiblioteca>()

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        println("Libro agregado: ${libro.titulo}")
    }

    fun registrarUsuario(usuario: UsuarioBiblioteca) {
        usuarios.add(usuario)
        println("Usuario registrado: ${usuario.nombre}")
    }

    fun prestarLibro(isbn: String, usuario: UsuarioBiblioteca) {
        val libro = libros.find { it.isbn == isbn && !it.prestado }
        if (libro != null) {
            libro.prestado = true
            println("Libro prestado: ${libro.titulo} a ${usuario.nombre}")
        } else {
            println("El libro con ISBN $isbn no está disponible.")
        }
    }

    fun devolverLibro(isbn: String) {
        val libro = libros.find { it.isbn == isbn && it.prestado }
        if (libro != null) {
            libro.prestado = false
            println("Libro devuelto: ${libro.titulo}")
        } else {
            println("El libro con ISBN $isbn no está en préstamo.")
        }
    }
}