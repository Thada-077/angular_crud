package com.example.cruduser.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADDRESS_TYPE", catalog = "TEST", schema = "PUBLIC")
@NamedQueries({
        @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a"),
        @NamedQuery(name = "AddressType.findById", query = "SELECT a FROM AddressType a WHERE a.id = :id"),
        @NamedQuery(name = "AddressType.findByType", query = "SELECT a FROM AddressType a WHERE a.type = :type") })
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "TYPE", nullable = false, length = 512)
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public AddressType() {
    }

    public AddressType(Long id) {
        this.id = id;
    }

    public AddressType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof AddressType)) {
            return false;
        }
        AddressType other = (AddressType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.AddressType[ id=" + id + " ]";
    }

}
