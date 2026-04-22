package io.grpc;

import com.google.common.base.Preconditions;

public final class ConnectivityStateInfo {
    private final ConnectivityState state;
    private final Status status;

    public static ConnectivityStateInfo forNonError(ConnectivityState state) {
        Preconditions.checkArgument(state != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new ConnectivityStateInfo(state, Status.OK);
    }

    public static ConnectivityStateInfo forTransientFailure(Status error) {
        Preconditions.checkArgument(!error.isOk(), "The error status must not be OK");
        return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, error);
    }

    public ConnectivityState getState() {
        return this.state;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (other instanceof ConnectivityStateInfo) {
            ConnectivityStateInfo o = (ConnectivityStateInfo) other;
            return this.state.equals(o.state) && this.status.equals(o.status);
        }
        return false;
    }

    public int hashCode() {
        return this.state.hashCode() ^ this.status.hashCode();
    }

    public String toString() {
        if (this.status.isOk()) {
            return this.state.toString();
        }
        return this.state + "(" + this.status + ")";
    }

    private ConnectivityStateInfo(ConnectivityState state, Status status) {
        this.state = (ConnectivityState) Preconditions.checkNotNull(state, "state is null");
        this.status = (Status) Preconditions.checkNotNull(status, "status is null");
    }
}