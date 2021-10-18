/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecciondtojpa.criteria;

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

/**
 *
 * @author pryet
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Item.findByItemName", query = "SELECT i FROM Item i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Item.findByItemDescripcion", query = "SELECT i FROM Item i WHERE i.itemDescripcion = :itemDescripcion"),
    @NamedQuery(name = "Item.findByItemPrecio", query = "SELECT i FROM Item i WHERE i.itemPrecio = :itemPrecio")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem")
    private Integer iditem;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "itemDescripcion")
    private String itemDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "itemPrecio")
    private Double itemPrecio;

    public Item() {
    }

    public Item(String itemName, Double itemPrecio) {
        this.itemName = itemName;
        this.itemPrecio = itemPrecio;
    }
    
    public Item(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescripcion() {
        return itemDescripcion;
    }

    public void setItemDescripcion(String itemDescripcion) {
        this.itemDescripcion = itemDescripcion;
    }

    public Double getItemPrecio() {
        return itemPrecio;
    }

    public void setItemPrecio(Double itemPrecio) {
        this.itemPrecio = itemPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecciondtojpa.criteria.Item[ iditem=" + iditem + " ]";
    }
    
}
