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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByThoiGianBatDau", query = "SELECT b FROM Booking b WHERE b.thoiGianBatDau = :thoiGianBatDau"),
    @NamedQuery(name = "Booking.findByThoiGianKetThuc", query = "SELECT b FROM Booking b WHERE b.thoiGianKetThuc = :thoiGianKetThuc"),
    @NamedQuery(name = "Booking.findByGiaTien", query = "SELECT b FROM Booking b WHERE b.giaTien = :giaTien"),
    @NamedQuery(name = "Booking.findByThoiGianDat", query = "SELECT b FROM Booking b WHERE b.thoiGianDat = :thoiGianDat"),
    @NamedQuery(name = "Booking.findByTrangThai", query = "SELECT b FROM Booking b WHERE b.trangThai = :trangThai")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "thoiGianBatDau")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianBatDau;
    @Basic(optional = false)
    @Column(name = "thoiGianKetThuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianKetThuc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "giaTien")
    private BigDecimal giaTien;
    @Column(name = "thoiGianDat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianDat;
    @Basic(optional = false)
    @Column(name = "trangThai")
    private String trangThai;
    @OneToMany(mappedBy = "bookingid")
    private Set<Thanhtoan> thanhtoanSet;
    @JoinColumn(name = "ChoDoXe_id", referencedColumnName = "id")
    @ManyToOne
    private Chodoxe choDoXeid;
    @JoinColumn(name = "NguoiDung_id", referencedColumnName = "id")
    @ManyToOne
    private Nguoidung nguoiDungid;
    @JoinColumn(name = "Xe_id", referencedColumnName = "id")
    @ManyToOne
    private Xe xeid;

    public Booking() {
    }

    public Booking(Integer id) {
        this.id = id;
    }

    public Booking(Integer id, Date thoiGianBatDau, Date thoiGianKetThuc, BigDecimal giaTien, String trangThai) {
        this.id = id;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public Date getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Date thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Set<Thanhtoan> getThanhtoanSet() {
        return thanhtoanSet;
    }

    public void setThanhtoanSet(Set<Thanhtoan> thanhtoanSet) {
        this.thanhtoanSet = thanhtoanSet;
    }

    public Chodoxe getChoDoXeid() {
        return choDoXeid;
    }

    public void setChoDoXeid(Chodoxe choDoXeid) {
        this.choDoXeid = choDoXeid;
    }

    public Nguoidung getNguoiDungid() {
        return nguoiDungid;
    }

    public void setNguoiDungid(Nguoidung nguoiDungid) {
        this.nguoiDungid = nguoiDungid;
    }

    public Xe getXeid() {
        return xeid;
    }

    public void setXeid(Xe xeid) {
        this.xeid = xeid;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Booking[ id=" + id + " ]";
    }
    
}
