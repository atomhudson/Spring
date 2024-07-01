package com.incapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.incapp.bean.Book;
import com.incapp.repo.BookRepo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@Controller
public class MyController {

    @Autowired
    BookRepo bookrepo;

    @ModelAttribute
    public void commonValue(ModelMap m) {
        m.addAttribute("appName", "Incapp's Book App");
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("addBook")
    public String addBook(@ModelAttribute Book book, @RequestPart("image") Part image, ModelMap map) {
        String r = bookrepo.addBook(book, image);
        map.addAttribute("r", r);
        return "index";
    }

    @PostMapping("doUpdateBook")
    public String doUpdateBook(@ModelAttribute Book b, @RequestParam("oldName") String oldName, @RequestPart("image") Part image, ModelMap m) {
        String r = bookrepo.doUpdateBook(b, oldName, image);
        m.addAttribute("r", r);
        return "updatebook";
    }

    @GetMapping("updateBook")
    public String updateBook(@RequestParam("name") String name, ModelMap m) {
        Book b = bookrepo.getBook(name);
        m.addAttribute("book", b);
        return "updatebook";
    }

    @GetMapping("viewBook")
    public String viewBook(ModelMap m) {
        List<Book> books = bookrepo.getBooks();
        m.addAttribute("book", books);
        return "viewBook";
    }

    @GetMapping("getBookImage")
    public void getBookImage(@RequestParam("name") String name, HttpServletResponse response) throws IOException {
        byte[] image = bookrepo.getBookImage(name);
        if (image == null) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("book.jpg");
            if (is != null) {
                image = is.readAllBytes();
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Default image not found");
                return;
            }
        }
        response.getOutputStream().write(image);
    }

    @GetMapping("searchBook")
    public String getBooks(@RequestParam("name") String name, ModelMap map) {
        List<Book> books = bookrepo.getBooks(name);
        map.addAttribute("book", books);
        return "viewBook";
    }

    @PostMapping("deleteBook")
    public String deleteBook(@RequestParam("bookName") String bookName, ModelMap map) {
        boolean deletedornot = bookrepo.deleteBook(bookName);
        if (deletedornot) {
            map.addAttribute("msg", "Book Deleted Successfully");
        } else {
            map.addAttribute("msg", "Book Not Exist");
        }
        List<Book> books = bookrepo.getBooks();
        map.addAttribute("book", books);
        return "viewBook";
    }
}
