package org.training.turkcell.msorder.resilience;

import java.util.function.Predicate;

public class MyRetryPredicate implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable throwableParam) {
        System.out.println("Retry predicate çaıştı : " + throwableParam.getClass()
                                                                       .getName());
        return true;
    }
}
