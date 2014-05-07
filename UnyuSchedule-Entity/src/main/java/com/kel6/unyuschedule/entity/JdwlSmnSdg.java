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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "jdwl_smn_sdg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JdwlSmnSdg.findAll", query = "SELECT j FROM JdwlSmnSdg j"),
    @NamedQuery(name = "JdwlSmnSdg.findByIdJdwSs", query = "SELECT j FROM JdwlSmnSdg j WHERE j.idJdwSs = :idJdwSs"),
    @NamedQuery(name = "JdwlSmnSdg.findBySlotWaktuId", query = "SELECT j FROM JdwlSmnSdg j WHERE j.slotWaktuId = :slotWaktuId")})
public class JdwlSmnSdg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jdw_ss")
    private Long idJdwSs;
    @Column(name = "slot_waktu_id")
    private BigInteger slotWaktuId;
    @OneToMany(mappedBy = "idJdwlSs")
    private List<SlotWaktu> slotWaktuList;
    @OneToMany(mappedBy = "idJdwSs")
    private List<SeminarSidang> seminarSidangList;
    @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")
    @ManyToOne
    private SeminarSidang idSmnsdg;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne
    private Periode idPeriode;

    public JdwlSmnSdg() {
    }

    public JdwlSmnSdg(Long idJdwSs) {
        this.idJdwSs = idJdwSs;
    }

    public Long getIdJdwSs() {
        return idJdwSs;
    }

    public void setIdJdwSs(Long idJdwSs) {
        this.idJdwSs = idJdwSs;
    }

    public BigInteger getSlotWaktuId() {
        return slotWaktuId;
    }

    public void setSlotWaktuId(BigInteger slotWaktuId) {
        this.slotWaktuId = slotWaktuId;
    }

    @XmlTransient
    public List<SlotWaktu> getSlotWaktuList() {
        return slotWaktuList;
    }

    public void setSlotWaktuList(List<SlotWaktu> slotWaktuList) {
        this.slotWaktuList = slotWaktuList;
    }

    @XmlTransient
    public List<SeminarSidang> getSeminarSidangList() {
        return seminarSidangList;
    }

    public void setSeminarSidangList(List<SeminarSidang> seminarSidangList) {
        this.seminarSidangList = seminarSidangList;
    }

    public SeminarSidang getIdSmnsdg() {
        return idSmnsdg;
    }

    public void setIdSmnsdg(SeminarSidang idSmnsdg) {
        this.idSmnsdg = idSmnsdg;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJdwSs != null ? idJdwSs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JdwlSmnSdg)) {
            return false;
        }
        JdwlSmnSdg other = (JdwlSmnSdg) object;
        if ((this.idJdwSs == null && other.idJdwSs != null) || (this.idJdwSs != null && !this.idJdwSs.equals(other.idJdwSs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.JdwlSmnSdg[ idJdwSs=" + idJdwSs + " ]";
    }
    
}
