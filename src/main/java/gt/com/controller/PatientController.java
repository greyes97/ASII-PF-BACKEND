package gt.com.controller;

import gt.com.model.entity.PatientEntity;
import gt.com.model.dto.ResponsePatientDto;
import gt.com.model.dto.ResponseDto;

import gt.com.model.service.IPatientService;
import gt.com.model.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PatientController {

    @GetMapping(value = "/patient", produces = "application/json")
    public ResponsePatientDto readPatient(HttpServletRequest request){
        IPatientService patientService = new PatientService();
        return patientService.getPatients();
    }

    @PostMapping(value = "/patient", produces = "application/json")
    public ResponseDto savePatient(HttpServletRequest request) {
        IPatientService patientService = new PatientService();
        Date birthdayParameter = null;
        try {
            birthdayParameter = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            return new ResponseDto("La fecha es invalida");
        }
        PatientEntity patient = new PatientEntity();
        patient.setDpi(Integer.parseInt(request.getParameter("dpi")));
        patient.setNit(request.getParameter("nit"));
        patient.setBirthdate(birthdayParameter);
        patient.setGender(request.getParameter("gender").charAt(0));
        patient.setFullName(request.getParameter("fullName"));
        patient.setSurName(request.getParameter("surName"));
        patient.setAddress(request.getParameter("address"));
        patient.setPhone(Integer.parseInt(request.getParameter("phone")));
        patient.setEmergencyContact(Integer.parseInt(request.getParameter("emergencyContact")));

        try {
            return new ResponseDto(patientService.savePatient(patient));
        } catch (Exception e) {
            return  new ResponseDto(e.getMessage());
        }

    }

    @PutMapping(value = "/patient", produces = "application/json")
    public ResponseDto updatePatientInfo(HttpServletRequest request) {
        IPatientService patientService = new PatientService();

        try {
            return new ResponseDto(patientService.updatePatient(request));
        } catch (Exception e) {
            return  new ResponseDto(e.getMessage());
        }
    }

}
