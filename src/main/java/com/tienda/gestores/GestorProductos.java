package com.tienda.gestores;

import com.tienda.dao.ProductosDAO;
import com.tienda.models.Producto;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos = ProductosDAO.extraerProductosBD();

    public void agregarProductp(@NonNull Producto producto){

        if (productos.contains(producto)){
            System.out.println("El producto ya existe");
            return;
        }

        if (ProductosDAO.insertarProductoBD(producto)){
            productos.add(producto);
            System.out.println("Producto agregado correctamente");
        }
    }


}
