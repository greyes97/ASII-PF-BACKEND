package gt.com.model.dao;


import gt.com.model.entity.PatientEntity;
import gt.com.model.entity.UserEntity;

import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public interface IPatientDao {

    public boolean savePatient(PatientEntity patient) throws SQLException;

    public List<PatientEntity> getPacients() throws SQLException;

    public int updatePatient(PatientEntity patient) throws SQLException;


}