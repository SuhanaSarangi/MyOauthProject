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

    // Check that all publication years are within 1000–3000
    public boolean isPublicationYearValid() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            int pubYear = book.getPubyear();
            System.out.println("Checking publication year: " + pubYear + " for book: " + book.getTitle());
            if (pubYear < 1000 || pubYear > 3000) {
                System.out.println("Invalid publication year: " + pubYear + " for book: " + book.getTitle());
                return false;
            }
        }
        return true;
    }
}

