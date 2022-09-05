package demo.csod.securitydemo.csod.spring_security.exception;

public class ResourceNotFound extends RuntimeException{

    private String errorMessage;
    private String errorDetail;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public ResourceNotFound(String errorMessage, String errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public ResourceNotFound() {
    }
}
