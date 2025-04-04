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
import jakarta.persistence.Lob;
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
@Table(name = "danhgia")
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findById", query = "SELECT d FROM Danhgia d WHERE d.id = :id"),
    @NamedQuery(name = "Danhgia.findByRating", query = "SELECT d FROM Danhgia d WHERE d.rating = :rating"),
    @NamedQuery(name = "Danhgia.findByThoiGianDanhGia", query = "SELECT d FROM Danhgia d WHERE d.thoiGianDanhGia = :thoiGianDanhGia")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;
    @Lob
    @Column(name = "binhLuan")
    private String binhLuan;
    @Column(name = "thoiGianDanhGia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianDanhGia;
    @JoinColumn(name = "ChoDoXe_id", referencedColumnName = "id")
    @ManyToOne
    private Chodoxe choDoXeid;
    @JoinColumn(name = "NguoiDung_id", referencedColumnName = "id")
    @ManyToOne
    private Nguoidung nguoiDungid;

    public Danhgia() {
    }

    public Danhgia(Integer id) {
        this.id = id;
    }

    public Danhgia(Integer id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public Date getThoiGianDanhGia() {
        return thoiGianDanhGia;
    }

    public void setThoiGianDanhGia(Date thoiGianDanhGia) {
        this.thoiGianDanhGia = thoiGianDanhGia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Danhgia[ id=" + id + " ]";
    }
    
}
