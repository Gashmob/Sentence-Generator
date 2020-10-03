package fr.gashmob.sentencegenerator

import fr.gashmob.sentencegenerator.model.Registers
import java.util.*
import kotlin.math.abs

fun main() {
    println("========================")
    println("   Sentence Generator   ")
    println("========================")

    val bank = Registers()
    bank.load()

    menu(bank)

    bank.save()
}

fun menu(bank: Registers) {
    var exit = false

    while (!exit) {
        println("\nMain menu (${bank.actualRegister()})")
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
            1 -> generate(bank)
            2 -> add(bank)
            3 -> databases(bank)
            4 -> exit = true
        }
    }
}

fun generate(bank: Registers) {
    println("Generate")
    println("Quantity")
    print("\t?")
    val quantity = abs((Scanner(System.`in`)).nextInt())
    println(bank.getRegister()?.generate(quantity))
}

fun add(bank: Registers) {
    println("Add a sentence")
    print("\t?")
    val sentence = (Scanner(System.`in`)).nextLine()
    bank.getRegister()?.add(sentence)
}

// _.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.

fun databases(bank: Registers) {
    var exit = false

    while (!exit) {
        println("\nDatabases (${bank.actualRegister()})")
        println("1) Show")
        println("2) Remove")
        println("3) Create")
        println("4) Choose")
        println("5) Return")
        print("\t?")

        val sc = Scanner(System.`in`)
        var choice = sc.nextInt()
        while (choice < 1 || choice > 5) {
            println("Wrong choice !")
            print("\t?")
            choice = sc.nextInt()
        }

        when (choice) {
            1 -> show(bank)
            2 -> remove(bank)
            3 -> create(bank)
            4 -> choose(bank)
            5 -> exit = true
        }
    }
}

fun show(bank: Registers) {
    println("Show")
    bank.show()
}

fun remove(bank: Registers) {
    println("Remove")
    print("\t?")
    val name = (Scanner(System.`in`)).next()
    bank.remove(name)
}

fun create(bank: Registers) {
    println("Create")
    print("\t?")
    val name = (Scanner(System.`in`)).next()
    bank.create(name)
}

fun choose(bank: Registers) {
    println("Choose")
    print("\t?")
    val name = (Scanner(System.`in`)).next()
    if (!bank.choose(name)) println("Banque de données inexistantes")
    else println("Changement effectué")
}