package sessionbeans;

import entityclass.AutoNuevo;
import entityclass.Proveedor;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

@Stateless
public class AutoNuevoFacade extends AbstractFacade<AutoNuevo> implements AutoNuevoFacadeLocal {
    @PersistenceContext(unitName = "Automotora-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoNuevoFacade() {
        super(AutoNuevo.class);
    }

    public boolean crearAutoNuevo(Long id, String marca, String modelo, String año, String color, int precio, Proveedor DistribuidorLote, Date fecha, int cantidad) {
        AutoNuevo autoNuevo = new AutoNuevo();
        autoNuevo.setId(id);
        autoNuevo.setMarca(marca);
        autoNuevo.setModelo(modelo);
        autoNuevo.setAño(año);
        autoNuevo.setColor(color);
        autoNuevo.setPrecio(precio);
        autoNuevo.setDistribuidor(DistribuidorLote);
        autoNuevo.setFecha(fecha);
        autoNuevo.setCantidad(cantidad);
        try{
            getEntityManager().persist(autoNuevo);
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
