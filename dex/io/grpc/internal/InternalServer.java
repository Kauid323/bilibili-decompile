package io.grpc.internal;

import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.List;
import javax.annotation.Nullable;

public interface InternalServer {
    SocketAddress getListenSocketAddress();

    List<? extends SocketAddress> getListenSocketAddresses();

    @Nullable
    InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats();

    @Nullable
    List<InternalInstrumented<InternalChannelz.SocketStats>> getListenSocketStatsList();

    void shutdown();

    void start(ServerListener serverListener) throws IOException;
}