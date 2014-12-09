package sessionbeans;

import entityclass.Automovil;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AutomovilFacadeLocal {

    void create(Automovil automovil);

    void edit(Automovil automovil);

    void remove(Automovil automovil);

    Automovil find(Object id);

    List<Automovil> findAll();

    List<Automovil> findRange(int[] range);

    int count();
    
}
