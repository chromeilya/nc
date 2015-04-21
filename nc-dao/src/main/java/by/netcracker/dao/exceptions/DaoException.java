package by.netcracker.dao.exceptions;

/**
 * Create custom exception on dao layer.
 * @author Hromenkov Ilya
 * @version 1.0
 */
public class DaoException extends Exception {

    private DaoErrorCode code;
    private Object[] params;
    private String message;

    public DaoException(Throwable t, DaoErrorCode code, Object... params) {
        super(t);
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public DaoErrorCode getCode() {
        return code;
    }

    public void setCode(DaoErrorCode code) {
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
