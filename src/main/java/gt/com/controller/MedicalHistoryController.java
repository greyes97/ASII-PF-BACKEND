package gt.com.controller;

import gt.com.model.dto.ResponseGenericDto;
import gt.com.model.service.IMedicalHistoryService;
import gt.com.model.service.MedicalHistoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
public class MedicalHistoryController {

    @CrossOrigin( origins = "http://localhost:3333")
    @GetMapping(value = "/medicalHistory", produces = "application/json")
    public ResponseGenericDto getHistoryByPatient(HttpServletRequest request) throws SQLException {
        IMedicalHistoryService medicalHistory = new MedicalHistoryService();

        return medicalHistory.getMedicalHistory(request);
    }
}
