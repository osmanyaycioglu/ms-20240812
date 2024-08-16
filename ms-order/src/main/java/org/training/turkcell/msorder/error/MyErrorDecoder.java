package org.training.turkcell.msorder.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String sParam,
                            final Response responseParam) {
        int           statusLoc       = responseParam.status();
        Response.Body bodyLoc         = responseParam.body();
        ObjectMapper  objectMapperLoc = new ObjectMapper();
        try {
            ErrorObj errorObjLoc = objectMapperLoc.readValue(bodyLoc.asInputStream(),
                                                             ErrorObj.class);

            return new ClientCallException(errorObjLoc);
        } catch (Exception eParam) {
            throw new ClientCallException();
        }
    }

}
