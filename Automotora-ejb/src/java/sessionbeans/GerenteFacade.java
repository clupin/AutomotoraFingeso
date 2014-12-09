package sessionbeans;

import entityclass.Gerente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GerenteFacade extends AbstractFacade<Gerente> implements GerenteFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GerenteFacade() {
        super(Gerente.class);
    }
    
}
