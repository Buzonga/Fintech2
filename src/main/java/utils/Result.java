package utils;

public class Result<T> {

    private String message;
    private T data;
    private boolean isSuccess;

    public Result() {}

    public Result(String message, T data, boolean isSucess) {
        this.message = message;
        this.data = data;
        this.isSuccess = isSucess;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> SuccessResponse(String message, T data) {
        return new Result<T>(message, data, true);
    }

    public Result<T> FailureResponse(String message) {
        return new Result<>(message, null, false);
    }
}
