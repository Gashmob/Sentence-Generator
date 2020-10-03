package fr.gashmob.sentencegenerator.model

import fr.gashmob.sentencegenerator.model.GenType.WORD

class Register {
    private val words: HashMap<String, ArrayList<String>> = HashMap()

    private fun add(word: String, nextWord: String) {
        if (words[word] == null) words[word] = ArrayList()
        words[word]!!.add(nextWord)
    }

    fun add(sentence: String) {
        val words = cut(sentence)

        var prec = ""
        for (word in words) {
            add(prec, word)
            prec = word
        }
    }

    fun generate(quantity: Int = 2, type: GenType = WORD): String {
        //val sentenceDelimiters = "?.!"

        var result = getRandom("")
        var prec = result
        for (i in 0 until quantity) {
            prec = getRandom(prec)
            result += " $prec"
        }

        return result
    }

    fun show() {
        for (word in words.entries) {
            println("${word.key} : ")
            for (next in word.value) {
                println("\t$next")
            }
        }
    }

    private fun getRandom(word: String) = if (words[word] != null) words[word]!![random(end = words[word]!!.size)] else ""

    private fun random(start: Int = 0, end: Int): Int = (start + (Math.random() * (end - start))).toInt()

    private fun cut(sentence: String): ArrayList<String> {
        val delimiters = ",?;.:!"

        val result = ArrayList<String>()

        var word = ""
        for (c in sentence) {
            when (c) {
                ' ' -> {
                    if (word.isNotEmpty()) result.add(word)
                    word = ""
                }
                in delimiters -> {
                    if (word.isNotEmpty()) result.add(word)
                    word = ""
                    result.add(c.toString())
                }
                else -> word += c
            }
        }
        if (word.isNotEmpty()) result.add(word)

        return result
    }
}