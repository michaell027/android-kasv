import java.io.File

val hangman =
        listOf(
                """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |  / \
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |  / 
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |  /|\
    |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |  /|
    |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |  /
    |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |   o
    |
    |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |   |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
                """
    -----
    |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
                """
    
    |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
                """
    
    
    
    
    
    
    
    -----------
""".trimIndent()
        )

fun main() {
    val word = File("words.txt").readLines().random()
    var status = "_ ".repeat(word.length).toCharArray()
    var life = hangman.lastIndex
    println(word)
    println(hangman[hangman.lastIndex])
    println(status)

    while (life >= 0 && status.contains('_')) {
        val letter = readLine()
        if (letter == null || letter.isEmpty() || letter.isBlank()) {
            println("Nezadal si žiadne písmeno.")
            continue
        }
        if (life == 0) {
            println("Prehral si.")
            break
        }
        if (letter.length != 1) {
            if (letter == word) {
                status = letter.toCharArray()
                println(status)
                break
            } else {
                life--
                println(hangman[life])
            }
            continue
        }
        if (word.contains(letter)) {
            for (i in word.indices) {
                if (word[i] == letter[0]) {
                    status[i * 2] = letter[0]
                }
            }
        } else {
            life--
        }
        println(status)
        println(hangman[life])
    }

    println("Hra ukončená.")
}
