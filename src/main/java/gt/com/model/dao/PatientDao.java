package gt.com.model.dao;

import gt.com.model.entity.PatientEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static gt.com.model.propertiesApp.ConfigurationApp.*;


public class PatientDao implements IPatientDao {

    public PatientDao() {
    }

    public boolean savePatient(PatientEntity patient) throws SQLException {
        ConexionSingleton conection = ConexionSingleton.getInstance();
        boolean rs;

        PatientEntity patients = new PatientEntity();

        try{
            conection.abrirConexion();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String dateparameter = dateFormat.format(patient.getBirthdate());
            System.out.println(dateparameter);
            String query = String.format("insert into patients(dpi,nit,birthday,gender,fullName,surName,address,phone,emergencyContact) values (%d,'%s','%s','%c','%s','%s','%s',%d,%d);",
                        patient.getDpi(),patient.getNit(),dateparameter,patient.getGender(),patient.getFullName(),patient.getSurName(),patient.getAddress(),patient.getPhone()
                        ,patient.getEmergencyContact());
            System.out.println(query);
             rs = conection.conexionBD.createStatement().execute(query);
            System.out.println(rs);
            
        }catch (SQLException ex){
            throw ex;
        }
        return rs;
    }

    public List<PatientEntity> getPacients() throws SQLException {
        ConexionSingleton conection = ConexionSingleton.getInstance();

        List<PatientEntity>patients = new ArrayList<>();
        try{
            conection.abrirConexion();
            String query = "select idPatient,dpi,nit,birthday,gender,fullName,surName,address,phone,emergencyContact from patients limit 30;";

            ResultSet rs = conection.conexionBD.createStatement().executeQuery(query);

            while (rs.next()){
                PatientEntity nuevo = new PatientEntity();
                nuevo.setId_user(Integer.parseInt(rs.getString("idPatient")));
                nuevo.setDpi(Integer.parseInt(rs.getString("dpi")));
                nuevo.setNit(rs.getString("nit"));
                nuevo.setBirthdate(rs.getDate("birthday"));
                nuevo.setGender(rs.getString("gender").charAt(0));
                nuevo.setFullName(rs.getString("fullName"));
                nuevo.setSurName(rs.getString("surName"));
                nuevo.setAddress(rs.getString("address"));
                nuevo.setPhone(Integer.parseInt(rs.getString("phone")));
                nuevo.setEmergencyContact(Integer.parseInt(rs.getString("emergencyContact")));

                patients.add(nuevo);
            }

        }catch (SQLException ex){
            throw ex;

        }finally {
            conection.cerrarConexion();
        }

        return patients;
    }

    public int updatePatient(PatientEntity patient) throws SQLException {

        ConexionSingleton conection = ConexionSingleton.getInstance();
        PreparedStatement parametro;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateparameter = dateFormat.format(patient.getBirthdate());
        try {

            PatientEntity patients = new PatientEntity();
            conection.abrirConexion();

            parametro = (PreparedStatement)conection.conexionBD.prepareStatement(QUERY_PATIENTS_UPDATE);
            parametro.setInt(1, patient.getDpi());
            parametro.setString(2, patient.getNit());
            parametro.setString(3, dateparameter);
            parametro.setString(4, String.valueOf(patient.getGender()));
            parametro.setString(5, patient.getFullName());
            parametro.setString(6, patient.getSurName());
            parametro.setString(7, patient.getAddress());
            parametro.setInt(8, patient.getPhone());
            parametro.setInt(9, patient.getEmergencyContact());
            parametro.setInt(10,patient.getId_user());

            parametro.executeUpdate();
            System.out.println(parametro);

        } catch (SQLException ex )
        {
            throw ex;
        }finally {
            conection.cerrarConexion();
        }
        return 1;
    }

    @Override
    public PatientEntity getPatientById(int id) throws SQLException {
        ConexionSingleton conection = ConexionSingleton.getInstance();

        PatientEntity patient = new PatientEntity();
        try{
            conection.abrirConexion();

            String query = String.format("select idPatient,dpi,nit,birthday,gender,fullName,surName,address,phone,emergencyContact from patients where idPatient = %d;",id);
            ResultSet rs = conection.conexionBD.createStatement().executeQuery(query);

            while (rs.next()){
                patient.setId_user(Integer.parseInt(rs.getString("idPatient")));
                patient.setDpi(Integer.parseInt(rs.getString("dpi")));
                patient.setNit(rs.getString("nit"));
                patient.setBirthdate(rs.getDate("birthday"));
                patient.setGender(rs.getString("gender").charAt(0));
                patient.setFullName(rs.getString("fullName"));
                patient.setSurName(rs.getString("surName"));
                patient.setAddress(rs.getString("address"));
                patient.setPhone(Integer.parseInt(rs.getString("phone")));
                patient.setEmergencyContact(Integer.parseInt(rs.getString("emergencyContact")));
            }

        }catch (SQLException ex){
            throw ex;

        }finally {
            conection.cerrarConexion();
        }

        return patient;
    }


}