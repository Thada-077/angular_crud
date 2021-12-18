/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.howtodoinjava.demo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TH_PROVINCE", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThProvince.findAll", query = "SELECT t FROM ThProvince t")
    , @NamedQuery(name = "ThProvince.findById", query = "SELECT t FROM ThProvince t WHERE t.id = :id")
    , @NamedQuery(name = "ThProvince.findByNameTh", query = "SELECT t FROM ThProvince t WHERE t.nameTh = :nameTh")
    , @NamedQuery(name = "ThProvince.findByNameEn", query = "SELECT t FROM ThProvince t WHERE t.nameEn = :nameEn")})
public class ThProvince implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Short id;
    @Column(name = "NAME_TH", length = 120)
    private String nameTh;
    @Column(name = "NAME_EN", length = 120)
    private String nameEn;
//    @OneToMany(mappedBy = "provinceId", fetch = FetchType.LAZY)
//    private List<ThDistrict> thDistrictList;

    public ThProvince() {
    }

    public ThProvince(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

//    @XmlTransient
//    public List<ThDistrict> getThDistrictList() {
//        return thDistrictList;
//    }
//
//    public void setThDistrictList(List<ThDistrict> thDistrictList) {
//        this.thDistrictList = thDistrictList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThProvince)) {
            return false;
        }
        ThProvince other = (ThProvince) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.howtodoinjava.demo.model.ThProvince[ id=" + id + " ]";
    }
    
}
