package cz.coffei.bookhelper.util;

import org.picketlink.annotations.PicketLink;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class Resources {

    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unused")
    @Produces
    @PicketLink
    @PersistenceContext
    private EntityManager emPicket;
}
