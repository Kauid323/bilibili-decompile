package io.grpc;

import javax.annotation.Nullable;

public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final Metadata trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public StatusRuntimeException(Status status, @Nullable Metadata trailers) {
        this(status, trailers, true);
    }

    StatusRuntimeException(Status status, @Nullable Metadata trailers, boolean fillInStackTrace) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = trailers;
        this.fillInStackTrace = fillInStackTrace;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.fillInStackTrace ? super.fillInStackTrace() : this;
    }

    public final Status getStatus() {
        return this.status;
    }

    @Nullable
    public final Metadata getTrailers() {
        return this.trailers;
    }
}