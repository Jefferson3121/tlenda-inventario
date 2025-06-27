package com.tienda.dao;

import com.tienda.bd.ConexionBD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class ProductosDAO {

    public String mostrarProductos(){
        String sql = "SELECT * FROM productos";

        String resultado;

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                BigDecimal precio = resultSet.getBigDecimal("precio");
                int id_categoria = resultSet.getInt("categoria");

               String categoria;

               switch (id_categoria){
                   case 1 -> categoria = "Frutas ";
                   case 2 -> categoria = "Verduras";
               }

                Locale colombia = new Locale("es", "CO");

                NumberFormat formateraPrecio = NumberFormat.getCurrencyInstance(colombia);

                String precioFpormateado = formateraPrecio.format(precio);

                resultado = String.format("ID: %d __ Nombre: %s __  ");
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
