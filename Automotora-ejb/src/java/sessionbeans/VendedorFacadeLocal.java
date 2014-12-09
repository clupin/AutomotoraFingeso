package sessionbeans;

import entityclass.Vendedor;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VendedorFacadeLocal {

    void create(Vendedor vendedor);

    void edit(Vendedor vendedor);

    void remove(Vendedor vendedor);

    Vendedor find(Object id);

    List<Vendedor> findAll();

    List<Vendedor> findRange(int[] range);

    int count();
    
}
