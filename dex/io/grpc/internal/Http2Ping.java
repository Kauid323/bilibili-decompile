package io.grpc.internal;

import com.google.common.base.Stopwatch;
import io.grpc.internal.ClientTransport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Http2Ping {
    private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
    private Map<ClientTransport.PingCallback, Executor> callbacks = new LinkedHashMap();
    private boolean completed;
    private final long data;
    private Throwable failureCause;
    private long roundTripTimeNanos;
    private final Stopwatch stopwatch;

    public Http2Ping(long data, Stopwatch stopwatch) {
        this.data = data;
        this.stopwatch = stopwatch;
    }

    public void addCallback(ClientTransport.PingCallback callback, Executor executor) {
        synchronized (this) {
            if (!this.completed) {
                this.callbacks.put(callback, executor);
                return;
            }
            Runnable runnable = this.failureCause != null ? asRunnable(callback, this.failureCause) : asRunnable(callback, this.roundTripTimeNanos);
            doExecute(executor, runnable);
        }
    }

    public long payload() {
        return this.data;
    }

    public boolean complete() {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            long roundTripTimeNanos = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
            this.roundTripTimeNanos = roundTripTimeNanos;
            Map<ClientTransport.PingCallback, Executor> callbacks = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : callbacks.entrySet()) {
                doExecute(entry.getValue(), asRunnable(entry.getKey(), roundTripTimeNanos));
            }
            return true;
        }
    }

    public void failed(Throwable failureCause) {
        synchronized (this) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            this.failureCause = failureCause;
            Map<ClientTransport.PingCallback, Executor> callbacks = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : callbacks.entrySet()) {
                notifyFailed(entry.getKey(), entry.getValue(), failureCause);
            }
        }
    }

    public static void notifyFailed(ClientTransport.PingCallback callback, Executor executor, Throwable cause) {
        doExecute(executor, asRunnable(callback, cause));
    }

    private static void doExecute(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback callback, final long roundTripTimeNanos) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.1
            @Override // java.lang.Runnable
            public void run() {
                ClientTransport.PingCallback.this.onSuccess(roundTripTimeNanos);
            }
        };
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback callback, final Throwable failureCause) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.2
            @Override // java.lang.Runnable
            public void run() {
                ClientTransport.PingCallback.this.onFailure(failureCause);
            }
        };
    }
}