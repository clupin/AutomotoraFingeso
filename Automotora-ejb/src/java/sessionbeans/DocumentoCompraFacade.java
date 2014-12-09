package sessionbeans;

import entityclass.DocumentoCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DocumentoCompraFacade extends AbstractFacade<DocumentoCompra> implements DocumentoCompraFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoCompraFacade() {
        super(DocumentoCompra.class);
    }
    
}
