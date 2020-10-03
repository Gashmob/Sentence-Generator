package fr.gashmob.sentencegenerator.model

import fr.gashmob.sentencegenerator.utils.getDataPath
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception

class Registers {
    private val fileName = getDataPath() + "/data.registers"

    private var registers : HashMap<String, Register> = HashMap()
    private var actualRegister :String = ""

    fun load(): Unit {
        try {
            val inputStream = ObjectInputStream(FileInputStream(fileName))
            registers = inputStream.readObject() as HashMap<String, Register>
            actualRegister = registers.keys.first()
        } catch (e: Exception) {
        }
    }

    fun save() {
        val outputStream = ObjectOutputStream(FileOutputStream(fileName))
        outputStream.writeObject(registers)
    }

    fun create(name: String) {
        registers[name] = Register()
    }

    fun remove(name: String) {
        registers.remove(name)
    }

    fun choose(name: String): Boolean {
        if (registers.containsKey(name)) {
            actualRegister = name
            return true
        }
        return false
    }

    fun getRegister() = if (actualRegister == "") null else registers[actualRegister]

    fun show() {
        if (registers.isEmpty()) println("Aucune base de données")

        for (register in registers) println(" - ${register.key} (${register.value.size()})")
    }

    fun actualRegister() = actualRegister
}