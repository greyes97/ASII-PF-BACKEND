package gt.com.model.service;


import com.google.gson.JsonObject;

import gt.com.model.dao.IUserDao;
import gt.com.model.dao.UserDao;
import gt.com.model.entity.UserEntity;
import static gt.com.model.propertiesApp.MessagesErrorApp.*;
import gt.com.model.dto.ResponseLoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class UserService implements IUserService {

    /***
     * this method validates if the user have access to the application
     * @param request this param contains the email and password
     * @return the ResponseLoginDto function is, give information to front end.
     */
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
            return new ResponseLoginDto(SQL_TIME_OUT,false,3);
        }
        if (user != null) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {

                respuesta.addProperty("userName", user.getFullName());
                respuesta.addProperty("idUser", user.getIdUser());
                respuesta.addProperty("role",user.getRole());

                return new ResponseLoginDto(SUCCESS,respuesta,true,1);

            } else {
                return new ResponseLoginDto(SQL_NOT_USER,false,2);
            }
        } else {
            return new ResponseLoginDto(SERVICE_JSON_FAIL,false,3);
        }


    }


}
