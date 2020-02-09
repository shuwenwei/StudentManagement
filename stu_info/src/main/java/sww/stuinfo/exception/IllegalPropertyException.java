package sww.stuinfo.exception;

public class IllegalPropertyException extends RuntimeException {

    private String fieldMessage;

    public IllegalPropertyException(String fieldMessage){
        this.fieldMessage = fieldMessage;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }
}
