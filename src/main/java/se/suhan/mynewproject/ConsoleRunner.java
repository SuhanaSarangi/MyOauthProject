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
        // Kolla om count(*) = 0
        if(bookRepository.count() == 0) {
            System.out.println("No books found in the database.");
            // You can add code here to initialize the database with some sample data if needed.
            // For example, you might want to create a few book objects and save them to the repository.
            Book book1 = new Book();
            book1.setTitle("The Great Gatsby");
            book1.setAuthor("F. Scott Fitzgerald");
            book1.setPubyear(1925);
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setTitle("To Kill a Mockingbird");
            book2.setAuthor("Harper Lee");
            book2.setPubyear(1960);
            bookRepository.save(book2);
        } else {
            System.out.println("Books found in the database.");
        }



    }

}
