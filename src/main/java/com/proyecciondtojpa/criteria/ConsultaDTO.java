/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecciondtojpa.criteria;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author pryet
 */
public class ConsultaDTO implements Serializable{
    private Long contador;
    private double precio;

    public ConsultaDTO(Long contador, double precio) {
        this.contador = contador;
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.contador);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConsultaDTO other = (ConsultaDTO) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.contador, other.contador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConsultaDTO{" + "contador=" + contador + ", precio=" + precio + '}';
    }
    
    

    public Long getContador() {
        return contador;
    }

    public void setContador(Long contador) {
        this.contador = contador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
}
