package gt.com.model.dto;

import com.google.gson.JsonObject;
import gt.com.model.entity.PatientEntity;

import java.util.List;

public class ResponsePatientDto{

    private String errorMessage;
    private List<PatientEntity> responsePatient;
    private boolean statusPatient;
    private Object responsePatientObject;

    //constructor para getpatients

    public ResponsePatientDto(List<PatientEntity> responsePatient, boolean statusPatient) {
        this.responsePatient = responsePatient;
        this.statusPatient = statusPatient;
    }

    //constructor para errormessage

    public ResponsePatientDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    //constructor para savepatient and delete

    public ResponsePatientDto(boolean statusPatient) {
        this.statusPatient = statusPatient;
    }

    //constructor para updatepatient

    public ResponsePatientDto(boolean statusPatient, Object responsePatientObject) {
        this.statusPatient = statusPatient;
        this.responsePatientObject = responsePatientObject;
    }


    //getters and setters

    public List<PatientEntity> getResponsePatient() {
        return responsePatient;
    }

    public void setResponsePatient(List<PatientEntity> responsePatient) {
        this.responsePatient = responsePatient;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
