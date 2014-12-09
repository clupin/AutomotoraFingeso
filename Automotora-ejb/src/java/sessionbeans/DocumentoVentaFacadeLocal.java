package sessionbeans;

import entityclass.DocumentoVenta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DocumentoVentaFacadeLocal {

    void create(DocumentoVenta documentoVenta);

    void edit(DocumentoVenta documentoVenta);

    void remove(DocumentoVenta documentoVenta);

    DocumentoVenta find(Object id);

    List<DocumentoVenta> findAll();

    List<DocumentoVenta> findRange(int[] range);

    int count();
    
}
