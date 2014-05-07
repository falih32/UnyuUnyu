/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.unyuschedule.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "Jam_Kuliah_hari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JamKuliahhari.findAll", query = "SELECT j FROM JamKuliahhari j"),
    @NamedQuery(name = "JamKuliahhari.findByIdJam", query = "SELECT j FROM JamKuliahhari j WHERE j.idJam = :idJam"),
    @NamedQuery(name = "JamKuliahhari.findByTotalJam", query = "SELECT j FROM JamKuliahhari j WHERE j.totalJam = :totalJam")})
public class JamKuliahhari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jam")
    private Long idJam;
    @Column(name = "total_jam")
    private BigInteger totalJam;
    @OneToMany(mappedBy = "idJam")
    private List<SlotWaktu> slotWaktuList;
    @OneToMany(mappedBy = "idJam")
    private List<Ketersediaandosen> ketersediaandosenList;

    public JamKuliahhari() {
    }

    public JamKuliahhari(Long idJam) {
        this.idJam = idJam;
    }

    public Long getIdJam() {
        return idJam;
    }

    public void setIdJam(Long idJam) {
        this.idJam = idJam;
    }

    public BigInteger getTotalJam() {
        return totalJam;
    }

    public void setTotalJam(BigInteger totalJam) {
        this.totalJam = totalJam;
    }

    @XmlTransient
    public List<SlotWaktu> getSlotWaktuList() {
        return slotWaktuList;
    }

    public void setSlotWaktuList(List<SlotWaktu> slotWaktuList) {
        this.slotWaktuList = slotWaktuList;
    }

    @XmlTransient
    public List<Ketersediaandosen> getKetersediaandosenList() {
        return ketersediaandosenList;
    }

    public void setKetersediaandosenList(List<Ketersediaandosen> ketersediaandosenList) {
        this.ketersediaandosenList = ketersediaandosenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJam != null ? idJam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JamKuliahhari)) {
            return false;
        }
        JamKuliahhari other = (JamKuliahhari) object;
        if ((this.idJam == null && other.idJam != null) || (this.idJam != null && !this.idJam.equals(other.idJam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.JamKuliahhari[ idJam=" + idJam + " ]";
    }
    
}
