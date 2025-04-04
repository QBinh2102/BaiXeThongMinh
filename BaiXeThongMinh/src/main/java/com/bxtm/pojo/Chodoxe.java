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
@Table(name = "chodoxe")
@NamedQueries({
    @NamedQuery(name = "Chodoxe.findAll", query = "SELECT c FROM Chodoxe c"),
    @NamedQuery(name = "Chodoxe.findById", query = "SELECT c FROM Chodoxe c WHERE c.id = :id"),
    @NamedQuery(name = "Chodoxe.findByViTri", query = "SELECT c FROM Chodoxe c WHERE c.viTri = :viTri"),
    @NamedQuery(name = "Chodoxe.findByTrangThai", query = "SELECT c FROM Chodoxe c WHERE c.trangThai = :trangThai")})
public class Chodoxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "viTri")
    private String viTri;
    @Basic(optional = false)
    @Column(name = "trangThai")
    private String trangThai;
    @OneToMany(mappedBy = "choDoXeid")
    private Set<Booking> bookingSet;
    @OneToMany(mappedBy = "choDoXeid")
    private Set<Danhgia> danhgiaSet;
    @JoinColumn(name = "BaiDoXe_id", referencedColumnName = "id")
    @ManyToOne
    private Baidoxe baiDoXeid;
    @JoinColumn(name = "LoaiXe_id", referencedColumnName = "id")
    @ManyToOne
    private Loaixe loaiXeid;

    public Chodoxe() {
    }

    public Chodoxe(Integer id) {
        this.id = id;
    }

    public Chodoxe(Integer id, String trangThai) {
        this.id = id;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
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
        if (!(object instanceof Chodoxe)) {
            return false;
        }
        Chodoxe other = (Chodoxe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Chodoxe[ id=" + id + " ]";
    }
    
}
