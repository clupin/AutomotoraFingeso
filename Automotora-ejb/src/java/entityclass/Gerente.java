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

@Entity
public class Gerente extends Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario") 
    private Usuario usuario;
    
    @OneToMany(mappedBy = "AutoNuevo")
    @JoinColumn(name = "autosComprados") 
    private List<AutoNuevo> autosComprados;
    
    public List<AutoNuevo> getAutosComprados() {
        return autosComprados;
    }

    public void setAutosComprados(List<AutoNuevo> autosComprados) {
        this.autosComprados = autosComprados;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
