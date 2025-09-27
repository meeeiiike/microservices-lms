package com.example.books_service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    /* TODO
    - Add all CRUD Features (Update: PUT/POST, Delete: DELETE)
    - Add basic Validation for all Features
    - ADD basic tests (Junit/ErrorHandling)
    */

    // Create In-Memory Storage for List of Books
    List<Books> books = new ArrayList<>();

    // GET method to return list of All Books
    @GetMapping("/listBooks")
    public List<Books> getBooks(){
        return books;
    }

    // POST Request to add One Book
    @PostMapping("/addBook")
    public Books addBook(@Valid @RequestBody Books book){
        books.add(book);
        return book;
    }

    // POST Request to add multiple Books
    @PostMapping("/addBooks")
    public List<Books> addBooks(@Valid @RequestBody List<Books> book){
        books.addAll(book);
        return books;
    }

    // Simple GET method to return count of Books
    @GetMapping("/countBooks")
    public int getCount(){
        return books.size();
    }

    @PutMapping("/updateBooks")
    public Books updateUser(@Valid @RequestBody Books book){
        //if(users.contains(user.getId())){} something like this??
        // maybe to update, we take id of book, search list for same id, then update with new values (RequestParams needed?)
        // if id alreadyExists
        return null;
    }

    @DeleteMapping("/deleteBook")
    public void deleteBook(@Valid @RequestBody Books book){

        // possibly same as idea as update, take in ID and search for same ID, then DELETE that book
        books.remove(book);
    }
}
