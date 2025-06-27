package com.tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
public class Producto {
    @Getter
    private final int id;
    @Getter
    private String nombre;
    @Getter
    @Setter
    private BigDecimal precio;
    @Getter
    @Setter
    private String categoria;

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Producto producto2 = (Producto) obj;

        return  this.getNombre().equalsIgnoreCase(((Producto) obj).getNombre()) && this.getCategoria().equalsIgnoreCase(((Producto) obj).getCategoria());
    }

    @Override
    public int hashCode(){
     return   Objects.hash(id,nombre,categoria);
    }
}
