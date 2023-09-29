const val SIZE = 3

var board = Array(SIZE) { CharArray(SIZE) { ' ' } }

fun printBoard() {
    for (row in board) {
        for (cell in row) {
            print("|$cell ")
        }
        println()
    }
    println("---------------")
}

fun makeMove(player: Char) {
    val input = readLine()!!.split(' ')
    var row = input[0].toInt()
    var column = input[1].toInt()

    if (board[row][column] == ' ') {
        board[row][column] = player
    } else {
        println("Invalid input!")
    }
    println("Input was: $input by $player")
}

fun checkWin(player: Char): Boolean {
    for (i in 0 until SIZE) {
        if ((0 until SIZE).all { board[i][it] == player } ||
                        (0 until SIZE).all { board[it][i] == player }
        ) {
            return true
        }
    }

    return (0 until SIZE).all { board[it][it] == player } ||
            (0 until SIZE).all { board[it][SIZE - it - 1] == player }
}

fun main() {
    var moves = 0
    var currentPlayer = 'X'
    while (true) {
        printBoard()
        checkWin(currentPlayer)
        makeMove(currentPlayer)
        moves++
        if(checkWin(currentPlayer)) {
            printBoard()
            println("Player $currentPlayer has won!")
            break
        }
        else if (moves == SIZE * SIZE) {
            println("It is a draw!")
            break
        }
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}
