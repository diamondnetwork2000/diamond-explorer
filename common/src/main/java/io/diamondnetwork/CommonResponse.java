package io.diamondnetwork;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
@Accessors(chain = true)
public class CommonResponse<T> {
    protected int statusCode; //0: ok
    protected String errorMessage;
    protected T content;
    protected Long timestamp; // unixstamp


    public CommonResponse(int statusCode){
        this.statusCode = statusCode;
        this.timestamp = System.currentTimeMillis() / 1000l;
    }

    public CommonResponse(int statusCode, String errorMessage){
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.timestamp = System.currentTimeMillis() / 1000l;
    }

    public CommonResponse(T content) {
        this.statusCode = 0;
        this.content = content;
        this.timestamp = System.currentTimeMillis() / 1000l;
    }

    public CommonResponse() {
        this.timestamp = System.currentTimeMillis() / 1000l;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
