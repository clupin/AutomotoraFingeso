package sessionbeans;

import entityclass.Proveedor;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    List<Proveedor> findRange(int[] range);

    int count();

    boolean crearProveedor(Long id, String rut, String nombre, List<Integer> telefono, List<String> email, List<String> direccion);

    boolean agregarDireccion(Proveedor proveedor, String direccion);
    
}
