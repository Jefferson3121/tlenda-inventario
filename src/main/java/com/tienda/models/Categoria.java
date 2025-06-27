package com.tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Categoria {
    private int id;
    private String nombre;


    @Override
    public boolean equals(@NonNull Object object){
        if (this == object){
            return true;
        }

        if (this.getClass() != object.getClass()){
            return false;
        }

        Categoria categoria2 = (Categoria) object;

        return this.getNombre().equalsIgnoreCase(categoria2.getNombre());
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}
