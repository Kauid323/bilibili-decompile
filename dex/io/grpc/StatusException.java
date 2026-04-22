package io.grpc;

import javax.annotation.Nullable;

public class StatusException extends Exception {
    private static final long serialVersionUID = -660954903976144640L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final Metadata trailers;

    public StatusException(Status status) {
        this(status, null);
    }

    public StatusException(Status status, @Nullable Metadata trailers) {
        this(status, trailers, true);
    }

    StatusException(Status status, @Nullable Metadata trailers, boolean fillInStackTrace) {
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

    public final Metadata getTrailers() {
        return this.trailers;
    }
}