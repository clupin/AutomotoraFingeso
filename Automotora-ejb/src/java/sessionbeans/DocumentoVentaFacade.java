package sessionbeans;

import entityclass.DocumentoVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DocumentoVentaFacade extends AbstractFacade<DocumentoVenta> implements DocumentoVentaFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoVentaFacade() {
        super(DocumentoVenta.class);
    }
    
}
