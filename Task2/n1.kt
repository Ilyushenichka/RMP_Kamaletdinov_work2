package Tasks2

class Database private constructor() {

    init {
        println("Подключение к базе данных создано")
    }

    fun connect() {
        println("Соединение с базой данных установлено")
    }

    companion object {
        @Volatile
        private var instance: Database? = null

        fun getInstance(): Database {
            // Реализация "ленивого" Singleton с безопасностью для многопоточности
            return instance ?: synchronized(this) {
                if (instance == null) {
                    instance = Database()
                }
                instance!!
            }
        }
    }
}

fun main() {
    // Проверка Singleton
    val db1 = Database.getInstance()
    db1.connect()

    val db2 = Database.getInstance()
    db2.connect()

    println("db1 и db2 ссылаются на один и тот же объект: ${db1 === db2}")
}
