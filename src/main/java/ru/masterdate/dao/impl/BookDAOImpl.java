package ru.masterdate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.masterdate.dao.interfaces.BookDAO;
import ru.masterdate.entities.BookEntity;


import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<BookEntity> books;

    private ProjectionList bookProjection;

    public BookDAOImpl() {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("authorId"), "authorId");

    }

    @Transactional
    @Override
    public List<BookEntity> getBooks() {

        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(BookEntity.class, "b");
        createAliases(bookListCriteria);

        List<BookEntity> books = createBookList(bookListCriteria);



        return books;
    }

    @Transactional
    @Override
    public List<BookEntity> getBooksAuthor(String author) {
        return null;
    }


    @Override
    public List<BookEntity> getBooks(String bookName) {
        return null;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("b.authorId", "authorId");

    }


    private List<BookEntity> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(BookEntity.class));
        return criteria.list();
    }


}
