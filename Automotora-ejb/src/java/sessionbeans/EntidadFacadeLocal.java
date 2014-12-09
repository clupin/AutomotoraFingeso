package sessionbeans;

import entityclass.Entidad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EntidadFacadeLocal {

    void create(Entidad entidad);

    void edit(Entidad entidad);

    void remove(Entidad entidad);

    Entidad find(Object id);

    List<Entidad> findAll();

    List<Entidad> findRange(int[] range);

    int count();
    
}
