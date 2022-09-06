package demo.csod.securitydemo.csod.spring_security.exception;

public class ResourceNotFound extends RuntimeException {

    private String errorMessage;
    private String resourceId;
    private String errorDetail;

    public ResourceNotFound(String resourcename, String resourceId, String resource) {
        this.errorMessage = resourcename;
        this.resourceId = resourceId;
        this.errorDetail = resource;
    }
}
