package gt.com.model.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gt.com.model.entity.UserEntity;

public class ResponseLoginDto {

    private String errorMessage;
    private Object jsonResponse;
    private boolean statusLogin;

    public ResponseLoginDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseLoginDto(Object jsonResponse, boolean statusLogin) {
        this.jsonResponse = jsonResponse;
        this.statusLogin = statusLogin;
    }

    public boolean isStatusLogin() {
        return statusLogin;
    }
    public void setStatusLogin(boolean statusLogin) {
        this.statusLogin = statusLogin;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(Object jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
