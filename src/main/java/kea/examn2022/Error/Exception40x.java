package kea.examn2022.Error;

import org.springframework.http.HttpStatus;

public class Exception40x extends RuntimeException {
    HttpStatus httpsStatus;

    public Exception40x(String message){
        super(message);
        this.httpsStatus = HttpStatus.BAD_REQUEST;
    }

    public Exception40x(String messageg, HttpStatus httpsStatus){
        super(messageg);
        this.httpsStatus = httpsStatus;
    }
}
