package sessionbeans;

import entityclass.Entidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntidadFacade extends AbstractFacade<Entidad> implements EntidadFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadFacade() {
        super(Entidad.class);
    }
    
}
