import java.io.BufferedWriter
import java.io.FileWriter

fun createLargeFile(filePath: String, sizeInMB: Int) {
    val oneMBString = "This is a sample line to create a large file.\n".repeat(1024 * 20) // Пример текста ~1 МБ
    BufferedWriter(FileWriter(filePath)).use { writer ->
        repeat(sizeInMB) {
            writer.write(oneMBString)
        }
    }
    println("Файл размером ${sizeInMB} МБ создан по пути $filePath")
}

fun main() {
    createLargeFile("large_file.txt", 1024) // Создаёт файл ~1 ГБ
}
