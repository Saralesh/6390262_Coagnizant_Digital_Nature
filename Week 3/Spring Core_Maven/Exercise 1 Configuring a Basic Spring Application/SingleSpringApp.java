import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Repository class
class BookRepository {
    public void save(String bookName) {
        System.out.println("Book saved to the database: " + bookName);
    }
}

// Service class
class BookService {
    private BookRepository bookRepository;

    // Setter for Spring dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        bookRepository.save(bookName);
    }
}

// Main application
public class SingleSpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Spring in Action");
    }
}
