package sessionbeans;

import entityclass.Parte;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ParteFacadeLocal {

    void create(Parte parte);

    void edit(Parte parte);

    void remove(Parte parte);

    Parte find(Object id);

    List<Parte> findAll();

    List<Parte> findRange(int[] range);

    int count();
    
}
