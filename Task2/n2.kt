package Tasks2

class Logger private constructor() {

    private val logs = mutableListOf<String>()

    init {
        println("Logger создан")
    }

    // Метод для добавления сообщений в логи
    fun log(message: String) {
        logs.add(message)
        println("Сообщение добавлено в лог: $message")
    }

    // Метод для вывода всех логов
    fun showLogs() {
        if (logs.isEmpty()) {
            println("Логи отсутствуют")
        } else {
            println("Все логи:")
            logs.forEach { println(it) }
        }
    }

    companion object {
        @Volatile
        private var instance: Logger? = null

        // Получение единственного экземпляра класса
        fun getInstance(): Logger {
            return instance ?: synchronized(this) {
                if (instance == null) {
                    instance = Logger()
                }
                instance!!
            }
        }
    }
}

fun main() {
    // Проверка Singleton
    val logger1 = Logger.getInstance()
    logger1.log("Первое сообщение")
    logger1.log("Второе сообщение")

    val logger2 = Logger.getInstance()
    logger2.log("Третье сообщение")

    println("\nЛоги из logger1:")
    logger1.showLogs()

    println("\nЛоги из logger2:")
    logger2.showLogs()

    println("\nlogger1 и logger2 ссылаются на один объект: ${logger1 === logger2}")
}
