package problems

fun isValidSudoku(board: Array<CharArray>): Boolean {
    var isValid = true

    // check all rows
    for (row in board) {
        val set = mutableSetOf<Char>()
        for (num in row) {
            if (num != '.') {
                if (set.contains(num)) {
                    isValid = false
                    break
                } else set.add(num)
            }
        }
        if (isValid.not()) break
    }

    // check all columns
    if (isValid.not()) return isValid
    for (j in 0..<9) {
        val set = mutableSetOf<Char>()
        for (i in 0..<9) {
            val num = board[i][j]
            if (num != '.') {
                if (set.contains(num)) {
                    isValid = false
                    break
                } else set.add(num)
            }
        }
        if (isValid.not()) break
    }

    // check all squares (3x3)
    if (isValid.not()) return isValid
    // 0, 1, 2,   3, 4, 5,   6, 7, 8
    for (i in 0..<9 step 3) {
        // i: 0, 3, 6
        for (j in 0..<9 step 3) {
            // j: 0, 3, 6
            if (subBoxIsValid(board, i, j)) continue
            else {
                isValid = false
                break
            }
        }
        if (isValid.not()) break
    }

    return true
}

fun subBoxIsValid(box: Array<CharArray>, row: Int, col: Int): Boolean {
    var isValid = true

    val seen = mutableSetOf<Char>()

    for (i in row..< row+3) {
        for (j in col..< col+3) {
            val num = box[i][j]
            if (num != '.') {
                if (seen.contains(num)) {
                    isValid = false
                    break
                } else {
                    seen.add(num)
                }
            }
        }
        if (isValid.not()) break
    }

    return isValid
}