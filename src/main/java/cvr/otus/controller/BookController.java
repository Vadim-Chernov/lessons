package cvr.otus.controller;

import cvr.otus.domain.Author;
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
//        test();
    }

//    private void test() {
//        List<Book> books = bookService.findAll();
//        Book book = books.get(0);
//        System.out.println("***** notAuthors = " + bookService.notAuthors(book.getId()) +" authors = " +book.getAuthors());
//        System.out.println("***** notGenres  = " + bookService.notGenres(book.getId())  +" genres  = " +book.getGenres());
//
//    }

    @RequestMapping(value = "/")
    public String bookList(Model model) {
//        test();

        List<Book> all = bookService.findAll();
        Book book = all.get(0);
        model.addAttribute("bookList", all);

        return "bookList";
    }

    @RequestMapping(value = {"/bookEdit", "/bookEdit/{id}"}, method = RequestMethod.GET)
    public String bookEdit(Model model, @PathVariable(required = false, name = "id") String id) {
//        test();
        if (null != id) {
            Book book = bookService.get(id);
            model.addAttribute("book", book);
        } else {
            model.addAttribute("book", new Book());
        }
        return "bookEdit";
    }


    @RequestMapping(value = "/bookEdit", method = RequestMethod.POST)
    public String bookEdit(Model model, Book book) {
//        test();
        Book book1 = bookService.get(book.getId());
        if (book1 != null) {
            book1.setName(book.getName());
            book1.setComment(book.getComment());
            bookService.save(book1);
        }
        else {
            bookService.save(book);
        }
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/bookDelete/{id}", method = RequestMethod.GET)
    public String bookDeleted(Model model, @PathVariable(required = true, name = "id") String id) {
//        test();
        bookService.remove(id);
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/book/{book_id}/author/del/{author_id}", method = RequestMethod.GET)
    public String authorDelete(Model model,
                               @PathVariable(required = true, name = "book_id") String book_id,
                               @PathVariable(required = true, name = "author_id") String author_id) {
//        test();
        bookService.removeAuthor(book_id,author_id);
        Book book = bookService.get(book_id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
    @RequestMapping(value = "/book/{book_id}/author/add/{author_id}", method = RequestMethod.GET)
    public String authorAdd(Model model,
                               @PathVariable(required = true, name = "book_id") String book_id,
                               @PathVariable(required = true, name = "author_id") String author_id) {
//        test();
        bookService.addAuthor(book_id,author_id);
        Book book = bookService.get(book_id);
        model.addAttribute("book", book);
        return "bookEdit";
    }


    @RequestMapping(value = "/book/{book_id}/genre/del/{genre_id}", method = RequestMethod.GET)
    public String genreDelete(Model model,
                               @PathVariable(required = true, name = "book_id") String book_id,
                               @PathVariable(required = true, name = "genre_id") String genre_id) {
//        test();
        bookService.removeGenre(book_id,genre_id);
        Book book = bookService.get(book_id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @RequestMapping(value = "/book/{book_id}/genre/add/{genre_id}", method = RequestMethod.GET)
    public String genreAdd(Model model,
                              @PathVariable(required = true, name = "book_id") String book_id,
                              @PathVariable(required = true, name = "genre_id") String genre_id) {
//        test();
        bookService.addGenre(book_id,genre_id);
        Book book = bookService.get(book_id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
}
