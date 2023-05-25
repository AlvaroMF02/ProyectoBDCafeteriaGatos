package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Encargado")
@NamedQueries({
    @NamedQuery(name = "Encargado.findAll", query = "SELECT e FROM Encargado e"),
    @NamedQuery(name = "Encargado.findById", query = "SELECT e FROM Encargado e WHERE e.id = :id"),
    @NamedQuery(name = "Encargado.findByNombre", query = "SELECT e FROM Encargado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Encargado.findByApellidos", query = "SELECT e FROM Encargado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Encargado.findByEdad", query = "SELECT e FROM Encargado e WHERE e.edad = :edad")})
public class Encargado implements Serializable {

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
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    
    // RELACION ENCARGADO UNO A UNO CAFETERIA
    // UN ENCARGADO TRABAJARÁ EN UNA SOLA CAFETERIA
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEncargado")
    private Cafeteria cafeteria;

    public Encargado() {
    }

    public Encargado(Integer id) {
        this.id = id;
    }

    public Encargado(Integer id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
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
        if (!(object instanceof Encargado)) {
            return false;
        }
        Encargado other = (Encargado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + id + "]" + nombre;
    }

     // TO STRING PARA LA COPIA DE SEGURIDAD
    public String toStringCopiaSeguridad() {
        return id + ";" + nombre + ";" + apellidos + ";" + edad;
    }
    
}
