package com.gue.quiz3.data

data class Santri(
    val userId: String,
    val name: String,
    val age: Int,
    val kota: Kota
) {
    fun nameAndId() : String = "$name ($userId)"
}
