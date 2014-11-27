package entityclass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Proveedor extends Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<String> direcciones;

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }
    
    //agregar funcion q a la lista existente solo agrege la ultima direccion
    //push a la lista
}
