package gt.com.model.propertiesApp;

public final class ConfigurationApp {

    public static final String QUERY_LOGIN = "select ";
    public static final String QUERY_PATIENTS_ADD = "";
    public static final String QUERY_PATIENTS_DELETE = "";
    public static final String QUERY_PATIENTS_READ = "";
    public static final String QUERY_PATIENTS_UPDATE ="UPDATE patients set dpi = ?,nit = ?,birthday = ?,gender = ?,fullName = ?,surName = ?,address = ?,phone = ?,emergencyContact = ?  WHERE idPatient = ? ;";
    public static final String QUERY_ROOM_READ = "";
    public static final String QUERY_ROOM_UPDATE = "";
}
