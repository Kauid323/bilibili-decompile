package io.grpc.internal;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public interface TransportProvider {
    @Nullable
    ClientTransport obtainActiveTransport();
}