package Tasks3

import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.concurrent.Future

fun main() {
    val filePath = "input.txt" // Замените путь на ваш
    val path: Path = Paths.get(filePath)

    // Открываем файл для чтения
    AsynchronousFileChannel.open(path, StandardOpenOption.READ).use { asyncFileChannel ->
        val buffer = ByteBuffer.allocate(1024) // Размер буфера 1 КБ

        println("Начинаем асинхронное чтение файла: $filePath")

        // Используем CompletionHandler для обработки результата
        asyncFileChannel.read(buffer, 0, buffer, object : java.nio.channels.CompletionHandler<Int, ByteBuffer> {
            override fun completed(bytesRead: Int?, attachment: ByteBuffer) {
                if (bytesRead != null && bytesRead > 0) {
                    attachment.flip()
                    println("Прочитано: ${String(attachment.array(), 0, bytesRead)}")
                    attachment.clear()

                    // Продолжение чтения
                    asyncFileChannel.read(attachment, bytesRead.toLong(), attachment, this)
                } else {
                    println("Чтение завершено.")
                }
            }

            override fun failed(exc: Throwable, attachment: ByteBuffer) {
                println("Ошибка чтения файла: ${exc.message}")
            }
        })

        // Ожидание завершения (иначе main завершится раньше времени)
        Thread.sleep(5000) // Это временно, пока не будет обработан весь файл
    }
}
