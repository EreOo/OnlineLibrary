package ru.masterdate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.masterdate.dao.interfaces.BookDAO;
import ru.masterdate.entities.AuthorEntity;
import ru.masterdate.entities.BookEntity;


import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<BookEntity> books;


    @Transactional
    @Override
    public List<BookEntity> getBooks() {

        books = (List<BookEntity>) sessionFactory.getCurrentSession()
                .createCriteria(BookEntity.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return books;
    }

    @Override
    public List<BookEntity> getBooks(AuthorEntity author) {
        return null;
    }

    @Override
    public List<BookEntity> getBooks(String bookName) {
        return null;
    }



}
