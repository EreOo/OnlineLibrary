package ru.masterdate.dao.interfaces;

import ru.masterdate.entities.AuthorEntity;
import ru.masterdate.entities.BookEntity;

import java.util.List;


public interface BookDAO {

    List<BookEntity> getBooks();
    List<BookEntity> getBooks(AuthorEntity author);
    List<BookEntity> getBooks(String bookName);


}
