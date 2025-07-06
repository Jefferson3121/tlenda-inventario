package com.tienda.models;

import lombok.*;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class Categoria {
    @Setter
    private int id;
    private final String nombre;


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

    @Override
    public String toString(){
        return  String.format("ID: %d | Nombre: %s", id,nombre);
    }
}
