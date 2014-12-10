package sessionbeans;

import entityclass.AutoUsado;
import entityclass.Parte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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

    public boolean crearAutoUsado(String marca, String modelo, String año, String color, int precio, String patente, int kilometraje, List<Parte> partes) {
        AutoUsado autoUsado = new AutoUsado();
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

    @Override
    public AutoUsado buscarAutoUsadoID(Long id) {
        AutoUsado buscado = null;
        System.out.println("Buscando el auto de ID :"+id);
        try{
            buscado = AutoUsado.class.cast(getEntityManager().createNamedQuery("AutoUsado.findByID")
                .setParameter("idAutoUsado", id)
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
    public void eliminarAutoUsado(Long id) {
        AutoUsado elimAutoUsado = buscarAutoUsadoID(id);
        if (elimAutoUsado != null){
            System.out.println("Eliminando a "+elimAutoUsado.getMarca()+" "+elimAutoUsado.getModelo());
            getEntityManager().remove(elimAutoUsado);
        }
        else{
            System.out.println("No existe nadie con ese correo");
        }
    }

    @Override
    public AutoUsado editarAutoUsado(Long id, String marca, String modelo, String año, String color, int precio, String patente, int kilometraje, List<Parte> partes) {
        AutoUsado editAutoUsado = buscarAutoUsadoID(id);
        if (editAutoUsado != null){
            editAutoUsado.setMarca(marca);
            editAutoUsado.setModelo(modelo);
            editAutoUsado.setAño(año);
            editAutoUsado.setColor(color);
            editAutoUsado.setPrecio(precio);
            editAutoUsado.setPatente(patente);
            editAutoUsado.setKilometraje(kilometraje);
            editAutoUsado.setPartes(partes);
            System.out.println("Se modificó el automóvil");
            getEntityManager().merge(editAutoUsado);
            return editAutoUsado;
        }else{
            return null;
        }
    }
}
