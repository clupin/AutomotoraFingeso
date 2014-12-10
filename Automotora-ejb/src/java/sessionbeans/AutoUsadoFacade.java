package sessionbeans;

import entityclass.AutoUsado;
import entityclass.Parte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

@Stateless
public class AutoUsadoFacade extends AbstractFacade<AutoUsado> implements AutoUsadoFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoUsadoFacade() {
        super(AutoUsado.class);
    }

    public boolean crearAutoUsado(Long id, String marca, String modelo, String año, String color, int precio, String patente, int kilometraje, List<Parte> partes) {
        AutoUsado autoUsado = new AutoUsado();
        autoUsado.setId(id);
        autoUsado.setMarca(marca);
        autoUsado.setModelo(modelo);
        autoUsado.setAño(año);
        autoUsado.setColor(color);
        autoUsado.setPrecio(precio);
        autoUsado.setPatente(patente);
        autoUsado.setKilometraje(kilometraje);
        autoUsado.setPartes(partes);
        try{
            getEntityManager().persist(autoUsado);
        } catch(EntityExistsException eee){
            System.out.println("Nuevo proveedor ya existe");
            return false;
        } catch(IllegalArgumentException iae){
            System.out.println("Error con la entidad creada");
            return false;
        } catch(TransactionRequiredException tre){
            System.out.println("Error en la transacción");
            return false;
        }
        return true;
    }

    public boolean agregarParte(AutoUsado autoUsado, Parte parte) {
        autoUsado.agregarParte(parte);
        return true;
    }
    
    
    
}
