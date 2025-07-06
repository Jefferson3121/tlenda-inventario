package com.tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class Producto {
    private  int id;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private Categoria categoria;

    public Producto(String nombre, BigDecimal precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Producto producto2 = (Producto) obj;

        return  this.getNombre().equalsIgnoreCase((producto2.getNombre())) && this.categoria.equals(producto2.getCategoria());
    }

    @Override
    public int hashCode(){
     return   Objects.hash(id,nombre,categoria);
    }
}
