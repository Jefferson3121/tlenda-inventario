package com.tienda.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tienda.bd.ConexionBD;
import com.tienda.models.Producto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductosDAO {
    private static Logger logger = LoggerFactory.getLogger(ProductosDAO.class);

    public static List<Producto> extraerProductosBD(){

        List<Producto> productoList = new ArrayList<>();

        String sql = "SELECT * FROM productos";

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                BigDecimal precio = resultSet.getBigDecimal("precio");
                int stock = resultSet.getInt("stock");
                int idCategoria = resultSet.getInt("id_categoria");

              productoList.add(new Producto(nombre,precio,stock));

            }
        }catch (SQLException e){
            logger.error("Error al extarer datos BD: {}", sql, e);
        }
         return productoList;
    }

    public static boolean insertarProductoBD(Producto producto) {

        boolean insertado = false;

        String sql = "INSERT INTO productos(nombre,precio,stock) VALUES (?,?,?)";

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setBigDecimal(2, producto.getPrecio());
            preparedStatement.setInt(3,producto.getStock());

            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0) {
                insertado = true;
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    if (resultSet.next()){
                        int idGenerado = resultSet.getInt("id");
                        producto.setId(idGenerado);
                    }else {
                        throw new IllegalStateException("No se pudo recuperar el id al momento de agregar el producto");
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("Error al insertar producto (SQL: {})", sql, e);
        }
        return insertado;
    }

    public static void actualizarProductoBD(Producto producto){
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoria = ? WHERE = ?";
    }

    public void eliminarProductoBD(Producto producto){

        String sql = "DELeTE FROM productos WHERE id = ?";
    }
}
