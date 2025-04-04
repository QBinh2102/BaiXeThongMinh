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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "nguoidung")
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findById", query = "SELECT n FROM Nguoidung n WHERE n.id = :id"),
    @NamedQuery(name = "Nguoidung.findByHoVaTen", query = "SELECT n FROM Nguoidung n WHERE n.hoVaTen = :hoVaTen"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findByMatKhau", query = "SELECT n FROM Nguoidung n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "Nguoidung.findBySdt", query = "SELECT n FROM Nguoidung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nguoidung.findByCccd", query = "SELECT n FROM Nguoidung n WHERE n.cccd = :cccd"),
    @NamedQuery(name = "Nguoidung.findByVaiTro", query = "SELECT n FROM Nguoidung n WHERE n.vaiTro = :vaiTro"),
    @NamedQuery(name = "Nguoidung.findByNgayTao", query = "SELECT n FROM Nguoidung n WHERE n.ngayTao = :ngayTao"),
    @NamedQuery(name = "Nguoidung.findByActive", query = "SELECT n FROM Nguoidung n WHERE n.active = :active")})
public class Nguoidung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "hoVaTen")
    private String hoVaTen;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "matKhau")
    private String matKhau;
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Basic(optional = false)
    @Column(name = "cccd")
    private String cccd;
    @Basic(optional = false)
    @Column(name = "vaiTro")
    private String vaiTro;
    @Column(name = "ngayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "nguoiDungid")
    private Set<Thanhtoan> thanhtoanSet;
    @OneToMany(mappedBy = "nguoiDungid")
    private Set<Booking> bookingSet;
    @OneToMany(mappedBy = "nguoiDungid")
    private Set<Thongbao> thongbaoSet;
    @OneToMany(mappedBy = "nguoiDungid")
    private Set<Soden> sodenSet;
    @OneToMany(mappedBy = "nguoiDungid")
    private Set<Danhgia> danhgiaSet;
    @OneToMany(mappedBy = "idNguoiDung")
    private Set<Xe> xeSet;

    public Nguoidung() {
    }

    public Nguoidung(Integer id) {
        this.id = id;
    }

    public Nguoidung(Integer id, String hoVaTen, String email, String matKhau, String sdt, String cccd, String vaiTro) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.email = email;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.cccd = cccd;
        this.vaiTro = vaiTro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Thanhtoan> getThanhtoanSet() {
        return thanhtoanSet;
    }

    public void setThanhtoanSet(Set<Thanhtoan> thanhtoanSet) {
        this.thanhtoanSet = thanhtoanSet;
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    public Set<Thongbao> getThongbaoSet() {
        return thongbaoSet;
    }

    public void setThongbaoSet(Set<Thongbao> thongbaoSet) {
        this.thongbaoSet = thongbaoSet;
    }

    public Set<Soden> getSodenSet() {
        return sodenSet;
    }

    public void setSodenSet(Set<Soden> sodenSet) {
        this.sodenSet = sodenSet;
    }

    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
    }

    public Set<Xe> getXeSet() {
        return xeSet;
    }

    public void setXeSet(Set<Xe> xeSet) {
        this.xeSet = xeSet;
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
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Nguoidung[ id=" + id + " ]";
    }
    
}
