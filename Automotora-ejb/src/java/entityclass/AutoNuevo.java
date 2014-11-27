package entityclass;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AutoNuevo extends Automovil implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @NotNull
    private Date fecha;
    
    @NotNull
    private int cantidad;
    
    @NotNull
    private Proveedor distribuidor;

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
    
}
