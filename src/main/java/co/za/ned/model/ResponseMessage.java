package co.za.ned.model;



public class ResponseMessage {
    int statusCode;
    String statusMessage;
    String responseMessage;

    public ResponseMessage() {
    }

    public ResponseMessage(int statusCode, String statusMessage, String responseMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.responseMessage = responseMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
