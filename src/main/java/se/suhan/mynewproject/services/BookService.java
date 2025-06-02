package se.suhan.mynewproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.models.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a book to the database
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    // Count the number of books
    public long countBooks() {
        return bookRepository.count();
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Check that all publication years are within 1000–3000
    public boolean arePublicationYearsValid() {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            int pubYear = book.getPubyear();
            if (pubYear < 1000 || pubYear > 3000) {
                return false;
            }
        }
        return true;
    }
}

