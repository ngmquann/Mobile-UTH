class Library {
    private var books = mutableListOf<Book>();
    private var users = mutableListOf<User>();
    private var borrows = mutableMapOf<Int, Int>();

    fun addBook(book: Book) {
        books.add(book);
    }

    fun addUser(user: User) {
        users.add(user);
    }

    fun borrowBook(userId: Int, bookId: Int): Boolean {
        var user = users.find { it.id == userId }
        var book = books.find { it.id == bookId }
        var result: Boolean

        if(user != null && book != null && book.isAvailable) {
            book.isAvailable = false
            borrows[userId] = bookId
            result = true
        } else {
            result = false
        }

        return result
    }

    fun returnBook(bookId: Int): Boolean {
        var userId = borrows[bookId]
        var result: Boolean

        if(userId != null) {
            var book = books.find { it.id == userId }
            if (book != null) {
                book.isAvailable = true
                borrows.remove(bookId)
                result = true
            } else {
                result = false
            }
        } else {
            result = false
        }

        return result
    }

    fun displayAvailableBooks() {
        books.filter { it.isAvailable }.forEach { println("Available Book: ${it.title}") }
    }
}