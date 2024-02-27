package cln.rhy.exception;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectOutputStream;

@Data
public class BaseRuntimeException extends RuntimeException {
    private Throwable cause = null;
    private String errorCode = null;

    static final long serialVersionUID = 0L;

    public BaseRuntimeException() {}

    public BaseRuntimeException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String errorCode, String msg, Throwable cause) {
        super(msg);
        this.errorCode = errorCode;
        this.cause = cause;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getExceptionMessage() {
        if (super.getMessage() != null)
            return super.getMessage();
        if (this.cause != null) {
            return this.cause.toString();
        }
        return null;
    }

    public String getMessage() {
        if (StringUtils.hasText(this.errorCode))
            return super.getMessage();
        return getExceptionMessage();
    }

    public String getMessage(int index) {
        if (index == 0) {
            return super.getMessage();
        }
        return this.getMessage(index);
    }


}
