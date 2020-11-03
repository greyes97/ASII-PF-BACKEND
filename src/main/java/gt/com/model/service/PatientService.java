package gt.com.model.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gt.com.model.dao.IPatientDao;
import gt.com.model.dao.PatientDao;
import gt.com.model.entity.PatientEntity;
import gt.com.model.dto.ResponsePatientDto;

import javax.servlet.http.HttpServletRequest;

import static gt.com.model.propertiesApp.MessagesErrorApp.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PatientService implements IPatientService{


    @Override
    public ResponsePatientDto getPatients() {

        JsonArray jsonObject;
        JsonObject respuesta = new JsonObject();
        Gson gson = new Gson();
        IPatientDao patientDao = new PatientDao();
        List<PatientEntity>  patients = null;


        try {
            patients = patientDao.getPacients();
        } catch (SQLException throwables) {
            return new ResponsePatientDto(SQL_ERROR_QUERY);
        }

        if (patients.isEmpty()) {
            return new ResponsePatientDto(SQL_NOT_PATIETN);
        }
        else{
            String json = gson.toJson(patients);
            jsonObject = new JsonParser().parse(json).getAsJsonArray();

            return new ResponsePatientDto(patients,true);
            }
    }

    @Override
    public ResponsePatientDto savePatient(PatientEntity patient) {
        JsonObject jsonObject;
        JsonObject respuesta = new JsonObject();
        Gson gson = new Gson();

        IPatientDao patientDao = new PatientDao();

        boolean  patientlocal = false;
        try {
            patientlocal = patientDao.savePatient(patient);
        } catch (SQLException ex) {
            return new ResponsePatientDto(SQL_ERROR_QUERY);
        }
        if (patientlocal == true) {
            respuesta.addProperty("status", "false");
            String json = gson.toJson(respuesta);
            jsonObject = new JsonParser().parse(json).getAsJsonObject();
            return new ResponsePatientDto(SQL_TIME_OUT);
        }
        else{
            //respuesta.addProperty("stateCorrect","true");
            return new ResponsePatientDto(true);
        }

    }

    @Override
    public ResponsePatientDto deletePatient(int idPatient) {
        return null;
    }



    @Override
    public ResponsePatientDto updatePatient(HttpServletRequest request){

        JsonObject jsonObject;
        JsonObject respuesta = new JsonObject();
        Gson gson = new Gson();
        IPatientDao patientDao = new PatientDao();

        IPatientService patientService = new PatientService();

        Date birthdayParameter = null;

        PatientEntity patient = new PatientEntity();

        if (request.getParameter("idPatient") != null){
            patient.setId_user(Integer.parseInt(request.getParameter("id_patient")));
        }
        if (request.getParameter("dpi") != null){
            patient.setDpi(Integer.parseInt(request.getParameter("dpi")));
        }
        if (request.getParameter("nit") != null){
            patient.setNit(request.getParameter("nit"));
        }
        if (request.getParameter("birthday")!=null){
            try {
                birthdayParameter = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("birthday"));
                patient.setBirthdate(birthdayParameter);
            } catch (ParseException e) {
                return new ResponsePatientDto("La fecha es invalida");
            }
        }
        if (request.getParameter("gender") != null)
        patient.setGender(request.getParameter("gender").charAt(0));
        if (request.getParameter("fullName") != null)
        patient.setFullName(request.getParameter("fullName"));
        if (request.getParameter("surName") != null)
        patient.setSurName(request.getParameter("surName"));
        if (request.getParameter("address") != null)
        patient.setAddress(request.getParameter("address"));
        if (request.getParameter("phone") != null)
        patient.setPhone(Integer.parseInt(request.getParameter("phone")));
        if (request.getParameter("emergencyContact") != null)
        patient.setEmergencyContact(Integer.parseInt(request.getParameter("emergencyContact")));

        int  patientlocal;
        try {
            patientlocal = patientDao.updatePatient(patient);
        } catch (SQLException ex) {
                return new ResponsePatientDto(SQL_ERROR_QUERY);
        }
        if (patientlocal == 0) {
            return new ResponsePatientDto(SQL_UPDATE_ERROR_PATIENT);
        }
        else{
            respuesta.addProperty("stateCorrect","true");
            return new ResponsePatientDto(true);
        }

    }

    @Override
    public ResponsePatientDto getPatientById(int id) {

        JsonObject jsonObject;
        JsonObject respuesta = new JsonObject();
        Gson gson = new Gson();
        IPatientDao patientDao = new PatientDao();
        PatientEntity  patient = null;


        try {
            patient = patientDao.getPatientById(id);
        } catch (SQLException throwables) {
            return new ResponsePatientDto(SQL_ERROR_QUERY);
        }

        if (patient == null){
            return new ResponsePatientDto(SQL_NOT_PATIETN);
        }
        else{
            String json = gson.toJson(patient);
            jsonObject = new JsonParser().parse(json).getAsJsonObject();

            return new ResponsePatientDto(true,patient);
        }

    }
}
