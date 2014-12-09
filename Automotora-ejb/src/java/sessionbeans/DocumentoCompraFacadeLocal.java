package sessionbeans;

import entityclass.DocumentoCompra;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DocumentoCompraFacadeLocal {

    void create(DocumentoCompra documentoCompra);

    void edit(DocumentoCompra documentoCompra);

    void remove(DocumentoCompra documentoCompra);

    DocumentoCompra find(Object id);

    List<DocumentoCompra> findAll();

    List<DocumentoCompra> findRange(int[] range);

    int count();
    
}
