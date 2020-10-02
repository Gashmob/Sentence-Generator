package fr.gashmob.sentencegenerator

import java.util.*

fun main() {
    println("========================")
    println("   Sentence Generator   ")
    println("========================")

    menu()
}

fun menu() {
    println("1) Generate")
    println("2) Add a sentence")
    println("3) Databases")
    println("4) Quit")
    print("\t?")

    val sc = Scanner(System.`in`)
    var choice = sc.nextInt()
    while (choice < 1 || choice > 4) {
        println("Wrong choice !")
        print("\t?")
        choice = sc.nextInt()
    }

    when (choice) {
        1 -> generate()
        2 -> add()
        3 -> databases()
        4 -> println()
    }
}

fun generate() {
    println("Generate")
}

fun add() {
    println("Add a sentence")
}

// _.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.

fun databases() {
    println("Databases")
    println("1) Show")
    println("2) Remove")
    println("3) Create")
    println("4) Choose")
    println("5) Quit")

    val sc = Scanner(System.`in`)
    var choice = sc.nextInt()
    while (choice < 1 || choice > 5) {
        println("Wrong choice !")
        print("\t?")
        choice = sc.nextInt()
    }

    when (choice) {
        1 -> show()
        2 -> remove()
        3 -> create()
        4 -> choose()
        5 -> println()
    }
}

fun show() {
    println("Show")
}

fun remove() {
    println("Remove")
}

fun create() {
    println("Create")
}

fun choose() {
    println("Choose")
}