package se.suhan.mynewproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.suhan.mynewproject.logs.S3Logger;
import se.suhan.mynewproject.models.Book;
import se.suhan.mynewproject.models.BookRepository;
import se.suhan.mynewproject.services.BookService;

import java.util.List;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("Home page accessed");

        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("user", "Suhana");

        boolean publicationYearsValid = bookService.isPublicationYearValid();
        model.addAttribute("publicationYearsValid", publicationYearsValid);

        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        System.out.println("Profile page accessed");

        String email = getLoggedInEmail();
        String sub = getLoggedInSub();

        model.addAttribute("user", email);

        try {
            if (email != null && sub != null) {
                S3Logger logger = new S3Logger();
                logger.logLogin(sub, email);
            }
        } catch (Exception e) {
            System.err.println("Failed to log login event to S3: " + e.getMessage());
        }

        model.addAttribute("message", "Welcome, " + email);
        return "profile";  // Assuming profile.html exists
    }
}
