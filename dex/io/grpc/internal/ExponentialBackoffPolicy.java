package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class ExponentialBackoffPolicy implements BackoffPolicy {
    private Random random = new Random();
    private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1);
    private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2);
    private double multiplier = 1.6d;
    private double jitter = 0.2d;
    private long nextBackoffNanos = this.initialBackoffNanos;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Provider implements BackoffPolicy.Provider {
        @Override // io.grpc.internal.BackoffPolicy.Provider
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    @Override // io.grpc.internal.BackoffPolicy
    public long nextBackoffNanos() {
        long currentBackoffNanos = this.nextBackoffNanos;
        this.nextBackoffNanos = Math.min((long) (currentBackoffNanos * this.multiplier), this.maxBackoffNanos);
        return uniformRandom((-this.jitter) * currentBackoffNanos, this.jitter * currentBackoffNanos) + currentBackoffNanos;
    }

    private long uniformRandom(double low, double high) {
        Preconditions.checkArgument(high >= low);
        double mag = high - low;
        return (long) ((this.random.nextDouble() * mag) + low);
    }

    ExponentialBackoffPolicy setRandom(Random random) {
        this.random = random;
        return this;
    }

    ExponentialBackoffPolicy setInitialBackoffNanos(long initialBackoffNanos) {
        this.initialBackoffNanos = initialBackoffNanos;
        return this;
    }

    ExponentialBackoffPolicy setMaxBackoffNanos(long maxBackoffNanos) {
        this.maxBackoffNanos = maxBackoffNanos;
        return this;
    }

    ExponentialBackoffPolicy setMultiplier(double multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    ExponentialBackoffPolicy setJitter(double jitter) {
        this.jitter = jitter;
        return this;
    }
}