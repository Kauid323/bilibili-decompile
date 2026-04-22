package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
public final class RetryPolicy {
    final double backoffMultiplier;
    final long initialBackoffNanos;
    final int maxAttempts;
    final long maxBackoffNanos;
    final Set<Status.Code> retryableStatusCodes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryPolicy(int maxAttempts, long initialBackoffNanos, long maxBackoffNanos, double backoffMultiplier, @Nonnull Set<Status.Code> retryableStatusCodes) {
        this.maxAttempts = maxAttempts;
        this.initialBackoffNanos = initialBackoffNanos;
        this.maxBackoffNanos = maxBackoffNanos;
        this.backoffMultiplier = backoffMultiplier;
        this.retryableStatusCodes = ImmutableSet.copyOf(retryableStatusCodes);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.maxAttempts), Long.valueOf(this.initialBackoffNanos), Long.valueOf(this.maxBackoffNanos), Double.valueOf(this.backoffMultiplier), this.retryableStatusCodes});
    }

    public boolean equals(Object other) {
        if (other instanceof RetryPolicy) {
            RetryPolicy that = (RetryPolicy) other;
            return this.maxAttempts == that.maxAttempts && this.initialBackoffNanos == that.initialBackoffNanos && this.maxBackoffNanos == that.maxBackoffNanos && Double.compare(this.backoffMultiplier, that.backoffMultiplier) == 0 && Objects.equal(this.retryableStatusCodes, that.retryableStatusCodes);
        }
        return false;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.maxAttempts).add("initialBackoffNanos", this.initialBackoffNanos).add("maxBackoffNanos", this.maxBackoffNanos).add("backoffMultiplier", this.backoffMultiplier).add("retryableStatusCodes", this.retryableStatusCodes).toString();
    }
}