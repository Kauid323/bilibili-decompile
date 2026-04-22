package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.stub.ClientCalls;

public final class InternalClientCalls {
    public static CallOptions.Key<ClientCalls.StubType> getStubTypeOption() {
        return ClientCalls.STUB_TYPE_OPTION;
    }

    public static StubType getStubType(CallOptions callOptions) {
        return StubType.of((ClientCalls.StubType) callOptions.getOption(ClientCalls.STUB_TYPE_OPTION));
    }

    public static CallOptions setStubType(CallOptions callOptions, StubType stubType) {
        return callOptions.withOption(ClientCalls.STUB_TYPE_OPTION, stubType.internalType);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum StubType {
        BLOCKING(ClientCalls.StubType.BLOCKING),
        ASYNC(ClientCalls.StubType.ASYNC),
        FUTURE(ClientCalls.StubType.FUTURE);
        
        private final ClientCalls.StubType internalType;

        StubType(ClientCalls.StubType internalType) {
            this.internalType = internalType;
        }

        public static StubType of(ClientCalls.StubType internal) {
            StubType[] values;
            for (StubType value : values()) {
                if (value.internalType == internal) {
                    return value;
                }
            }
            throw new AssertionError("Unknown StubType: " + internal.name());
        }
    }
}