package org.training.turkcell.msorder.order.rest.models;

public class Response<T> {
    private T responseObject;
    private boolean errorOccurred;
    private String errorDesc;
    private Integer errorCode;
    private Integer errorCause;

}
