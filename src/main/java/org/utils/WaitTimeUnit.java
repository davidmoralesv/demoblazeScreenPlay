package org.utils;

import java.util.concurrent.TimeUnit;

public class WaitTimeUnit {
    private final TimeUnit timeUnit;

    public WaitTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void waiting(long tiempo) {
        try {
            timeUnit.sleep(tiempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
