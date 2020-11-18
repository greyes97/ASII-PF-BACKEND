package gt.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {

    public static ConexionSingleton conection;
    public Connection conexionBD;

    private ConexionSingleton(){

    }
    public static ConexionSingleton getInstance(){
        if(conection == null){
            conection = new ConexionSingleton();
        }
        return conection;
    }


    public void abrirConexion() {

        try {
            String jdbc = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbc);
            String urlConexion = "jdbc:mysql://bhuisxvi6lxwrcnlbd5f-mysql.services.clever-cloud.com:3306/bhuisxvi6lxwrcnlbd5f";
            String usuario = "uvarzjtbbn8qx9fb";
            String contra = "3ol1tm2JVXXrCeaTpKLW";
            conexionBD = DriverManager.getConnection(urlConexion, usuario, contra);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cerrarConexion()
    {
        try
        {
            conexionBD.close();
        }
        catch (Exception ex)
        {

        }
    }


}
