package sessionbeans;

import entityclass.Vendedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> implements VendedorFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedorFacade() {
        super(Vendedor.class);
    }
    
}
