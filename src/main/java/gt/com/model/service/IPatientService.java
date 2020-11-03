package gt.com.model.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gt.com.model.entity.PatientEntity;
import gt.com.model.dto.ResponsePatientDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPatientService {

    public ResponsePatientDto getPatients();
    public ResponsePatientDto savePatient(PatientEntity patient) throws Exception;
    public ResponsePatientDto deletePatient(int idPatient);
    public ResponsePatientDto updatePatient(HttpServletRequest request);

}
