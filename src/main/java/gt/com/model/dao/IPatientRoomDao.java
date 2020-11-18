package gt.com.model.dao;


import gt.com.model.dto.ResponseDto;
import gt.com.model.entity.PatientRoomEntity;
import gt.com.model.entity.RoomEntity;

import java.sql.SQLException;
import java.util.List;

public interface IPatientRoomDao {

    public boolean savePatientRoom(PatientRoomEntity patient) throws SQLException;
    public int updatePatientRoom(int idPatient, boolean status) throws SQLException;
    public List<RoomEntity> getRoomsPatient(int idPatient, boolean status) throws SQLException;

}
