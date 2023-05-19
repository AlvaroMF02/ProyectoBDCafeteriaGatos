package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Cafeteria")
@NamedQueries({
    @NamedQuery(name = "Cafeteria.findAll", query = "SELECT c FROM Cafeteria c"),
    @NamedQuery(name = "Cafeteria.findById", query = "SELECT c FROM Cafeteria c WHERE c.id = :id"),
    @NamedQuery(name = "Cafeteria.findByNombre", query = "SELECT c FROM Cafeteria c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cafeteria.findByFecApert", query = "SELECT c FROM Cafeteria c WHERE c.fecApert = :fecApert"),
    @NamedQuery(name = "Cafeteria.findByCostePedidoMensu", query = "SELECT c FROM Cafeteria c WHERE c.costePedidoMensu = :costePedidoMensu")})
public class Cafeteria implements Serializable {

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
    @Column(name = "fecApert")
    @Temporal(TemporalType.DATE)
    private Date fecApert;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "costePedidoMensu")

    // RELACION CAFETERIA UNO A MUCHOS GATO
    private BigDecimal costePedidoMensu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCafeteria")
    private List<Gato> gatoList;

    // RELACION CAFETERIA UNO A UNO ENCARGADO
    @JoinColumn(name = "idEncargado", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Encargado idEncargado;

    public Cafeteria() {
    }

    public Cafeteria(Integer id) {
        this.id = id;
    }

    public Cafeteria(Integer id, String nombre, Date fecApert, BigDecimal costePedidoMensu, Encargado idEncargado,List<Gato> gatoList) {
        this.id = id;
        this.nombre = nombre;
        this.fecApert = fecApert;
        this.costePedidoMensu = costePedidoMensu;
        this.idEncargado = idEncargado;
        this.gatoList = gatoList;
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

    public Date getFecApert() {
        return fecApert;
    }

    public LocalDate getFecApertLocalDate() {
        return new Date(this.fecApert.getTime()).
                toInstant().
                atZone(ZoneId.systemDefault()).
                toLocalDate();
    }

    public void setFecApert(Date fecApert) {
        this.fecApert = fecApert;
    }

    public BigDecimal getCostePedidoMensu() {
        return costePedidoMensu;
    }

    public void setCostePedidoMensu(BigDecimal costePedidoMensu) {
        this.costePedidoMensu = costePedidoMensu;
    }

    public List<Gato> getGatoList() {
        return gatoList;
    }

    public void setGatoList(List<Gato> gatoList) {
        this.gatoList = gatoList;
    }

    public Encargado getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Encargado idEncargado) {
        this.idEncargado = idEncargado;
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
        if (!(object instanceof Cafeteria)) {
            return false;
        }
        Cafeteria other = (Cafeteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // TO STRING SIN CONCATENADAS
    @Override
    public String toString() {
        return "Cafeteria[" + "id: " + id + "| Nombre: " + nombre + "| Apertura: " + getFecApertLocalDate() + "| Pedidos Mensuales: " + costePedidoMensu + ']';
    }

}
