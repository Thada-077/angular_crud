/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cruduser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TH_DISTRICT", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThDistrict.findAll", query = "SELECT t FROM ThDistrict t")
    , @NamedQuery(name = "ThDistrict.findById", query = "SELECT t FROM ThDistrict t WHERE t.id = :id")
    , @NamedQuery(name = "ThDistrict.findByNameTh", query = "SELECT t FROM ThDistrict t WHERE t.nameTh = :nameTh")
    , @NamedQuery(name = "ThDistrict.findByNameEn", query = "SELECT t FROM ThDistrict t WHERE t.nameEn = :nameEn")})
public class ThDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "PROVINCE_ID")
    private Long provinceId;
    @Column(name = "NAME_TH", length = 120)
    private String nameTh;
    @Column(name = "NAME_EN", length = 120)
    private String nameEn;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public ThDistrict() {
    }

    public ThDistrict(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
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
        return "com.howtodoinjava.demo.model.ThDistrict[ id=" + id + " ]";
    }

}
