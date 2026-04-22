package rx.internal.util;

import java.util.concurrent.CountDownLatch;
import rx.Subscription;

public final class BlockingUtils {
    private BlockingUtils() {
    }

    public static void awaitForComplete(CountDownLatch latch, Subscription subscription) {
        if (latch.getCount() == 0) {
            return;
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            subscription.unsubscribe();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
        }
    }
}