package cz.coffei.bookhelper.dao;

import cz.coffei.bookhelper.model.Member;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class MemberDao {

    @Inject
    private EntityManager em;


    public void create(Member member) {
        if(member==null)
            throw new NullPointerException("member");

        em.persist(member);
    }

    public void remove(Member member) {
        if(member==null)
            throw new NullPointerException("member");

        if(!em.contains(member)) {
            member = em.merge(member);
        }
        em.remove(member);
    }

    public void update(Member member) {
        if(member==null)
            throw new NullPointerException("member");

        em.merge(member);
    }

    public Member findById(long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> member = query.from(Member.class);
        query.orderBy(cb.asc(member.get("username")));

        return em.createQuery(query).getResultList();
    }
}
