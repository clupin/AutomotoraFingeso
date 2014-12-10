package sessionbeans;

import entityclass.AutoNuevo;
import entityclass.Proveedor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AutoNuevoFacadeLocal {

    void create(AutoNuevo autoNuevo);

    void edit(AutoNuevo autoNuevo);

    void remove(AutoNuevo autoNuevo);

    AutoNuevo find(Object id);

    List<AutoNuevo> findAll();

    List<AutoNuevo> findRange(int[] range);

    int count();

    boolean crearAutoNuevo(Long id, String marca, String modelo, String año, String color, int precio, Proveedor DistribuidorLote, Date fecha, int cantidad);

    AutoNuevo buscarAutoNuevoID(Long id);
    
    public void eliminarAutoNuevo(Long id);
    
    public AutoNuevo editarAutoUsado(Long id, String marca, String modelo, String año, String color, int precio, Proveedor DistribuidorLote, Date fecha, int cantidad);
    
}
