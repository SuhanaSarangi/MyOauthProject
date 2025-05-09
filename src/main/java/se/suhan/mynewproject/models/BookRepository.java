package se.suhan.mynewproject.models;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    // This is a placeholder for the BookRepository class.
    // You can add methods and logic here to interact with the database.
    // For example, you might want to add methods to save, update, delete, or retrieve books.
    // En repository är en klass som hanterar databasoperationer för en specifik entitet.
    // Den används för att utföra CRUD-operationer (Create, Read, Update, Delete) på databasen.

}
