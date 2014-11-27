package entityclass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendedor extends Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToOne
    @JoinColumn(name = "usuario") 
    private Usuario usuario;
    
    @OneToMany(mappedBy = "DocumentoVenta")
    @JoinColumn(name = "historialVenta") 
    public List<DocumentoVenta> historialVenta;
    
    @OneToMany(mappedBy = "DocumentoCompra")
    @JoinColumn(name = "historialCompra") 
    public List<DocumentoCompra> historialCompra;
    
    @OneToMany(mappedBy = "Mensaje")
    @JoinColumn(name = "mensaje") 
    public List<Mensaje> mensaje;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DocumentoVenta> getHistorialVenta() {
        return historialVenta;
    }

    public void setHistorialVenta(List<DocumentoVenta> historialVenta) {
        this.historialVenta = historialVenta;
    }

    public List<DocumentoCompra> getHistorialCompra() {
        return historialCompra;
    }

    public void setHistorialCompra(List<DocumentoCompra> historialCompra) {
        this.historialCompra = historialCompra;
    }

    public List<Mensaje> getMensaje() {
        return mensaje;
    }

    public void setMensaje(List<Mensaje> mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
