package sessionbeans;

import entityclass.Gerente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GerenteFacadeLocal {

    void create(Gerente gerente);

    void edit(Gerente gerente);

    void remove(Gerente gerente);

    Gerente find(Object id);

    List<Gerente> findAll();

    List<Gerente> findRange(int[] range);

    int count();
    
}
