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
            book1.setCategory("Fiction");
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setTitle("To Kill a Mockingbird");
            book2.setAuthor("Harper Lee");
            book2.setPubyear(1960);
            book2.setCategory("Fiction");
            bookRepository.save(book2);

            Book book3 = new Book();
            book1.setTitle("Effective Java");
            book1.setAuthor("Joshua Bloch");
            book1.setPubyear(2008);
            book1.setCategory("Programming");
            bookRepository.save(book3);

            Book book4 = new Book();
            book3.setTitle("A Brief History of Time");
            book3.setAuthor("Stephen Hawking");
            book3.setPubyear(1988);
            book3.setCategory("Science");
            bookRepository.save(book4);

            Book book5 = new Book();
            book4.setTitle("The Joy of Cooking");
            book4.setAuthor("Irma S. Rombauer");
            book4.setPubyear(1931);
            book4.setCategory("Cooking");
            bookRepository.save(book5);

            Book book6 = new Book();
            book5.setTitle("The Art of War");
            book5.setAuthor("Sun Tzu");
            book5.setPubyear(-500); // Approximate year
            book5.setCategory("History");
            bookRepository.save(book6);


        } else {
            System.out.println("Books found in the database.");
        }



    }

}
