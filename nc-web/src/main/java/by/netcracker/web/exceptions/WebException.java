package by.netcracker.web.exceptions;

import by.netcracker.serv.exceptions.ServErrorCode;

/**
 * Created by ilya on 4/8/15.
 */
public class WebException extends Exception {

    private WebErrorCode code;
    private Object[] params;
    private String message;

    public WebException(Throwable t, WebErrorCode code, Object... params) {
        super(t);
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public WebException(WebErrorCode code, Object... params) {
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public WebErrorCode getCode() {
        return code;
    }

    public void setCode(WebErrorCode code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
