package sessionbeans;

import entityclass.AutoNuevo;
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
    
}
