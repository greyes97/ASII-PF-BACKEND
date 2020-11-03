package gt.com.controller;

import gt.com.model.entity.UserEntity;
import gt.com.model.dto.ResponseLoginDto;
import gt.com.model.service.IUserService;
import gt.com.model.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import static gt.com.model.propertiesApp.MessagesErrorApp.*;

@RestController
public class LoginController {

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseLoginDto loginControl(HttpServletRequest request)
            throws Exception {
        IUserService userService = new UserService();
        return  userService.validateUser(request);
    }

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseLoginDto loginControlGet(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if (session != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setIdUser(Integer.parseInt(session.getAttribute("idUser").toString()));
            userEntity.setFullName(session.getAttribute("userName").toString());
            return new ResponseLoginDto(userEntity,true);
        }else {
            return new ResponseLoginDto(SIG_IN_ERROR);
        }
    }

    @PutMapping(value = "/login", produces = "application/json")
    public ResponseLoginDto logingControlPut(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if (session != null) {
            if (request.getParameter("status").equals("false")){
                session.removeAttribute("userName");
                session.removeAttribute("idUser");
                session.removeAttribute("status");
                session.invalidate();
                return new ResponseLoginDto(LOG_OUT_SUCCESS,true);
            }else{
                return new ResponseLoginDto(LOG_OUT_ERROR);
            }
        }else {
            return new ResponseLoginDto(SIG_IN_ERROR);
        }
    }

}
