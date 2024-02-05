package cn.wophy.exception;

public class ExcelTemplateException extends RuntimeException {


    public ExcelTemplateException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ExcelTemplateException(String message) {
        super(message);
    }

    public ExcelTemplateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
