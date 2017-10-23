/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1199561
 */
@Entity
@Table(name = "encomienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encomienda.findAll", query = "SELECT e FROM Encomienda e")
    , @NamedQuery(name = "Encomienda.findById", query = "SELECT e FROM Encomienda e WHERE e.id = :id")
    , @NamedQuery(name = "Encomienda.findByDescripcion", query = "SELECT e FROM Encomienda e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Encomienda.findByPesoEncomienda", query = "SELECT e FROM Encomienda e WHERE e.pesoEncomienda = :pesoEncomienda")
    , @NamedQuery(name = "Encomienda.findByValorEnvioEncomienda", query = "SELECT e FROM Encomienda e WHERE e.valorEnvioEncomienda = :valorEnvioEncomienda")})
public class Encomienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "pesoEncomienda")
    private String pesoEncomienda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorEnvioEncomienda")
    private BigDecimal valorEnvioEncomienda;
    @JoinColumn(name = "idCiudadEmisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudadEmisor;
    @JoinColumn(name = "idCiudadReceptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudadReceptor;
    @JoinColumn(name = "idClienteEmisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idClienteEmisor;
    @JoinColumn(name = "idClienteReceptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idClienteReceptor;

    public Encomienda() {
    }

    public Encomienda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPesoEncomienda() {
        return pesoEncomienda;
    }

    public void setPesoEncomienda(String pesoEncomienda) {
        this.pesoEncomienda = pesoEncomienda;
    }

    public BigDecimal getValorEnvioEncomienda() {
        return valorEnvioEncomienda;
    }

    public void setValorEnvioEncomienda(BigDecimal valorEnvioEncomienda) {
        this.valorEnvioEncomienda = valorEnvioEncomienda;
    }

    public Ciudades getIdCiudadEmisor() {
        return idCiudadEmisor;
    }

    public void setIdCiudadEmisor(Ciudades idCiudadEmisor) {
        this.idCiudadEmisor = idCiudadEmisor;
    }

    public Ciudades getIdCiudadReceptor() {
        return idCiudadReceptor;
    }

    public void setIdCiudadReceptor(Ciudades idCiudadReceptor) {
        this.idCiudadReceptor = idCiudadReceptor;
    }

    public Clientes getIdClienteEmisor() {
        return idClienteEmisor;
    }

    public void setIdClienteEmisor(Clientes idClienteEmisor) {
        this.idClienteEmisor = idClienteEmisor;
    }

    public Clientes getIdClienteReceptor() {
        return idClienteReceptor;
    }

    public void setIdClienteReceptor(Clientes idClienteReceptor) {
        this.idClienteReceptor = idClienteReceptor;
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
        if (!(object instanceof Encomienda)) {
            return false;
        }
        Encomienda other = (Encomienda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encomienda.entities.Encomienda[ id=" + id + " ]";
    }
    
}
