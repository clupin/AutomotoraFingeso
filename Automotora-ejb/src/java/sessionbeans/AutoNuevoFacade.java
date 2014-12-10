package sessionbeans;

import entityclass.AutoNuevo;
import entityclass.Proveedor;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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

    public boolean crearAutoNuevo(String marca, String modelo, String año, String color, int precio, Proveedor DistribuidorLote, Date fecha, int cantidad) {
        AutoNuevo autoNuevo = new AutoNuevo();
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

    @Override
    public AutoNuevo buscarAutoNuevoID(Long id) {
        AutoNuevo buscado = null;
        System.out.println("Buscando el auto de ID :"+id);
        try{
            buscado = AutoNuevo.class.cast(getEntityManager().createNamedQuery("AutoNuevo.findByID")
                .setParameter("idAutoNuevo", id)
                .getSingleResult());
            System.out.println("Se encontró a :"+buscado.getMarca()+" "+buscado.getModelo());
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }catch (NoResultException nre){
            System.out.println("No se encontró nada");
            return null;
        }catch (NonUniqueResultException nure){
            System.out.println("Se encontró más de un cliente");
            return null;
        }
        return buscado;
    }
    
    @Override
    public void eliminarAutoNuevo(Long id) {
        AutoNuevo elimAutoNuevo = buscarAutoNuevoID(id);
        if (elimAutoNuevo != null){
            System.out.println("Eliminando a "+elimAutoNuevo.getMarca()+" "+elimAutoNuevo.getModelo());
            getEntityManager().remove(elimAutoNuevo);
        }
        else{
            System.out.println("No existe nadie con ese correo");
        }
    }
    
    @Override
    public AutoNuevo editarAutoUsado(Long id, String marca, String modelo, String año, String color, int precio, Proveedor DistribuidorLote, Date fecha, int cantidad) {
        AutoNuevo editAutoNuevo = buscarAutoNuevoID(id);
        if (editAutoNuevo != null){
            editAutoNuevo.setMarca(marca);
            editAutoNuevo.setModelo(modelo);
            editAutoNuevo.setAño(año);
            editAutoNuevo.setColor(color);
            editAutoNuevo.setPrecio(precio);
            editAutoNuevo.setDistribuidor(DistribuidorLote);
            editAutoNuevo.setFecha(fecha);
            editAutoNuevo.setCantidad(cantidad);
            System.out.println("Se modificó el automóvil");
            getEntityManager().merge(editAutoNuevo);
            return editAutoNuevo;
        }else{
            return null;
        }
    }
    
}
