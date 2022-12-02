package model.exceptions;

public class ValidationException extends Exception{
    private String fieldName;
    private String fieldError;

    public  ValidationException(String fieldName, String fieldError){
        super();
        this.fieldError = fieldError;
        this.fieldName = fieldName;
    }

    @Override
    public String getMessage() {
        return this.fieldName+" - "+this.fieldError;
    }
}
