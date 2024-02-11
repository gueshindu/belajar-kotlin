package com.gue.quiz3.data

class DataContoh {
    fun loadExampleData(): List<Santri> {
        val listKota = listOf(
            Kota(kotaId = "1", name = "Pekalongan"),
            Kota(kotaId = "2", name = "Jakarta"),
            Kota(kotaId = "3", name = "Surabaya"),
            Kota(kotaId = "4", name = "Semarang"),
            Kota(kotaId = "5", name = "Solo"),
            Kota(kotaId = "6", name = "Salatiga"),
            Kota(kotaId = "7", name = "Sleman"),
            Kota(kotaId = "8", name = "Cirebon")
        )

        return listOf(
            Santri(
                userId = "HTS-0001",
                name = "Aisyah",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0002",
                name = "Adinda",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0003",
                name = "Indirani",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0004",
                name = "Candra",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0005",
                name = "Yoyok",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0006",
                name = "Dodik",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0007",
                name = "Efendi",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0008",
                name = "Nizar",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0009",
                name = "Zaid",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0010",
                name = "Haifa",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0011",
                name = "Hafsho",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
            Santri(
                userId = "HTS-0012",
                name = "Agus",
                age = (17..45).random(),
                kota = listKota[(0..7).random()]
            ),
        )
    }
}