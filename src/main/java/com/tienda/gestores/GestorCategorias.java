package com.tienda.gestores;

import com.tienda.dao.CategoriasDAO;
import com.tienda.models.Categoria;
import lombok.NonNull;

import java.util.List;

public class GestorCategorias {
    private List<Categoria> categorias = CategoriasDAO.extareerCategoriasBD();

    public void agregarCategorias(@NonNull Categoria categoria){
        if (categorias.contains(categoria)){
            System.out.println("La categoria ya existe en la lista");
            return;
        }
        categorias.add(categoria);

        if (!CategoriasDAO.agregarCategoriaBD(categoria)){
            System.out.println("Se ha agregado correctamente al categoria");
        }
    }
}
