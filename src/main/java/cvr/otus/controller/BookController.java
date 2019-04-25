package cvr.otus.controller;

import cvr.otus.domain.Book;
import cvr.otus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/")
    public String bookList(Model model) {
        List<Book> all = bookService.findAll();
        Book book = all.get(0);
        model.addAttribute("bookList", all);

        return "bookList";
    }

    @RequestMapping(value = {"/bookEdit", "/bookEdit/{id}"}, method = RequestMethod.GET)
    public String bookEdit(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            Book book = bookService.get(id);
            model.addAttribute("book",book );
        } else {
            model.addAttribute("book", new Book());
        }
        return "bookEdit";
    }

    @RequestMapping(value = {"/authorList/{id}"}, method = RequestMethod.GET)
    public String authorList(Model model, @PathVariable(required = false, name = "id") Long id) {
        Book book = bookService.get(id);
        model.addAttribute("authorList",book.getAuthors() );
        return "authorList";
    }

    @RequestMapping(value = {"/genreList/{id}"}, method = RequestMethod.GET)
    public String genreList(Model model, @PathVariable(required = false, name = "id") Long id) {
        Book book = bookService.get(id);
        model.addAttribute("genreList",book.getGenres() );
        return "genreList";
    }


    @RequestMapping(value = "/bookEdit", method = RequestMethod.POST)
    public String bookEdit(Model model, Book book) {
        bookService.save(book);
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/bookDelete/{id}", method = RequestMethod.GET)
    public String bookDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
        bookService.remove(id);
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }
    @RequestMapping(value = "/addAuthor/{id}", method = RequestMethod.GET)
    public String addAuthor(Model model, @PathVariable(required = true, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("book", bookService.get(id));
        } else {
            model.addAttribute("book", new Book());
        }
        return "addAuthor";
    }


}
