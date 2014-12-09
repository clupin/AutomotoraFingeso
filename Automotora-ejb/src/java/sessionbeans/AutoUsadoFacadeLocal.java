package sessionbeans;

import entityclass.AutoUsado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AutoUsadoFacadeLocal {

    void create(AutoUsado autoUsado);

    void edit(AutoUsado autoUsado);

    void remove(AutoUsado autoUsado);

    AutoUsado find(Object id);

    List<AutoUsado> findAll();

    List<AutoUsado> findRange(int[] range);

    int count();
    
}
