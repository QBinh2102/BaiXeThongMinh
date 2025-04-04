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
import java.util.Date;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "thanhtoan")
@NamedQueries({
    @NamedQuery(name = "Thanhtoan.findAll", query = "SELECT t FROM Thanhtoan t"),
    @NamedQuery(name = "Thanhtoan.findById", query = "SELECT t FROM Thanhtoan t WHERE t.id = :id"),
    @NamedQuery(name = "Thanhtoan.findByPhuongThucThanhToan", query = "SELECT t FROM Thanhtoan t WHERE t.phuongThucThanhToan = :phuongThucThanhToan"),
    @NamedQuery(name = "Thanhtoan.findByTrangThai", query = "SELECT t FROM Thanhtoan t WHERE t.trangThai = :trangThai"),
    @NamedQuery(name = "Thanhtoan.findByThoiGianThanhToan", query = "SELECT t FROM Thanhtoan t WHERE t.thoiGianThanhToan = :thoiGianThanhToan")})
public class Thanhtoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "phuongThucThanhToan")
    private String phuongThucThanhToan;
    @Basic(optional = false)
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "thoiGianThanhToan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianThanhToan;
    @JoinColumn(name = "Booking_id", referencedColumnName = "id")
    @ManyToOne
    private Booking bookingid;
    @JoinColumn(name = "NguoiDung_id", referencedColumnName = "id")
    @ManyToOne
    private Nguoidung nguoiDungid;

    public Thanhtoan() {
    }

    public Thanhtoan(Integer id) {
        this.id = id;
    }

    public Thanhtoan(Integer id, String phuongThucThanhToan, String trangThai) {
        this.id = id;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(Date thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public Booking getBookingid() {
        return bookingid;
    }

    public void setBookingid(Booking bookingid) {
        this.bookingid = bookingid;
    }

    public Nguoidung getNguoiDungid() {
        return nguoiDungid;
    }

    public void setNguoiDungid(Nguoidung nguoiDungid) {
        this.nguoiDungid = nguoiDungid;
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
        if (!(object instanceof Thanhtoan)) {
            return false;
        }
        Thanhtoan other = (Thanhtoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Thanhtoan[ id=" + id + " ]";
    }
    
}
