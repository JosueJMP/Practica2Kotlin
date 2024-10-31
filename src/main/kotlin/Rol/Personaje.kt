package org.example.Rol

open class Personaje(val nombre: String, var vida: Int, val ataque: Int) {
    fun estaVivo(): Boolean = vida > 0

    open fun atacar(objetivo: Personaje) {
        objetivo.vida -= ataque
        println("$nombre ataca a ${objetivo.nombre} y le hace $ataque de daño.")
    }
}