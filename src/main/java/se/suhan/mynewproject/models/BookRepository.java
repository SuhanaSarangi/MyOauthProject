package se.suhan.mynewproject.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    // This is a placeholder for BookRepository class.
    // You can add methods and logic here to interact with the database.
    // For example, you might want to add methods to save, update, delete, or retrieve books.
    // The CrudRepository interface provides basic CRUD operations for the entity class.
    Book findByTitle(String title);
   List<Book> findAll();
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    List<Book> findByPubyear(int pubyear);


}
