package gt.com.model.dao;


import gt.com.model.entity.UserEntity;
import gt.com.model.propertiesApp.ConfigurationApp;

import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDao implements IUserDao {

    public UserDao() {
    }

    @Override
    public UserEntity getUser(String email, String password) throws SQLException {
        ConexionSingleton conexion = ConexionSingleton.getInstance();

        ConfigurationApp config = new ConfigurationApp();
        String emailP = email;
        String passwordP = password;


        String query = String.format("select id_user,username,password,role,enable,email,users.key from users where email = '%s' and password = '%s';",emailP,passwordP );
        UserEntity entity = new UserEntity();
        try {
            conexion.abrirConexion();

            ResultSet rs = conexion.conexionBD.createStatement().executeQuery(query);


            while (rs.next()) {
                entity.setIdUser(rs.getInt("id_user"));
                entity.setFullName(rs.getString("username"));
                entity.setPassword(rs.getString("password"));
                entity.setRole(rs.getString("role"));
                entity.setEnable(rs.getInt("enable"));
                entity.setEmail(rs.getString("email"));
                entity.setKey(rs.getString("key"));
            }

        } catch (SQLException e) {
            throw e;

        } finally {
            conexion.cerrarConexion();
        }
        return entity;

    }
}