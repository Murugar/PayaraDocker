package docker.payara;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Dependent
public class ResourceProvider {

   
    @Resource
    private ManagedExecutorService executor;

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @Dependent
    public ManagedExecutorService getExecutor() {
        return executor;
    }

    @Produces
    @Dependent
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
