package br.vitor.quizappudemy

import java.util.Random

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String= "total_questions"
    const val CORRECT_QUESTIONS:String= "correct_questions"

    fun getQuestions(): ArrayList<Question>{
        val arrayListQuestion= ArrayList<Question>()
        val que1= Question(
            id=1,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_argentina,
            optionOne = "China",
            optionTwo = "Equador",
            optionThree = "Argentina",
            optionFour = "Uruguai",
            correctAnswer = 3
        )
        arrayListQuestion.add(que1)
        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        arrayListQuestion.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        arrayListQuestion.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        arrayListQuestion.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        arrayListQuestion.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        arrayListQuestion.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        arrayListQuestion.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        arrayListQuestion.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        arrayListQuestion.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        arrayListQuestion.add(que10)

        val que11 = Question(
            11,
            "What language of programming in image below?",
            R.drawable.ic_java,
            "JavaScript",
            "Ruby",
            "Java",
            "php",
            3
        )

        arrayListQuestion.add(que11)

        val que12 = Question(
            12,
            "What language of programming in image below?",
            R.drawable.ic_javascript,
            "JavaScript",
            "Ruby",
            "Java",
            "php",
            1
        )

        arrayListQuestion.add(que12)

        val que13 = Question(
            13,
            "What language of programming in image below?",
            R.drawable.ic_ruby,
            "JavaScript",
            "Ruby",
            "Java",
            "php",
            2
        )

        arrayListQuestion.add(que13)

        val que14 = Question(
            14,
            "MySQL is?",
            R.drawable.ic_mysql,
            "Data Base Management System",
            "Language of programming",
            "NoSQL Database",
            "none of those",
            1
        )

        arrayListQuestion.add(que14)

        val que15 = Question(
            15,
            "Kotlin is?",
            R.drawable.ic_kotlin,
            "Data Base Management System",
            "Language of programming",
            "Markup Language",
            "none of those",
            2
        )

        arrayListQuestion.add(que15)
        val que16 = Question(
            16,
            "What is brand of the iphone?",
            R.drawable.ic_iphones,
            "Microsoft",
            "Google",
            "Amazon",
            "Apple",
            4
        )

        arrayListQuestion.add(que16)

        val que17 = Question(
            17,
            "What is brand of the android?",
            R.drawable.ic_android,
            "Microsoft",
            "Google",
            "Amazon",
            "Apple",
            2
        )


        arrayListQuestion.add(que17)

        val que18 = Question(
            18,
            "Who is this pokemon?",
            R.drawable.ic_charmander,
            "Pikachu",
            "Charmander",
            "Charlizard",
            "Snorlax",
            2
        )

        arrayListQuestion.add(que18)

        val que19 = Question(
            19,
            "Who is this pokemon?",
            R.drawable.ic_pikachu,
            "Zapzos",
            "Charmander",
            "Pikachu",
            "Snorlax",
            3
        )

        arrayListQuestion.add(que19)

        val que20 = Question(
            20,
            "Who is this personality?",
            R.drawable.ic_neymar,
            "Romarinho",
            "Pelé",
            "Lady Gaga",
            "Neymar",
            4
        )

        arrayListQuestion.add(que20)

        return arrayListQuestion
    }
}