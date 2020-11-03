package gt.com.model.dto;

public class ResponseDto {

    private String errorMessage;
    private Object data;

    public ResponseDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseDto(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
