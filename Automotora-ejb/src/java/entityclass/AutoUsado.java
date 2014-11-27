package entityclass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class AutoUsado extends Automovil implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    public String patente;
    
    @NotNull
    public int kilometraje;
    
    @OneToMany(mappedBy = "Parte")
    @JoinColumn(name = "partes")
    private List<Parte> partes;

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

}
