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

    /**
     * Returns the total count of books.
     */
    public long countBooks() {
        return bookRepository.count();
    }

    /**
     * Adds a new book to the repository.
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Returns all books.
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Finds a book by its title (simple example).
     */
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}

