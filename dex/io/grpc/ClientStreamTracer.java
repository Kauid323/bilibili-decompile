package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public abstract class ClientStreamTracer extends StreamTracer {
    public void outboundHeaders() {
    }

    public void inboundHeaders() {
    }

    public void inboundTrailers(Metadata trailers) {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Factory {
        @Deprecated
        public ClientStreamTracer newClientStreamTracer(CallOptions callOptions, Metadata headers) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ClientStreamTracer newClientStreamTracer(StreamInfo info, Metadata headers) {
            return newClientStreamTracer(info.getCallOptions(), headers);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class StreamInfo {
        private final CallOptions callOptions;
        private final Attributes transportAttrs;

        StreamInfo(Attributes transportAttrs, CallOptions callOptions) {
            this.transportAttrs = (Attributes) Preconditions.checkNotNull(transportAttrs, "transportAttrs");
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
        }

        public Attributes getTransportAttrs() {
            return this.transportAttrs;
        }

        public CallOptions getCallOptions() {
            return this.callOptions;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setTransportAttrs(this.transportAttrs);
            builder.setCallOptions(this.callOptions);
            return builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("transportAttrs", this.transportAttrs).add("callOptions", this.callOptions).toString();
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private Attributes transportAttrs = Attributes.EMPTY;
            private CallOptions callOptions = CallOptions.DEFAULT;

            Builder() {
            }

            public Builder setTransportAttrs(Attributes transportAttrs) {
                this.transportAttrs = (Attributes) Preconditions.checkNotNull(transportAttrs, "transportAttrs cannot be null");
                return this;
            }

            public Builder setCallOptions(CallOptions callOptions) {
                this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions cannot be null");
                return this;
            }

            public StreamInfo build() {
                return new StreamInfo(this.transportAttrs, this.callOptions);
            }
        }
    }
}