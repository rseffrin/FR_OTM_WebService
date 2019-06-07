package br.com.frimesa.ws.exceptions;

/*
 os codigos referenciados para cada erro foram selecionados conforme os codigo da classe Response.Status. Exemplo:
 Response.Status.FORBIDDEN.getStatusCode()
 Response.Status.CONFLICT.getStatusCode()
 Response.Status.BAD_REQUEST.getStatusCode()
 * */
 

public enum ErrorCode {

    BAD_REQUEST(400),
    NOT_FOUND(404),
    CONFLICT(409),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    SERVER_ERROR(500);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
