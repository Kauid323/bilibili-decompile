package io.grpc;

public final class InsecureServerCredentials extends ServerCredentials {
    public static ServerCredentials create() {
        return new InsecureServerCredentials();
    }

    private InsecureServerCredentials() {
    }
}