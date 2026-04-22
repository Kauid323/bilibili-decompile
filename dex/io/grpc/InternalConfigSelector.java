package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.LoadBalancer;
import javax.annotation.Nullable;

public abstract class InternalConfigSelector {
    public static final Attributes.Key<InternalConfigSelector> KEY = Attributes.Key.create("io.grpc.config-selector");

    public abstract Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Result {
        private final Object config;
        @Nullable
        public ClientInterceptor interceptor;
        private final Status status;

        private Result(Status status, Object config, ClientInterceptor interceptor) {
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.config = config;
            this.interceptor = interceptor;
        }

        public static Result forError(Status status) {
            Preconditions.checkArgument(!status.isOk(), "status is OK");
            return new Result(status, null, null);
        }

        public Status getStatus() {
            return this.status;
        }

        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public ClientInterceptor getInterceptor() {
            return this.interceptor;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private Object config;
            private ClientInterceptor interceptor;

            private Builder() {
            }

            public Builder setConfig(Object config) {
                this.config = Preconditions.checkNotNull(config, "config");
                return this;
            }

            public Builder setInterceptor(ClientInterceptor interceptor) {
                this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(interceptor, "interceptor");
                return this;
            }

            public Result build() {
                Preconditions.checkState(this.config != null, "config is not set");
                return new Result(Status.OK, this.config, this.interceptor);
            }
        }
    }
}