package cz.coffei.bookhelper.controller.security;

import cz.coffei.bookhelper.dao.MemberDao;
import cz.coffei.bookhelper.model.Member;
import org.picketlink.Identity;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class Login {

    @Inject
    private Identity identity;

    @Inject
    private MemberDao memberDao;

    @Inject
    private Logger log;

    @Produces
    @Named("signedMember")
    private Member getSignedMember() {
        if(identity.isLoggedIn()) {
            return memberDao.findByUsername(identity.getUser().getLoginName());
        }

        return null;
    }
}
