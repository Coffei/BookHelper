package cz.coffei.bookhelper.dao;

import cz.coffei.bookhelper.model.Author;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class AuthorDao {

    @Inject
    private EntityManager em;

    public void create(Author author) {
        if(author == null)
            throw new NullPointerException("author");

        em.persist(author);
    }

    public void delete(Author author) {
        if(author == null)
            throw new NullPointerException("author");

        if(!em.contains(author)) {
            author = em.merge(author);
        }
        em.remove(author);
    }

    public void update(Author author) {
        if(author == null)
            throw new NullPointerException("author");

        em.merge(author);
    }

    public Author findById(long id) {
        return em.find(Author.class, id);
    }

    public List<Author> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> query = cb.createQuery(Author.class);
        Root<Author> author = query.from(Author.class);
        query.orderBy(cb.asc(author.get("name")));

        return em.createQuery(query).getResultList();
    }

    public List<Author> findByNameFragment(String fragment) {
        if(fragment==null)
            throw new NullPointerException("fragment");

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> query = cb.createQuery(Author.class);
        Root<Author> author = query.from(Author.class);
        query.where(cb.like(cb.lower(author.get("name").as(String.class)), "%" + fragment.toLowerCase(Locale.ENGLISH) + "%"));
        query.orderBy(cb.asc(author.get("name")));

        return em.createQuery(query).getResultList();

    }
}
