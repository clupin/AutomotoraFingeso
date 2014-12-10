package managedbean;

import entityclass.Proveedor;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessionbeans.AutoNuevoFacadeLocal;

@ManagedBean
@RequestScoped
public class AutoNuevoManagedBean {
    
    @EJB
    private AutoNuevoFacadeLocal autoNuevoFacade;
    
    private Long id;
    private String marca;
    private String modelo;
    private String año;
    private String color;
    private int precio=0;
    private Date fecha;
    private int cantidad=0;
    private Proveedor distribuidor;
    
    public AutoNuevoManagedBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Proveedor distribuidor) {
        this.distribuidor = distribuidor;
    }
    
    public void nuevoAutoUsado(){
        FacesMessage mensaje;
        //autoNuevoFacade.crearAutoNuevo(marca, modelo, año, color, precio, distribuidor, fecha, cantidad);
        
        if (marca.isEmpty() || modelo.isEmpty() || año.isEmpty() || color.isEmpty() || precio==0
                 || distribuidor==null || fecha==null || cantidad==0){
            FacesContext context = FacesContext.getCurrentInstance();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Automóvil Nuevo", "Falta rellenar uno o más datos");
            context.addMessage(null, mensaje);
        } 
        else{
            FacesContext context = FacesContext.getCurrentInstance();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Automóvil Nuevo", "Agregado con éxito");
            autoNuevoFacade.crearAutoNuevo(marca, modelo, año, color, precio, distribuidor, fecha, cantidad);
            context.addMessage(null, mensaje);
            marca = "";
            modelo = "";
            año = "";
            color = "";
            precio = 0;
            distribuidor = null;
            fecha = null;
            cantidad = 0;
        } 
    }
}
