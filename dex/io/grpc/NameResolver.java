package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

public abstract class NameResolver {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public @interface ResolutionResultAttr {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public abstract void shutdown();

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start(new Listener2() { // from class: io.grpc.NameResolver.1
                @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
                public void onError(Status error) {
                    listener.onError(error);
                }

                @Override // io.grpc.NameResolver.Listener2
                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }

    public void start(Listener2 listener) {
        start((Listener) listener);
    }

    public void refresh() {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Factory {
        @Deprecated
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.create("params-default-port");
        @Deprecated
        public static final Attributes.Key<ProxyDetector> PARAMS_PROXY_DETECTOR = Attributes.Key.create("params-proxy-detector");
        @Deprecated
        private static final Attributes.Key<SynchronizationContext> PARAMS_SYNC_CONTEXT = Attributes.Key.create("params-sync-context");
        @Deprecated
        private static final Attributes.Key<ServiceConfigParser> PARAMS_PARSER = Attributes.Key.create("params-parser");

        public abstract String getDefaultScheme();

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI targetUri, Attributes params) {
            Args args = Args.newBuilder().setDefaultPort(((Integer) params.get(PARAMS_DEFAULT_PORT)).intValue()).setProxyDetector((ProxyDetector) params.get(PARAMS_PROXY_DETECTOR)).setSynchronizationContext((SynchronizationContext) params.get(PARAMS_SYNC_CONTEXT)).setServiceConfigParser((ServiceConfigParser) params.get(PARAMS_PARSER)).build();
            return newNameResolver(targetUri, args);
        }

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI targetUri, final Helper helper) {
            return newNameResolver(targetUri, Attributes.newBuilder().set(PARAMS_DEFAULT_PORT, Integer.valueOf(helper.getDefaultPort())).set(PARAMS_PROXY_DETECTOR, helper.getProxyDetector()).set(PARAMS_SYNC_CONTEXT, helper.getSynchronizationContext()).set(PARAMS_PARSER, new ServiceConfigParser() { // from class: io.grpc.NameResolver.Factory.1
                @Override // io.grpc.NameResolver.ServiceConfigParser
                public ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
                    return helper.parseServiceConfig(rawServiceConfig);
                }
            }).build());
        }

        public NameResolver newNameResolver(URI targetUri, final Args args) {
            return newNameResolver(targetUri, new Helper() { // from class: io.grpc.NameResolver.Factory.2
                @Override // io.grpc.NameResolver.Helper
                public int getDefaultPort() {
                    return args.getDefaultPort();
                }

                @Override // io.grpc.NameResolver.Helper
                public ProxyDetector getProxyDetector() {
                    return args.getProxyDetector();
                }

                @Override // io.grpc.NameResolver.Helper
                public SynchronizationContext getSynchronizationContext() {
                    return args.getSynchronizationContext();
                }

                @Override // io.grpc.NameResolver.Helper
                public ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
                    return args.getServiceConfigParser().parseServiceConfig(rawServiceConfig);
                }
            });
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);

        @Override // io.grpc.NameResolver.Listener
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> servers, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(servers).setAttributes(attributes).build());
        }
    }

    @Deprecated
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Helper {
        public abstract int getDefaultPort();

        public abstract ProxyDetector getProxyDetector();

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
            throw new UnsupportedOperationException("should have been implemented");
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Args {
        @Nullable
        private final ChannelLogger channelLogger;
        private final int defaultPort;
        @Nullable
        private final Executor executor;
        private final ProxyDetector proxyDetector;
        @Nullable
        private final ScheduledExecutorService scheduledExecutorService;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        private Args(Integer defaultPort, ProxyDetector proxyDetector, SynchronizationContext syncContext, ServiceConfigParser serviceConfigParser, @Nullable ScheduledExecutorService scheduledExecutorService, @Nullable ChannelLogger channelLogger, @Nullable Executor executor) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(defaultPort, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(syncContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser, "serviceConfigParser not set");
            this.scheduledExecutorService = scheduledExecutorService;
            this.channelLogger = channelLogger;
            this.executor = executor;
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            if (this.scheduledExecutorService == null) {
                throw new IllegalStateException("ScheduledExecutorService not set in Builder");
            }
            return this.scheduledExecutorService;
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public ChannelLogger getChannelLogger() {
            if (this.channelLogger == null) {
                throw new IllegalStateException("ChannelLogger is not set in Builder");
            }
            return this.channelLogger;
        }

        @Nullable
        public Executor getOffloadExecutor() {
            return this.executor;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.defaultPort).add("proxyDetector", this.proxyDetector).add("syncContext", this.syncContext).add("serviceConfigParser", this.serviceConfigParser).add("scheduledExecutorService", this.scheduledExecutorService).add("channelLogger", this.channelLogger).add("executor", this.executor).toString();
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            builder.setScheduledExecutorService(this.scheduledExecutorService);
            builder.setChannelLogger(this.channelLogger);
            builder.setOffloadExecutor(this.executor);
            return builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private ChannelLogger channelLogger;
            private Integer defaultPort;
            private Executor executor;
            private ProxyDetector proxyDetector;
            private ScheduledExecutorService scheduledExecutorService;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Builder setDefaultPort(int defaultPort) {
                this.defaultPort = Integer.valueOf(defaultPort);
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext syncContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(syncContext);
                return this;
            }

            public Builder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser parser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(parser);
                return this;
            }

            public Builder setChannelLogger(ChannelLogger channelLogger) {
                this.channelLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger);
                return this;
            }

            public Builder setOffloadExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser, this.scheduledExecutorService, this.channelLogger, this.executor);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final ConfigOrError serviceConfig;

        ResolutionResult(List<EquivalentAddressGroup> addresses, Attributes attributes, ConfigOrError serviceConfig) {
            this.addresses = Collections.unmodifiableList(new ArrayList(addresses));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.serviceConfig = serviceConfig;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("serviceConfig", this.serviceConfig).toString();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResolutionResult) {
                ResolutionResult that = (ResolutionResult) obj;
                return Objects.equal(this.addresses, that.addresses) && Objects.equal(this.attributes, that.attributes) && Objects.equal(this.serviceConfig, that.serviceConfig);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.addresses, this.attributes, this.serviceConfig});
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private ConfigOrError serviceConfig;

            Builder() {
            }

            public Builder setAddresses(List<EquivalentAddressGroup> addresses) {
                this.addresses = addresses;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError serviceConfig) {
                this.serviceConfig = serviceConfig;
                return this;
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        public static ConfigOrError fromConfig(Object config) {
            return new ConfigOrError(config);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        private ConfigOrError(Object config) {
            this.config = Preconditions.checkNotNull(config, "config");
            this.status = null;
        }

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ConfigOrError that = (ConfigOrError) o;
            if (Objects.equal(this.status, that.status) && Objects.equal(this.config, that.config)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.status, this.config});
        }

        public String toString() {
            if (this.config != null) {
                return MoreObjects.toStringHelper(this).add("config", this.config).toString();
            }
            if (this.status == null) {
                throw new AssertionError();
            }
            return MoreObjects.toStringHelper(this).add("error", this.status).toString();
        }
    }
}