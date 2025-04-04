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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "giaca")
@NamedQueries({
    @NamedQuery(name = "Giaca.findAll", query = "SELECT g FROM Giaca g"),
    @NamedQuery(name = "Giaca.findById", query = "SELECT g FROM Giaca g WHERE g.id = :id"),
    @NamedQuery(name = "Giaca.findByKhungGioBatDau", query = "SELECT g FROM Giaca g WHERE g.khungGioBatDau = :khungGioBatDau"),
    @NamedQuery(name = "Giaca.findByKhungGioKetThuc", query = "SELECT g FROM Giaca g WHERE g.khungGioKetThuc = :khungGioKetThuc"),
    @NamedQuery(name = "Giaca.findByNgayApDung", query = "SELECT g FROM Giaca g WHERE g.ngayApDung = :ngayApDung"),
    @NamedQuery(name = "Giaca.findByGiaTien", query = "SELECT g FROM Giaca g WHERE g.giaTien = :giaTien")})
public class Giaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "khungGioBatDau")
    @Temporal(TemporalType.TIME)
    private Date khungGioBatDau;
    @Basic(optional = false)
    @Column(name = "khungGioKetThuc")
    @Temporal(TemporalType.TIME)
    private Date khungGioKetThuc;
    @Column(name = "ngayApDung")
    @Temporal(TemporalType.DATE)
    private Date ngayApDung;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "giaTien")
    private BigDecimal giaTien;
    @JoinColumn(name = "BaiDoXe_id", referencedColumnName = "id")
    @ManyToOne
    private Baidoxe baiDoXeid;
    @JoinColumn(name = "LoaiXe_id", referencedColumnName = "id")
    @ManyToOne
    private Loaixe loaiXeid;

    public Giaca() {
    }

    public Giaca(Integer id) {
        this.id = id;
    }

    public Giaca(Integer id, Date khungGioBatDau, Date khungGioKetThuc, BigDecimal giaTien) {
        this.id = id;
        this.khungGioBatDau = khungGioBatDau;
        this.khungGioKetThuc = khungGioKetThuc;
        this.giaTien = giaTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getKhungGioBatDau() {
        return khungGioBatDau;
    }

    public void setKhungGioBatDau(Date khungGioBatDau) {
        this.khungGioBatDau = khungGioBatDau;
    }

    public Date getKhungGioKetThuc() {
        return khungGioKetThuc;
    }

    public void setKhungGioKetThuc(Date khungGioKetThuc) {
        this.khungGioKetThuc = khungGioKetThuc;
    }

    public Date getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public Baidoxe getBaiDoXeid() {
        return baiDoXeid;
    }

    public void setBaiDoXeid(Baidoxe baiDoXeid) {
        this.baiDoXeid = baiDoXeid;
    }

    public Loaixe getLoaiXeid() {
        return loaiXeid;
    }

    public void setLoaiXeid(Loaixe loaiXeid) {
        this.loaiXeid = loaiXeid;
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
        if (!(object instanceof Giaca)) {
            return false;
        }
        Giaca other = (Giaca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Giaca[ id=" + id + " ]";
    }
    
}
