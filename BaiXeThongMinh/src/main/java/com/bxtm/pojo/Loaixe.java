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
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author GIGA
 */
@Entity
@Table(name = "loaixe")
@NamedQueries({
    @NamedQuery(name = "Loaixe.findAll", query = "SELECT l FROM Loaixe l"),
    @NamedQuery(name = "Loaixe.findById", query = "SELECT l FROM Loaixe l WHERE l.id = :id"),
    @NamedQuery(name = "Loaixe.findByTen", query = "SELECT l FROM Loaixe l WHERE l.ten = :ten")})
public class Loaixe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ten")
    private String ten;
    @OneToMany(mappedBy = "loaiXeid")
    private Set<Giaca> giacaSet;
    @OneToMany(mappedBy = "loaiXe")
    private Set<Xe> xeSet;
    @OneToMany(mappedBy = "loaiXeid")
    private Set<Chodoxe> chodoxeSet;

    public Loaixe() {
    }

    public Loaixe(Integer id) {
        this.id = id;
    }

    public Loaixe(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
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

    public Set<Giaca> getGiacaSet() {
        return giacaSet;
    }

    public void setGiacaSet(Set<Giaca> giacaSet) {
        this.giacaSet = giacaSet;
    }

    public Set<Xe> getXeSet() {
        return xeSet;
    }

    public void setXeSet(Set<Xe> xeSet) {
        this.xeSet = xeSet;
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
        if (!(object instanceof Loaixe)) {
            return false;
        }
        Loaixe other = (Loaixe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bxtm.pojo.Loaixe[ id=" + id + " ]";
    }
    
}
