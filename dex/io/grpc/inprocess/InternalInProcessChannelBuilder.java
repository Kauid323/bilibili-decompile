package io.grpc.inprocess;

public final class InternalInProcessChannelBuilder {
    public static void setStatsEnabled(InProcessChannelBuilder builder, boolean value) {
        builder.setStatsEnabled(value);
    }

    private InternalInProcessChannelBuilder() {
    }
}