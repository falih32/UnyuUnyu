/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.unyuschedule.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "periode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periode.findAll", query = "SELECT p FROM Periode p"),
    @NamedQuery(name = "Periode.findByIdPeriode", query = "SELECT p FROM Periode p WHERE p.idPeriode = :idPeriode"),
    @NamedQuery(name = "Periode.findBySemPeriode", query = "SELECT p FROM Periode p WHERE p.semPeriode = :semPeriode"),
    @NamedQuery(name = "Periode.findByThnPeriode", query = "SELECT p FROM Periode p WHERE p.thnPeriode = :thnPeriode"),
    @NamedQuery(name = "Periode.findByRentangKtsAwal", query = "SELECT p FROM Periode p WHERE p.rentangKtsAwal = :rentangKtsAwal"),
    @NamedQuery(name = "Periode.findByRentangKtsAkhir", query = "SELECT p FROM Periode p WHERE p.rentangKtsAkhir = :rentangKtsAkhir"),
    @NamedQuery(name = "Periode.findByRentangSdgAwal", query = "SELECT p FROM Periode p WHERE p.rentangSdgAwal = :rentangSdgAwal"),
    @NamedQuery(name = "Periode.findByRentangSdgAkhir", query = "SELECT p FROM Periode p WHERE p.rentangSdgAkhir = :rentangSdgAkhir")})
public class Periode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_periode")
    private Long idPeriode;
    @Column(name = "sem_periode")
    private String semPeriode;
    @Column(name = "thn_periode")
    private Integer thnPeriode;
    @Column(name = "rentang_kts_awal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentangKtsAwal;
    @Column(name = "rentang_kts_akhir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentangKtsAkhir;
    @Column(name = "rentang_sdg_awal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentangSdgAwal;
    @Column(name = "rentang_sdg_akhir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentangSdgAkhir;
    @OneToMany(mappedBy = "idPeriode")
    private List<JdwlSmnSdg> jdwlSmnSdgList;

    public Periode() {
    }

    public Periode(Long idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Long getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Long idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getSemPeriode() {
        return semPeriode;
    }

    public void setSemPeriode(String semPeriode) {
        this.semPeriode = semPeriode;
    }

    public Integer getThnPeriode() {
        return thnPeriode;
    }

    public void setThnPeriode(Integer thnPeriode) {
        this.thnPeriode = thnPeriode;
    }

    public Date getRentangKtsAwal() {
        return rentangKtsAwal;
    }

    public void setRentangKtsAwal(Date rentangKtsAwal) {
        this.rentangKtsAwal = rentangKtsAwal;
    }

    public Date getRentangKtsAkhir() {
        return rentangKtsAkhir;
    }

    public void setRentangKtsAkhir(Date rentangKtsAkhir) {
        this.rentangKtsAkhir = rentangKtsAkhir;
    }

    public Date getRentangSdgAwal() {
        return rentangSdgAwal;
    }

    public void setRentangSdgAwal(Date rentangSdgAwal) {
        this.rentangSdgAwal = rentangSdgAwal;
    }

    public Date getRentangSdgAkhir() {
        return rentangSdgAkhir;
    }

    public void setRentangSdgAkhir(Date rentangSdgAkhir) {
        this.rentangSdgAkhir = rentangSdgAkhir;
    }

    @XmlTransient
    public List<JdwlSmnSdg> getJdwlSmnSdgList() {
        return jdwlSmnSdgList;
    }

    public void setJdwlSmnSdgList(List<JdwlSmnSdg> jdwlSmnSdgList) {
        this.jdwlSmnSdgList = jdwlSmnSdgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriode != null ? idPeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periode)) {
            return false;
        }
        Periode other = (Periode) object;
        if ((this.idPeriode == null && other.idPeriode != null) || (this.idPeriode != null && !this.idPeriode.equals(other.idPeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.Periode[ idPeriode=" + idPeriode + " ]";
    }
    
}
