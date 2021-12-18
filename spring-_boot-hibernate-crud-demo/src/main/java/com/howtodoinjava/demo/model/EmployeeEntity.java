package com.howtodoinjava.demo.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TBL_EMPLOYEES", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmployees.findAll", query = "SELECT t FROM EmployeeEntity t")
    , @NamedQuery(name = "TblEmployees.findById", query = "SELECT t FROM EmployeeEntity t WHERE t.id = :id")
    , @NamedQuery(name = "TblEmployees.findByFirstName", query = "SELECT t FROM EmployeeEntity t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TblEmployees.findByLastName", query = "SELECT t FROM EmployeeEntity t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "TblEmployees.findByEmail", query = "SELECT t FROM EmployeeEntity t WHERE t.email = :email")})
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME", nullable = false, length = 250)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME", nullable = false, length = 250)
    private String lastName;
    @Column(name = "EMAIL", length = 250)
    private String email;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id) {
        this.id = id;
    }

    public EmployeeEntity(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tsli.dd.batch.entity.EmployeeEntity[ id=" + id + " ]";
    }
    
}
