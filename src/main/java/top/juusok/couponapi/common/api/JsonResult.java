package top.juusok.couponapi.common.api;

public class JsonResult<T> {

    private T data;
    private int status;
    private String message;

    public JsonResult(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public JsonResult() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
    	return status;
    }
    
    public void setStatus(int status) {
    	this.status = status;
    }
}
