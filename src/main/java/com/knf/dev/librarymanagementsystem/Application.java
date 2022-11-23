package com.knf.dev.librarymanagementsystem;

import com.knf.dev.librarymanagementsystem.entity.Book;
import com.knf.dev.librarymanagementsystem.entity.Role;
import com.knf.dev.librarymanagementsystem.entity.User;
import com.knf.dev.librarymanagementsystem.repository.UserRepository;
import com.knf.dev.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate() {
        return (args) -> {

            var book = new Book("Spring in Action 1", "Author 1", "Book description 1", "2022-12-12", 100, "Dummy categary 2");

            bookService.createBook(book);

            var book1 = new Book("Spring in Action 2", "Author 2", "Book description 2", "2022-12-12", 99, "Dummy categary 2");

            bookService.createBook(book1);

            var book2 = new Book("Spring in Action 3", "Author 3", "Book description 3", "2022-12-12", 33, "Dummy categary 2");

            bookService.createBook(book2);

            var user = new User("admin", "admin", "admin@admin.in", passwordEncoder.encode("1234"),
                    Arrays.asList(new Role("ROLE_ADMIN")));
            userRepository.save(user);

        };
    }
}
