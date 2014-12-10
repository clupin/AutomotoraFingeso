package sessionbeans;

import entityclass.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> implements ProveedorFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }

    public boolean crearProveedor(Long id, String rut, String nombre, List<Integer> telefono, List<String> email, List<String> direccion) {
        Proveedor nuevo = new Proveedor();
        nuevo.setId(id);
        nuevo.setRut(rut);
        nuevo.setNombre(nombre);
        nuevo.setTelefono(telefono);
        nuevo.setEmail(email);
        nuevo.setDirecciones(direccion);
        try{
            getEntityManager().persist(nuevo);
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
    
}
