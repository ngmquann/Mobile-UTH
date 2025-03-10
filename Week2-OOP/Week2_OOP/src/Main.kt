fun main() {
    val library = Library()

    library.addBook(Book(1, "Kotlin Programming"))
    library.addBook(Book(2, "Java Basics"))

    library.addUser(User(1, "Nguyen Van A"))
    library.addUser(User(2, "Tran Thi B"))

    println("Initial available books:")
    library.displayAvailableBooks()

    if (library.borrowBook(1, 1)) {
        println("User 1 successfully borrowed 'Kotlin Programming'")
    } else {
        println("Borrowing failed")
    }

    println("Available books after borrowing:")
    library.displayAvailableBooks()

    if (library.returnBook(1)) {
        println("Book 'Kotlin Programming' returned successfully")
    }

    println("Available books after returning:")
    library.displayAvailableBooks()
}