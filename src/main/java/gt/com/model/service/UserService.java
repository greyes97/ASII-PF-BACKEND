package gt.com.model.service;


import com.google.gson.JsonObject;
import gt.com.model.dao.IUserDao;
import gt.com.model.dao.UserDao;
import gt.com.model.entity.UserEntity;
import static gt.com.model.propertiesApp.ConfigurationApp.*;
import static gt.com.model.propertiesApp.MessagesErrorApp.*;
import gt.com.model.dto.ResponseLoginDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class UserService implements IUserService {

    @Override
    public ResponseLoginDto validateUser(HttpServletRequest request) {
        JsonObject respuesta = new JsonObject();
        IUserDao userDao = new UserDao();
        UserEntity user;
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        try {
            user = userDao.getUser(email, password);
        } catch (SQLException throwables) {
            return new ResponseLoginDto(SQL_TIME_OUT);
        }

        if (user != null) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {

                HttpSession session = request.getSession();
                //creando JsonElement
                respuesta.addProperty("userName", user.getFullName());
                respuesta.addProperty("idUser", user.getIdUser());
                //creando variable de session
                session.setAttribute("status","true");
                session.setAttribute("userName",user.getFullName());
                session.setAttribute("idUser",user.getIdUser());
                return new ResponseLoginDto(respuesta,true);

            } else {
                return new ResponseLoginDto(SQL_NOT_USER);
            }
        } else {
            return new ResponseLoginDto(SERVICE_JSON_FAIL);
        }


    }
}
