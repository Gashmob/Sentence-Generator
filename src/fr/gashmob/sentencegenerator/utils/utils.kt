package fr.gashmob.sentencegenerator.utils


fun getPath(): String {
    val path = System.getProperty("java.class.path")

    return path.split(System.getProperty("path.separator"))[0]
}

fun getDataPath() = getPath() + "/data"