package org.training.turkcell.msorder.error;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String         errorDesc;
    private Integer        errorCode;

    public ErrorObj() {
    }

    @Builder(setterPrefix = "with")
    public ErrorObj(final List<ErrorObj> subErrors,
                    final String errorDesc,
                    final Integer errorCode) {
        this.subErrors = subErrors;
        this.errorDesc = errorDesc;
        this.errorCode = errorCode;
    }

    public static void main(String[] args) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setErrorDesc("osman");
        System.out.println("test");
        errorObjLoc.setErrorCode(100);

        ErrorObj errorObjLoc2 = ErrorObj.builder()
                                        .withErrorDesc("osman")
                                        .withErrorCode(100)
                                        .build();


    }
}
