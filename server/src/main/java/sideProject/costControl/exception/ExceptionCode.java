package sideProject.costControl.exception;

import lombok.Getter;

public enum ExceptionCode {

    // 400 Error
    GENERAL_ERROR(400, "Data error, please try again"),

    // 401 Error
    MEMBER_UNAUTHORIZED(401, "UNAUTHORIZED"),
    ACCESS_DENIED(401, "Access Denied"),

    // 403 Error
    REQUEST_FORBIDDEN(403,"Request forbidden"),

    // 404 Error
    USER_NOT_FOUND(404, "User not found"),
    NOT_FOUND_EXCEPTION(404, "Not found"),

    // 409 Error
    USER_EXISTS(409, "User exists"),
    CURRENT_PASSWORD_NOT_MATCH(409, "Current password is not match"),
    NEXT_PASSWORD_NOT_MATCH(409, "Next password is not match"),

    // 501  Error
    NOT_IMPLEMENTATION(501, "Not Implementation");



    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
