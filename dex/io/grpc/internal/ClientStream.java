package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import javax.annotation.Nonnull;

public interface ClientStream extends Stream {
    void appendTimeoutInsight(InsightBuilder insightBuilder);

    void cancel(Status status);

    Attributes getAttributes();

    void halfClose();

    void setAuthority(String str);

    void setDeadline(@Nonnull Deadline deadline);

    void setDecompressorRegistry(DecompressorRegistry decompressorRegistry);

    void setFullStreamDecompression(boolean z);

    void setMaxInboundMessageSize(int i2);

    void setMaxOutboundMessageSize(int i2);

    void start(ClientStreamListener clientStreamListener);
}