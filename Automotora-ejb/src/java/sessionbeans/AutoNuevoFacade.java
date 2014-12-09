package sessionbeans;

import entityclass.AutoNuevo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutoNuevoFacade extends AbstractFacade<AutoNuevo> implements AutoNuevoFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoNuevoFacade() {
        super(AutoNuevo.class);
    }
    
}
