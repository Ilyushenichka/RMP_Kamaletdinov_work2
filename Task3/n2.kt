package Tasks3

// Основной интерфейс
interface TextProcessor {
    fun process(text: String): String
}

// Класс, который возвращает текст без изменений
class SimpleTextProcessor : TextProcessor {
    override fun process(text: String): String = text
}

// Декоратор для преобразования текста в верхний регистр
class UpperCaseDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String = processor.process(text).uppercase()
}

// Декоратор для удаления пробелов в начале и конце строки
class TrimDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String = processor.process(text).trim()
}

// Декоратор для замены всех пробелов символом подчеркивания (_)
class ReplaceDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String = processor.process(text).replace(" ", "_")
}

// Демонстрация работы декораторов
fun main() {
    val text = "   Hello, Kotlin Decorator!   "

    // Создаем базовый процессор
    val simpleProcessor = SimpleTextProcessor()

    // Оборачиваем базовый процессор в декораторы
    val decoratedProcessor = ReplaceDecorator(
        TrimDecorator(
            UpperCaseDecorator(simpleProcessor)
        )
    )

    // Вывод результата
    println("Оригинальный текст: \"$text\"")
    println("Обработанный текст: \"${decoratedProcessor.process(text)}\"")
}
