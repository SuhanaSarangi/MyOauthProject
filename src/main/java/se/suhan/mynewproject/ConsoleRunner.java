package se.suhan.mynewproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.models.BookRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository; // Autowire the BookRepository to access database operations

    @Override
    public void run(String... args) throws Exception {
        // This method will be executed when the application starts.
        // You can add your custom logic here, such as initializing data or performing startup tasks.
        System.out.println("Hello, World!");

        // Check if the database is empty
        if (bookRepository.count() == 0) {
            System.out.println("No books found in the database. Initializing sample data...");

            Book book1 = new Book();
            book1.setTitle("The Great Gatsby");
            book1.setAuthor("F. Scott Fitzgerald");
            book1.setPubyear(1925);
            book1.setCategory("Fiction");
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setTitle("To Kill a Mockingbird");
            book2.setAuthor("Harper Lee");
            book2.setPubyear(1960);
            book2.setCategory("Fiction");
            bookRepository.save(book2);

            Book book3 = new Book();
            book3.setTitle("Effective Java");
            book3.setAuthor("Joshua Bloch");
            book3.setPubyear(2008);
            book3.setCategory("Programming");
            bookRepository.save(book3);

            Book book4 = new Book();
            book4.setTitle("A Brief History of Time");
            book4.setAuthor("Stephen Hawking");
            book4.setPubyear(1988);
            book4.setCategory("Science");
            bookRepository.save(book4);

            Book book5 = new Book();
            book5.setTitle("The Joy of Cooking");
            book5.setAuthor("Irma S. Rombauer");
            book5.setPubyear(1931);
            book5.setCategory("Cooking");
            bookRepository.save(book5);

            Book book6 = new Book();
            book6.setTitle("The History of the Decline and Fall of the Roman Empire");
            book6.setAuthor("Edward Gibbon");
            book6.setPubyear(1776);
            book6.setCategory("History");
            bookRepository.save(book6);

            Book book7 = new Book();
            book7.setTitle("1984");
            book7.setAuthor("George Orwell");
            book7.setPubyear(1949);
            book7.setCategory("Dystopian");
            bookRepository.save(book7);

            Book book8 = new Book();
            book8.setTitle("Brave New World");
            book8.setAuthor("Aldous Huxley");
            book8.setPubyear(1932);
            book8.setCategory("Dystopian");
            bookRepository.save(book8);

            Book book9 = new Book();
            book9.setTitle("Pride and Prejudice");
            book9.setAuthor("Jane Austen");
            book9.setPubyear(1813);
            book9.setCategory("Romance");
            bookRepository.save(book9);

            Book book10 = new Book();
            book10.setTitle("The Hobbit");
            book10.setAuthor("J.R.R. Tolkien");
            book10.setPubyear(1937);
            book10.setCategory("Fantasy");
            bookRepository.save(book10);

            Book book11 = new Book();
            book11.setTitle("The Catcher in the Rye");
            book11.setAuthor("J.D. Salinger");
            book11.setPubyear(1951);
            book11.setCategory("Fiction");
            bookRepository.save(book11);

            Book book12 = new Book();
            book12.setTitle("Sapiens: A Brief History of Humankind");
            book12.setAuthor("Yuval Noah Harari");
            book12.setPubyear(2011);
            book12.setCategory("History");
            bookRepository.save(book12);

            Book book13 = new Book();
            book13.setTitle("The Lean Startup");
            book13.setAuthor("Eric Ries");
            book13.setPubyear(2011);
            book13.setCategory("Business");
            bookRepository.save(book13);

            Book book14 = new Book();
            book14.setTitle("Thinking, Fast and Slow");
            book14.setAuthor("Daniel Kahneman");
            book14.setPubyear(2011);
            book14.setCategory("Psychology");
            bookRepository.save(book14);

            Book book15 = new Book();
            book15.setTitle("The Diary of a Young Girl");
            book15.setAuthor("Anne Frank");
            book15.setPubyear(1947);
            book15.setCategory("Biography");
            bookRepository.save(book15);

            System.out.println("Sample data has been initialized.");
        } else {
            System.out.println("Books found in the database.");
        }
    }
}
