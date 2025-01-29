package Tasks3

import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Paths

fun measureIOPerformance(inputFile: String, outputFile: String) {
    val startTime = System.nanoTime()

    try {
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    writer.write(line)
                    writer.newLine()
                }
            }
        }
    } catch (e: IOException) {
        println("IO Exception: ${e.message}")
    }

    val endTime = System.nanoTime()
    println("IO (BufferedReader/FileWriter) время выполнения: ${(endTime - startTime) / 1_000_000} ms")
}

fun measureNIOPerformance(inputFile: String, outputFile: String) {
    val startTime = System.nanoTime()

    try {
        FileChannel.open(Paths.get(inputFile)).use { inputChannel ->
            FileChannel.open(Paths.get(outputFile), java.nio.file.StandardOpenOption.WRITE, java.nio.file.StandardOpenOption.CREATE).use { outputChannel ->
                val buffer = ByteBuffer.allocate(8192)
                while (inputChannel.read(buffer) > 0) {
                    buffer.flip()
                    outputChannel.write(buffer)
                    buffer.clear()
                }
            }
        }
    } catch (e: IOException) {
        println("NIO Exception: ${e.message}")
    }

    val endTime = System.nanoTime()
    println("NIO (FileChannel) время выполнения: ${(endTime - startTime) / 1_000_000} ms")
}

fun main() {
    val inputFile = "input_large.txt"  // Укажите путь к большому файлу
    val outputFileIO = "output_io.txt"
    val outputFileNIO = "output_nio.txt"

    println("Сравнение IO и NIO:")

    // Тестируем IO
    measureIOPerformance(inputFile, outputFileIO)

    // Тестируем NIO
    measureNIOPerformance(inputFile, outputFileNIO)
}
