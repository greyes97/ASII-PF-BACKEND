package gt.com.model.dao;

import gt.com.model.entity.UserEntity;

import java.sql.SQLException;
import java.util.*;

public interface IUserDao {

    public UserEntity getUser(String gmail, String password) throws SQLException;

}