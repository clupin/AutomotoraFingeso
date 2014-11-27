package entityclass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "AutoNuevo")
    @JoinColumn(name = "autosComprados") 
    public List<AutoNuevo> autosComprados;
}
