package cln.rhy.exception;


public class ServiceException extends BaseRuntimeException {

    public ServiceException(String errorCode) {
        super(errorCode);
    }

    public ServiceException(String errorCode, String message) {
        super(errorCode, message);
    }

    public ServiceException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
