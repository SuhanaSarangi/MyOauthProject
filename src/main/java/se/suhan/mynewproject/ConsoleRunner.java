package se.suhan.mynewproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.services.BookService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, World!");

        if (bookService.countBooks() == 0) {
            System.out.println("No books found. Initializing...");

            bookService.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction"));
            bookService.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction"));
            bookService.addBook(new Book("Effective Java", "Joshua Bloch", 2008, "Programming"));
            bookService.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, "Science"));
            bookService.addBook(new Book("The Joy of Cooking", "Irma S. Rombauer", 1931, "Cooking"));
            bookService.addBook(new Book("The History of the Decline and Fall of the Roman Empire", "Edward Gibbon", 1776, "History"));
            bookService.addBook(new Book("1984", "George Orwell", 1949, "Dystopian"));
            bookService.addBook(new Book("Brave New World", "Aldous Huxley", 1932, "Dystopian"));
            bookService.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance"));
            bookService.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"));
            bookService.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "Fiction"));
            bookService.addBook(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, "History"));
            bookService.addBook(new Book("The Lean Startup", "Eric Ries", 2011, "Business"));
            bookService.addBook(new Book("Thinking, Fast and Slow", "Daniel Kahneman", 2011, "Psychology"));
            bookService.addBook(new Book("The Diary of a Young Girl", "Anne Frank", 1947, "Biography"));
        } else {
            System.out.println("Books found in the database.");
        }
    }
}
