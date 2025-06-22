import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String genre;

    public Book(int bookId, String title, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "[" + bookId + ", " + title + ", " + genre + "]";
    }
}

public class LibrarySearch {
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = targetTitle.compareToIgnoreCase(books[mid].title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(201, "The Alchemist", "Fiction"),
                new Book(202, "Data Structures", "Education"),
                new Book(203, "Atomic Habits", "Self-help"),
                new Book(204, "Clean Code", "Programming"),
                new Book(205, "Harry Potter", "Fantasy")
        };

        String searchTitle = "Atomic Habits";
        Book result1 = linearSearch(books, searchTitle);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Book not found"));

        Book result2 = binarySearch(books, searchTitle);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Book not found"));
    }
}
