package sessionbeans;

import entityclass.Automovil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutomovilFacade extends AbstractFacade<Automovil> implements AutomovilFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutomovilFacade() {
        super(Automovil.class);
    }
    
}
