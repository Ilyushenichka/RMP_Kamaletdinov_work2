fun measureExecutionTime(task: () -> Unit): Long {
    val startTime = System.nanoTime() // Засекаем стартовое время
    task() // Выполняем переданный метод
    val endTime = System.nanoTime() // Засекаем конечное время
    return endTime - startTime // Возвращаем разницу в наносекундах
}

fun exampleTask() {
    var sum = 0
    for (i in 1..1_000_000) {
        sum += i
    }
}

fun main() {
    val executionTime = measureExecutionTime { exampleTask() }
    println("Время выполнения метода: ${executionTime / 1_000_000} миллисекунд")
}
