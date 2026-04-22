package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.ktor.http.ContentDisposition;
import java.net.SocketAddress;

public final class InProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -2803441206326023474L;
    private final String name;

    public InProcessSocketAddress(String name) {
        this.name = (String) Preconditions.checkNotNull(name, ContentDisposition.Parameters.Name);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InProcessSocketAddress)) {
            return false;
        }
        return this.name.equals(((InProcessSocketAddress) obj).name);
    }
}