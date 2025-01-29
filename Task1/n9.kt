import java.time.LocalDate
import java.time.Period

fun calculateAge(birthDate: LocalDate): Int {
    val currentDate = LocalDate.now() // Текущая дата
    val period = Period.between(birthDate, currentDate) // Разница между датой рождения и текущей датой
    return period.years // Возвращаем количество лет
}

fun main() {
    val birthDate = LocalDate.of(2000, 1, 1) // Пример даты рождения
    val age = calculateAge(birthDate) // Вычисляем возраст
    println("Возраст: $age лет")
}
