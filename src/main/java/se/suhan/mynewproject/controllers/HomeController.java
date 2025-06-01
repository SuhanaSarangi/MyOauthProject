package se.suhan.mynewproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.models.BookRepository;


@Controller
public class HomeController extends BaseController {
    @Autowired
    private BookRepository bookRepository; // Autowire the BookRepository to access database operations
    // This is a placeholder for the HomeController class.
    // You can add methods and logic here to handle requests and responses.
    // For example, you might want to add a method to return the home page view.
    // You can also add methods to handle specific routes or endpoints.

    @GetMapping("/")
    public String home(Model model) {

        System.out.println("Home page accessed");

        model.addAttribute("books", bookRepository.findAll()); // Lägger till en lista med böcker i modellen
        model.addAttribute("user", "Suhana"); // Lägger till en användare i modellen

        Book book = bookRepository.findByTitle("1984");
        if (book != null) {
            System.out.println("Book found");
            model.addAttribute("book", book);
        } else {
            System.out.println("No book found");
        }

        return "home"; // Returnerar namnet på HTML-sidan som ska visas
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Logik för att hantera profil-sidan
        // Du kan returnera en vy eller JSON-data här
        System.out.println("Profile page accessed");
        String user = getLoggedInEmail(); // Hämtar den inloggade användarens e-postadress
        model.addAttribute("user", user); // Lägger till användaren i modellen

        return "profile"; // Returnerar namnet på HTML-sidan som ska visas
    }

}
