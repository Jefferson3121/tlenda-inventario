package com.tienda;

import com.tienda.dao.CategoriasDAO;
import com.tienda.dao.ProductosDAO;
import com.tienda.models.Categoria;
import com.tienda.models.Producto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        CategoriasDAO.agregarCategoriaBD(new Categoria("Verduras"));

        CategoriasDAO.extareerCategoriasBD().forEach(System.out::println);
        }

    }
