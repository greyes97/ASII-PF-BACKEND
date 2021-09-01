package gt.com.controller;

import gt.com.model.dto.ResponseLoginDto;
import gt.com.model.service.IUserService;
import gt.com.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @CrossOrigin( origins = "http://localhost:3333")
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseLoginDto loginControl(HttpServletRequest request) throws Exception {
        IUserService userService = new UserService();
        return  userService.validateUser(request);
    }
}
