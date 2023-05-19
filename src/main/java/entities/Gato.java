package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Gato")
@NamedQueries({
    @NamedQuery(name = "Gato.findAll", query = "SELECT g FROM Gato g"),
    @NamedQuery(name = "Gato.findById", query = "SELECT g FROM Gato g WHERE g.id = :id"),
    @NamedQuery(name = "Gato.findByNombre", query = "SELECT g FROM Gato g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Gato.findByRaza", query = "SELECT g FROM Gato g WHERE g.raza = :raza"),
    @NamedQuery(name = "Gato.findByEdad", query = "SELECT g FROM Gato g WHERE g.edad = :edad")})
public class Gato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "raza")
    private String raza;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    
    // RELACION GATO MUCHOS A UNO CAFETERIA
    @JoinColumn(name = "idCafeteria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cafeteria idCafeteria;

    public Gato() {
    }

    public Gato(Integer id) {
        this.id = id;
    }

    public Gato(Integer id, String nombre, String raza, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cafeteria getIdCafeteria() {
        return idCafeteria;
    }

    public void setIdCafeteria(Cafeteria idCafeteria) {
        this.idCafeteria = idCafeteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gato)) {
            return false;
        }
        Gato other = (Gato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gato[" + "Id: " + id + "| Nombre: " + nombre + "| Raza: " + raza + "| Edad: " + edad + ']';
    }

    
    
}
