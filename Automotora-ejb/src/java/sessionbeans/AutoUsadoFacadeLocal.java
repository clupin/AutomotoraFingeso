package sessionbeans;

import entityclass.AutoUsado;
import entityclass.Parte;
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

    boolean crearAutoUsado(Long id, String marca, String modelo, String año, String color, int precio, String patente, int kilometraje, List<Parte> partes);

    boolean agregarParte(AutoUsado autoUsado, Parte parte);
    
}
