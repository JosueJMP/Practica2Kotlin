package org.example.Rol

class Mago(nombre: String, vida: Int, ataque: Int, private val mana: Int) : Personaje(nombre, vida, ataque) {
    fun lanzarHechizo(hechizo: Hechizo, objetivo: Personaje) {
        if (mana >= hechizo.costeMana) {
            objetivo.vida -= hechizo.damage
            println("$nombre lanza el hechizo ${hechizo.nombre} a ${objetivo.nombre} y le hace ${hechizo.damage} de daño.")
        } else {
            println("$nombre no tiene suficiente mana para lanzar ${hechizo.nombre}.")
        }
    }
}