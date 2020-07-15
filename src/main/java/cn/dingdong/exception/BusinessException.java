package cn.dingdong.exception;

/**
 * Business exception class
 */
public class BusinessException extends RuntimeException {
    /**
     * Error code
     */
    private final String errorCode;

    /**
     * Error Data, save complex object.
     */
    private final transient Object errorData;

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorData = null;
    }

    public BusinessException(String errorCode, Object errorData, Throwable cause) {
        super("", cause);
        this.errorCode = errorCode;
        this.errorData = errorData;
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorData = null;
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = null;
        this.errorData = null;
    }
    
    public BusinessException(String errorCode, Object errorData) {
        super("");
        this.errorCode = errorCode;
        this.errorData = errorData;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Object getErrorData() {
        return errorData;
    }
}
