package gt.com.model.Dao;

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
            String urlConexion = "jdbc:mysql://localhost:3306/hopital_as2_pf?serverTimezone=UTC";
            String usuario = "root";
            String contra = "Silver0cho";
            conexionBD = DriverManager.getConnection(urlConexion, usuario, contra);
            System.out.println("Conexion eexitosa");


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
            //JOptionPane.showMessageDialog(null,ex.getMessage(),"CONEXION FALLIDA ",JOptionPane.ERROR_MESSAGE);
        }
    }


}
