package com.example.flagquiz

object Constants {
    fun getQuestion() : ArrayList<Question> {
        val questionsList = ArrayList<Question> ()

        val soal1 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.canada,
            "Kanada",
            "Swiss",
            "Italia",
            "Malaysia",
            1)

        val soal2 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.japan,
            "Thailand",
            "Kenya",
            "Jepang",
            "Qatar",
            3)

        val soal3 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.india,
            "Iran",
            "Rusia",
            "India",
            "Belgia",
            3)

        val soal4 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.germany,
            "Rumania",
            "Australia",
            "Meksiko",
            "Jerman",
            4)

        val soal5 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.indonesia,
            "Singapura",
            "Indonesia",
            "Belanda",
            "Brasil",
            2)

        val soal6 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.southafrica,
            "Zimbabwe",
            "Afrika Selatan",
            "Sudan",
            "Nepal",
            2)

        val soal7 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.egypt,
            "Turki",
            "Mesir",
            "Irak",
            "Iran",
            2)

        val soal8 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.northkorea,
            "Bulgaria",
            "Taiwan",
            "Korea Selatan",
            "Korea Utara",
            4)

        val soal9 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.turki,
            "Turki",
            "Vietnam",
            "Afganistan",
            "Chili",
            1)

        val soal10 = Question(1,
            "Bendera negara apa ini?",
            R.drawable.philippines,
            "Filipina",
            "Myanmar",
            "Ceko",
            "Kuba",
            1)

        questionsList.add(soal1)
        questionsList.add(soal2)
        questionsList.add(soal3)
        questionsList.add(soal4)
        questionsList.add(soal5)
        questionsList.add(soal6)
        questionsList.add(soal7)
        questionsList.add(soal8)
        questionsList.add(soal9)
        questionsList.add(soal10)

        return questionsList
    }
}