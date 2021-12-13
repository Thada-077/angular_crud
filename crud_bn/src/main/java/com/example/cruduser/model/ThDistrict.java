/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cruduser.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author fiw00
 */
@Entity
@Table(name = "TH_DISTRICT", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThDistrict.findAll", query = "SELECT t FROM ThDistrict t")
    , @NamedQuery(name = "ThDistrict.findById", query = "SELECT t FROM ThDistrict t WHERE t.id = :id")
    , @NamedQuery(name = "ThDistrict.findByProvinceId", query = "SELECT t FROM ThDistrict t WHERE t.provinceId = :provinceId")
    , @NamedQuery(name = "ThDistrict.findByNameTh", query = "SELECT t FROM ThDistrict t WHERE t.nameTh = :nameTh")
    , @NamedQuery(name = "ThDistrict.findByNameEn", query = "SELECT t FROM ThDistrict t WHERE t.nameEn = :nameEn")})
public class ThDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Short id;
    @Column(name = "PROVINCE_ID")
    private Short provinceId;
    @Column(name = "NAME_TH", length = 120)
    private String nameTh;
    @Column(name = "NAME_EN", length = 120)
    private String nameEn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public ThDistrict() {
    }

    public ThDistrict(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
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

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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
        if (!(object instanceof ThDistrict)) {
            return false;
        }
        ThDistrict other = (ThDistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.ThDistrict[ id=" + id + " ]";
    }
    
}
