package gt.com.controller;

import gt.com.model.dto.ResponseLoginDto;
import gt.com.model.service.IUserService;
import gt.com.model.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @CrossOrigin( origins = "https://mymedicalcenter.netlify.app")
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseLoginDto loginControl(HttpServletRequest request) throws Exception {
        IUserService userService = new UserService();
        return  userService.validateUser(request);
    }
}
