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
import jakarta.persistence.Lob;
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
@Table(name = "baidoxe")
@NamedQueries({
    @NamedQuery(name = "Baidoxe.findAll", query = "SELECT b FROM Baidoxe b"),
    @NamedQuery(name = "Baidoxe.findById", query = "SELECT b FROM Baidoxe b WHERE b.id = :id"),
    @NamedQuery(name = "Baidoxe.findByTen", query = "SELECT b FROM Baidoxe b WHERE b.ten = :ten"),
    @NamedQuery(name = "Baidoxe.findByDiaChi", query = "SELECT b FROM Baidoxe b WHERE b.diaChi = :diaChi"),
    @NamedQuery(name = "Baidoxe.findBySoLuongXeMay", query = "SELECT b FROM Baidoxe b WHERE b.soLuongXeMay = :soLuongXeMay"),
    @NamedQuery(name = "Baidoxe.findBySoLuongXeOTo", query = "SELECT b FROM Baidoxe b WHERE b.soLuongXeOTo = :soLuongXeOTo"),
    @NamedQuery(name = "Baidoxe.findByTrangThai", query = "SELECT b FROM Baidoxe b WHERE b.trangThai = :trangThai"),
    @NamedQuery(name = "Baidoxe.findByNgayTao", query = "SELECT b FROM Baidoxe b WHERE b.ngayTao = :ngayTao")})
public class Baidoxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @Column(name = "soLuongXeMay")
    private int soLuongXeMay;
    @Basic(optional = false)
    @Column(name = "soLuongXeOTo")
    private int soLuongXeOTo;
    @Lob
    @Column(name = "tienIch")
    private String tienIch;
    @Basic(optional = false)
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "ngayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @OneToMany(mappedBy = "baiDoXeid")
    private Set<Giaca> giacaSet;
    @OneToMany(mappedBy = "baiDoXeid")
    private Set<Chodoxe> chodoxeSet;

    public Baidoxe() {
    }

    public Baidoxe(Integer id) {
        this.id = id;
    }

    public Baidoxe(Integer id, String ten, String diaChi, int soLuongXeMay, int soLuongXeOTo, String trangThai) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soLuongXeMay = soLuongXeMay;
        this.soLuongXeOTo = soLuongXeOTo;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoLuongXeMay() {
        return soLuongXeMay;
    }

    public void setSoLuongXeMay(int soLuongXeMay) {
        this.soLuongXeMay = soLuongXeMay;
    }

    public int getSoLuongXeOTo() {
        return soLuongXeOTo;
    }

    public void setSoLuongXeOTo(int soLuongXeOTo) {
        this.soLuongXeOTo = soLuongXeOTo;
    }

    public String getTienIch() {
        return tienIch;
    }

    public void setTienIch(String tienIch) {
        this.tienIch = tienIch;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Set<Giaca> getGiacaSet() {
        return giacaSet;
    }

    public void setGiacaSet(Set<Giaca> giacaSet) {
        this.giacaSet = giacaSet;
    }

    public Set<Chodoxe> getChodoxeSet() {
        return chodoxeSet;
    }

    public void setChodoxeSet(Set<Chodoxe> chodoxeSet) {
        this.chodoxeSet = chodoxeSet;
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
        if (!(object instanceof Baidoxe)) {
            return false;
        }
        Baidoxe other = (Baidoxe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Baidoxe[ id=" + id + " ]";
    }
    
}
