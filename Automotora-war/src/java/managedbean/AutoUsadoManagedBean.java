package managedbean;

import entityclass.Parte;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessionbeans.AutoUsadoFacadeLocal;

@ManagedBean
@RequestScoped
public class AutoUsadoManagedBean {
    @javax.ejb.EJB
    private AutoUsadoFacadeLocal autoUsadoFacade;

    private Long id;
    private String marca;
    private String modelo;
    private String año;
    private String color;
    private int precio=0;
    public String patente;
    public int kilometraje=0;
    private List<Parte> partes;
    
    public AutoUsadoManagedBean() {
        
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

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }
    
    public void nuevoAutoUsado(){
        FacesMessage mensaje;
        //autoUsadoFacade.crearAutoUsado(id, marca, modelo, año, color, precio, patente, kilometraje, partes);
        
        if (marca.isEmpty() || modelo.isEmpty() || año.isEmpty() || color.isEmpty() || precio==0
                 || patente.isEmpty() || kilometraje==0 || partes.isEmpty()){
            FacesContext context = FacesContext.getCurrentInstance();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Automóvil Usado", "Falta rellenar uno o más datos");
            context.addMessage(null, mensaje);
        } 
        else{
            FacesContext context = FacesContext.getCurrentInstance();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Automóvil Usado", "Agregado con éxito");
            autoUsadoFacade.crearAutoUsado(marca, modelo, año, color, precio, patente, kilometraje, partes);
            context.addMessage(null, mensaje);
            marca = "";
            modelo = "";
            año = "";
            color = "";
            precio = 0;
            patente = "";
            kilometraje = 0;
            partes.clear();
        } 
    }
    
    
}
