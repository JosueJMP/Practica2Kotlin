package org.example.Biblioteca

data class Libro(val titulo: String, val autor: String, val isbn: String, var prestado: Boolean = false)