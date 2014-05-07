/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.unyuschedule.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosen.findAll", query = "SELECT d FROM Dosen d"),
    @NamedQuery(name = "Dosen.findByNikDosen", query = "SELECT d FROM Dosen d WHERE d.nikDosen = :nikDosen"),
    @NamedQuery(name = "Dosen.findByNmDosen", query = "SELECT d FROM Dosen d WHERE d.nmDosen = :nmDosen"),
    @NamedQuery(name = "Dosen.findByAlamatDsn", query = "SELECT d FROM Dosen d WHERE d.alamatDsn = :alamatDsn"),
    @NamedQuery(name = "Dosen.findByJnsKlmnDsn", query = "SELECT d FROM Dosen d WHERE d.jnsKlmnDsn = :jnsKlmnDsn"),
    @NamedQuery(name = "Dosen.findByUsername", query = "SELECT d FROM Dosen d WHERE d.username = :username"),
    @NamedQuery(name = "Dosen.findByPassword", query = "SELECT d FROM Dosen d WHERE d.password = :password")})
public class Dosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nik_dosen")
    private String nikDosen;
    @Column(name = "nm_dosen")
    private String nmDosen;
    @Column(name = "alamat_dsn")
    private String alamatDsn;
    @Column(name = "jns_klmn_dsn")
    private Integer jnsKlmnDsn;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "dosenList")
    private List<BidangKeahlian> bidangKeahlianList;
    @JoinTable(name = "penguji", joinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")}, inverseJoinColumns = {
        @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")})
    @ManyToMany
    private List<SeminarSidang> seminarSidangList;
    @ManyToMany(mappedBy = "dosenList")
    private List<KaryaAkhir> karyaAkhirList;
    @OneToMany(mappedBy = "nikDosen")
    private List<Koordinator> koordinatorList;
    @OneToMany(mappedBy = "nikDosen")
    private List<Ketersediaandosen> ketersediaandosenList;

    public Dosen() {
    }

    public Dosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNmDosen() {
        return nmDosen;
    }

    public void setNmDosen(String nmDosen) {
        this.nmDosen = nmDosen;
    }

    public String getAlamatDsn() {
        return alamatDsn;
    }

    public void setAlamatDsn(String alamatDsn) {
        this.alamatDsn = alamatDsn;
    }

    public Integer getJnsKlmnDsn() {
        return jnsKlmnDsn;
    }

    public void setJnsKlmnDsn(Integer jnsKlmnDsn) {
        this.jnsKlmnDsn = jnsKlmnDsn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<BidangKeahlian> getBidangKeahlianList() {
        return bidangKeahlianList;
    }

    public void setBidangKeahlianList(List<BidangKeahlian> bidangKeahlianList) {
        this.bidangKeahlianList = bidangKeahlianList;
    }

    @XmlTransient
    public List<SeminarSidang> getSeminarSidangList() {
        return seminarSidangList;
    }

    public void setSeminarSidangList(List<SeminarSidang> seminarSidangList) {
        this.seminarSidangList = seminarSidangList;
    }

    @XmlTransient
    public List<KaryaAkhir> getKaryaAkhirList() {
        return karyaAkhirList;
    }

    public void setKaryaAkhirList(List<KaryaAkhir> karyaAkhirList) {
        this.karyaAkhirList = karyaAkhirList;
    }

    @XmlTransient
    public List<Koordinator> getKoordinatorList() {
        return koordinatorList;
    }

    public void setKoordinatorList(List<Koordinator> koordinatorList) {
        this.koordinatorList = koordinatorList;
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
        hash += (nikDosen != null ? nikDosen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosen)) {
            return false;
        }
        Dosen other = (Dosen) object;
        if ((this.nikDosen == null && other.nikDosen != null) || (this.nikDosen != null && !this.nikDosen.equals(other.nikDosen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.Dosen[ nikDosen=" + nikDosen + " ]";
    }
    
}
