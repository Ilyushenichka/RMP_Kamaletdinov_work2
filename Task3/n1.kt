package Tasks3

import java.io.*

fun main() {
    val inputFileName = "input.txt"   // Имя исходного файла
    val outputFileName = "output.txt" // Имя файла для записи результата

    try {
        // Чтение и преобразование текста
        BufferedReader(FileReader(inputFileName)).use { reader ->
            BufferedWriter(FileWriter(outputFileName)).use { writer ->
                var line: String? = reader.readLine()
                while (line != null) {
                    writer.write(line.uppercase()) // Преобразование строки в верхний регистр
                    writer.newLine() // Переход на новую строку
                    line = reader.readLine() // Чтение следующей строки
                }
            }
        }
        println("Текст успешно преобразован и записан в файл: $outputFileName")
    } catch (e: FileNotFoundException) {
        println("Ошибка: файл $inputFileName не найден.")
    } catch (e: IOException) {
        println("Ошибка ввода-вывода: ${e.message}")
    }
}
