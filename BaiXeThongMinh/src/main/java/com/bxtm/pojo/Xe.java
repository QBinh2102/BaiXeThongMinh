/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "xe")
@NamedQueries({
    @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x"),
    @NamedQuery(name = "Xe.findById", query = "SELECT x FROM Xe x WHERE x.id = :id"),
    @NamedQuery(name = "Xe.findByBienSo", query = "SELECT x FROM Xe x WHERE x.bienSo = :bienSo"),
    @NamedQuery(name = "Xe.findByHieuXe", query = "SELECT x FROM Xe x WHERE x.hieuXe = :hieuXe"),
    @NamedQuery(name = "Xe.findByMauXe", query = "SELECT x FROM Xe x WHERE x.mauXe = :mauXe"),
    @NamedQuery(name = "Xe.findBySoGhe", query = "SELECT x FROM Xe x WHERE x.soGhe = :soGhe")})
public class Xe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bienSo")
    private String bienSo;
    @Column(name = "hieuXe")
    private String hieuXe;
    @Column(name = "mauXe")
    private String mauXe;
    @Column(name = "soGhe")
    private Integer soGhe;
    @OneToMany(mappedBy = "xeid")
    private Set<Booking> bookingSet;
    @JoinColumn(name = "loaiXe", referencedColumnName = "id")
    @ManyToOne
    private Loaixe loaiXe;
    @JoinColumn(name = "id_NguoiDung", referencedColumnName = "id")
    @ManyToOne
    private Nguoidung idNguoiDung;

    public Xe() {
    }

    public Xe(Integer id) {
        this.id = id;
    }

    public Xe(Integer id, String bienSo) {
        this.id = id;
        this.bienSo = bienSo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getHieuXe() {
        return hieuXe;
    }

    public void setHieuXe(String hieuXe) {
        this.hieuXe = hieuXe;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    public Loaixe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(Loaixe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public Nguoidung getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Nguoidung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
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
        if (!(object instanceof Xe)) {
            return false;
        }
        Xe other = (Xe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Xe[ id=" + id + " ]";
    }
    
}
