package ru.masterdate.dao.interfaces;


import ru.masterdate.entities.BookEntity;

import java.util.List;


public interface BookDAO {

    List<BookEntity> getBooks();
    List<BookEntity> getBooksAuthor(String author);
    List<BookEntity> getBooks(String bookName);


}
