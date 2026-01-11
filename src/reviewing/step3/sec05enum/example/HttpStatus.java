package reviewing.step3.sec05enum.example;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int status, String message) {
        this.code = status;
        this.message = message;
    }

    // 코드로 Enum 상수 찾기
    public static HttpStatus findByCode(int code) {
        HttpStatus[] values = values();
        for (HttpStatus status : values) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    // 성공 범위(200~299) 체크
    public boolean isSuccess() {
        return this.code >= 200 && code < 300 ;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
