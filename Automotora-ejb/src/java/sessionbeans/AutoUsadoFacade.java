package sessionbeans;

import entityclass.AutoUsado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutoUsadoFacade extends AbstractFacade<AutoUsado> implements AutoUsadoFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoUsadoFacade() {
        super(AutoUsado.class);
    }
    
}
