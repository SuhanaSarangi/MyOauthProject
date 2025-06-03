package se.suhan.mynewproject.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.models.BookRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    @Test
    void testIsPublicationYearValid_AllValidYears() {
        // Arrange
        List<Book> books = Arrays.asList(
                new Book("Valid Book 1", "Author 1", 1500, "Category"),
                new Book("Valid Book 2", "Author 2", 2000, "Category"),
                new Book("Valid Book 3", "Author 3", 2999, "Category")
        );
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        boolean result = bookService.isPublicationYearValid();

        // Assert
        assertTrue(result, "Expected publication years to be valid.");
    }

    @Test
    void testIsPublicationYearValid_InvalidYearTooLow() {
        // Arrange
        List<Book> books = Arrays.asList(
                new Book("Invalid Book", "Author", 999, "Category")
        );
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        boolean result = bookService.isPublicationYearValid();

        // Assert
        assertFalse(result, "Expected publication year 999 to be invalid.");
    }

    @Test
    void testIsPublicationYearValid_InvalidYearTooHigh() {
        // Arrange
        List<Book> books = Arrays.asList(
                new Book("Invalid Book", "Author", 3500, "Category")
        );
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        boolean result = bookService.isPublicationYearValid();

        // Assert
        assertFalse(result, "Expected publication year 3500 to be invalid.");
    }

    @Test
    void testIsPublicationYearValid_EmptyList() {
        // Arrange
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        boolean result = bookService.isPublicationYearValid();

        // Assert
        assertTrue(result, "Expected empty book list to be valid.");
    }
}
