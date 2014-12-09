package sessionbeans;

import entityclass.Parte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParteFacade extends AbstractFacade<Parte> implements ParteFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParteFacade() {
        super(Parte.class);
    }
    
}
