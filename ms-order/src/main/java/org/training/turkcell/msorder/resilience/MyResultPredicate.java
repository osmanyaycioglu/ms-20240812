package org.training.turkcell.msorder.resilience;

import org.training.turkcell.msorder.integration.payment.models.PaymentResponse;

import java.util.function.Predicate;

public class MyResultPredicate implements Predicate<PaymentResponse> {
    @Override
    public boolean test(final PaymentResponse paymentResponseParam) {
        System.out.println("Response predicate : " + paymentResponseParam);
        if (!paymentResponseParam.getSuccess()){
            return true;
        }
        return false;
    }
}
