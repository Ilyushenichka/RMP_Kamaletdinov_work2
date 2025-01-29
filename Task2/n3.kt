package Tasks2

enum class OrderStatus {
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}

class Order(val id: Int) {
    private var status: OrderStatus = OrderStatus.NEW

    // Метод для отображения текущего статуса
    fun getStatus(): OrderStatus {
        return status
    }

    // Метод для изменения статуса
    fun updateStatus(newStatus: OrderStatus): Boolean {
        when (status) {
            OrderStatus.NEW -> {
                if (newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                    println("Статус заказа #$id изменен на: $status")
                    return true
                }
            }
            OrderStatus.IN_PROGRESS -> {
                if (newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                    println("Статус заказа #$id изменен на: $status")
                    return true
                }
            }
            OrderStatus.DELIVERED -> {
                println("Статус заказа #$id не может быть изменен. Заказ уже доставлен.")
                return false
            }
            OrderStatus.CANCELLED -> {
                println("Статус заказа #$id не может быть изменен. Заказ отменен.")
                return false
            }
        }
        println("Недопустимый переход статуса для заказа #$id.")
        return false
    }
}

fun main() {
    val order = Order(1)

    println("Текущий статус заказа: ${order.getStatus()}")

    // Попробуем изменить статус заказа
    order.updateStatus(OrderStatus.IN_PROGRESS) // Успешно
    order.updateStatus(OrderStatus.DELIVERED) // Успешно
    order.updateStatus(OrderStatus.CANCELLED) // Невозможно, так как уже доставлен

    println("\nПопробуем создать еще один заказ:")
    val order2 = Order(2)
    order2.updateStatus(OrderStatus.CANCELLED) // Успешно
    order2.updateStatus(OrderStatus.IN_PROGRESS) // Невозможно, так как уже отменен

    println("\nФинальный статус заказа #1: ${order.getStatus()}")
    println("Финальный статус заказа #2: ${order2.getStatus()}")
}
