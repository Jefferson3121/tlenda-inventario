package com.tienda.dao;

import com.tienda.bd.ConexionBD;
import com.tienda.models.Categoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAO {
    private static Logger logger = LoggerFactory.getLogger(CategoriasDAO.class);

    public static List<Categoria> extareerCategoriasBD() {
        List<Categoria> categoriasList = new ArrayList<>();

        String sql = "SELECT * FROM categorias";

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                Categoria categoria = new Categoria(nombre);
                categoria.setId(id);

                categoriasList.add(categoria);

            }

        } catch (SQLException e) {
            logger.error("Error al extraer productos");
        }
        return categoriasList;
    }

    public static boolean agregarCategoriaBD(Categoria categoria){

        boolean agregado = false;

        String sql = "INSERT INTO categorias(nombre) VALUES(?)";

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){

          preparedStatement.setString(1,categoria.getNombre());


          int resultado = preparedStatement.executeUpdate();

          if (resultado > 0){
              agregado = true;
              try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                  if(resultSet.next()){
                      int idGenerado = resultSet.getInt("id");
                      categoria.setId(idGenerado);
                  }else {
                      throw new  IllegalStateException("Error al recuperar el id de la categoria lueho de agregada a la bd ");
                  }

              }
              System.out.println("Categoria agregada exitosamente");
          }

        }catch (SQLException e){
            logger.error("Error al insertar producto. Consulta que fallo -->{} ", sql, e);
        }

        return agregado;
    }

    public static void eliminarCatageriaBD(String nombre) {

        String sql = "DELETE FROM categorias WHERE nombre = ?";

        try (Connection connection = ConexionBD.obtnerConexionBD().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,nombre);

            int resultado = preparedStatement.executeUpdate();

            System.out.println(resultado);

            if (resultado > 0){
                System.out.println(String.format("Categoaria %s eliminada correctamente ", nombre));
            }else {
                System.out.println("Categoria no eliminada, verifique que la categoria (" + nombre + ") exista ");
            }

        } catch(SQLException e){
        logger.error("Error al eliminar producto, consulta error --> {}",sql, e );
        }

    }
}
