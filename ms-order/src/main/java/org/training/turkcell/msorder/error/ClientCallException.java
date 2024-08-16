package org.training.turkcell.msorder.error;

import lombok.Data;
import lombok.Getter;


public class ClientCallException extends RuntimeException {
    @Getter
    private ErrorObj errorObj;

    public ClientCallException() {
    }

    public ClientCallException(final ErrorObj errorObjParam) {
        errorObj = errorObjParam;
    }
}
