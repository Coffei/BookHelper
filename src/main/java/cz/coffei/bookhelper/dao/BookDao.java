package cz.coffei.bookhelper.dao;

import cz.coffei.bookhelper.model.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class BookDao {

    @Inject
    private EntityManager em;

    public void create(Book book) {
        if(book==null)
            throw new NullPointerException("book");

        em.persist(book);
    }

    public void delete(Book book) {
        if(book==null)
            throw new NullPointerException("book");

        if(!em.contains(book)) {
            book = em.merge(book);
        }

        em.remove(book);
    }

    public void update(Book book) {
        if(book==null)
            throw new NullPointerException("book");

        em.merge(book);
    }

    public Book findById(Long id) {
        if(id==null)
            throw new NullPointerException("id");

        return em.find(Book.class, id);
    }

    public List<Book> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query =  cb.createQuery(Book.class);
        Root<Book> book = query.from(Book.class);
        query.orderBy(cb.asc(book.get("name")));

        return em.createQuery(query).getResultList();
    }

}
