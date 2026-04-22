package io.grpc.inprocess;

public class InternalInProcessServerBuilder {
    public static void setStatsEnabled(InProcessServerBuilder builder, boolean value) {
        builder.setStatsEnabled(value);
    }

    private InternalInProcessServerBuilder() {
    }
}