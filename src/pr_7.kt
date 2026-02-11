// Задание 1
class Book(val title: String, val author: String, var year: Int, var price: Int)

// Задание 2
class Student(val name: String, val surname: String, var group: String) {
    val fullName = "$name $surname"
    init {
        println("Создан студент: $fullName, группа: $group")
    }
}

// Задание 3
class BankAccount(initialBalance: Int) {
    var balance = initialBalance
        set(value) {
            if (value < 0) println("Ошибка: баланс не может быть отрицательным!")
            else field = value
        }
    fun getBalance() = "Баланс: $balance ₽"
}

// Задание 4
enum class OrderStatus(val desc: String) {
    NEW("Новый заказ"),
    PROCESSING("Заказ в обработке"),
    SHIPPED("Заказ отправлен"),
    DELIVERED("Заказ доставлен"),
    CANCELLED("Заказ отменён");
    fun isFinished() = this == DELIVERED || this == CANCELLED
}

// Задание 5
data class Product(val id: Int, val name: String, var price: Double, var inStock: Boolean)

object ProductCatalog {
    private val _products = mutableListOf<Product>()
    val products get() = _products.toList()
    fun add(p: Product) = _products.add(p)
    fun find(id: Int) = _products.find { it.id == id }
}

// Главная функция
fun main() {
    // Задание 1
    println("Книги")
    val b1 = Book("Война и мир", "Толстой", 1869, 1200)
    val b2 = Book("Преступление и наказание", "Достоевский", 1866, 950)
    val b3 = Book("Мастер и Маргарита", "Булгаков", 1967, 1100)
    b1.price = 1300
    println("${b1.title}, ${b1.author}, ${b1.year}, ${b1.price}₽")
    println("${b2.title}, ${b2.author}, ${b2.year}, ${b2.price}₽")
    println("${b3.title}, ${b3.author}, ${b3.year}, ${b3.price}₽")

    // Задание 2
    println("\nСтуденты")
    val s1 = Student("Иван", "Петров", "ИС-21")
    val s2 = Student("Анна", "Смирнова", "БИ-32")
    println(s1.fullName)
    println(s2.fullName)

    // Задание 3
    println("\nБанк")
    val acc = BankAccount(1000)
    println(acc.getBalance())
    acc.balance = -500
    acc.balance = 2000
    println(acc.getBalance())

    // Задание 4
    println("\nСтатусы")
    OrderStatus.values().forEach { println("${it.name} - ${it.desc}") }
    val finished = OrderStatus.values().filter { it.isFinished() }.joinToString { it.name }
    println("Завершённые: $finished")

    // Задание 5
    println("\nТовары")
    val p1 = Product(1, "Ноутбук", 75000.0, true)
    val p2 = Product(1, "Ноутбук", 75000.0, true)
    println("Равны? ${p1 == p2}")
    val p1copy = p1.copy(price = 70000.0)
    println("Оригинал: $p1")
    println("Копия: $p1copy")

    println("\nКаталог")
    ProductCatalog.add(p1)
    ProductCatalog.add(Product(2, "Мышь", 1500.0, true))
    ProductCatalog.add(Product(3, "Клавиатура", 3500.0, false))
    ProductCatalog.products.forEach { println(it) }
    println("Поиск id=2: ${ProductCatalog.find(2)}")
}