package cz.coffei.bookhelper.security;

import org.picketlink.idm.model.Group;
import org.picketlink.idm.model.SimpleGroup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */
@Singleton
@Startup
public class IDMInitializer {

    @Inject
    private org.picketlink.idm.IdentityManager identityManager;

    @PostConstruct
    public void create() {
        if(identityManager.getGroup("user")==null) {
            Group users = new SimpleGroup("user");
            identityManager.add(users);
        }
        if(identityManager.getGroup("root")==null) {
            Group users = new SimpleGroup("root");
            identityManager.add(users);
        }
    }
}
