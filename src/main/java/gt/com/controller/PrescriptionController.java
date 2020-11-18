package gt.com.controller;

import gt.com.model.dto.ResponseGenericDto;
import gt.com.model.service.IPrescriptionService;
import gt.com.model.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class PrescriptionController {

    @CrossOrigin( origins = "https://mymedicalcenter.netlify.app")
    @GetMapping(value = "/prescription", produces = "application/json")
    public ResponseGenericDto getPrescriptions(HttpServletRequest request){
        IPrescriptionService prescriptionService = new PrescriptionService();

        return prescriptionService.getPrescriptions(request);
    }

    @CrossOrigin( origins = "https://mymedicalcenter.netlify.app")
    @PostMapping(value = "/prescription", produces = "application/json")
    public ResponseGenericDto savePrescriptions(HttpServletRequest request){
        IPrescriptionService prescriptionService = new PrescriptionService();

        return prescriptionService.savePrescription(request);
    }

}
