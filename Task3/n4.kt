package Tasks3

import java.io.IOException
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun copyFileUsingNIO(sourcePath: String, targetPath: String) {
    try {
        FileChannel.open(Paths.get(sourcePath), StandardOpenOption.READ).use { sourceChannel ->
            FileChannel.open(Paths.get(targetPath), StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { targetChannel ->
                sourceChannel.transferTo(0, sourceChannel.size(), targetChannel)
                println("Файл успешно скопирован из $sourcePath в $targetPath")
            }
        }
    } catch (e: IOException) {
        println("Ошибка при копировании файла: ${e.message}")
    } catch (e: SecurityException) {
        println("Ошибка доступа к файлу: ${e.message}")
    }
}

fun main() {
    val sourceFile = "large_file.txt"   // Укажите путь к исходному файлу
    val targetFile = "copied_large_file.txt" // Укажите путь для копии файла

    println("Копирование файла с использованием NIO...")
    copyFileUsingNIO(sourceFile, targetFile)
}
