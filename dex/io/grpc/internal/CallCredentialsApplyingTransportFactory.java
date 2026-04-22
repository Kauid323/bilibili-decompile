package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.CompositeCallCredentials;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.MetadataApplierImpl;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

final class CallCredentialsApplyingTransportFactory implements ClientTransportFactory {
    private final Executor appExecutor;
    private final CallCredentials channelCallCredentials;
    private final ClientTransportFactory delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallCredentialsApplyingTransportFactory(ClientTransportFactory delegate, CallCredentials channelCallCredentials, Executor appExecutor) {
        this.delegate = (ClientTransportFactory) Preconditions.checkNotNull(delegate, "delegate");
        this.channelCallCredentials = channelCallCredentials;
        this.appExecutor = (Executor) Preconditions.checkNotNull(appExecutor, "appExecutor");
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ConnectionClientTransport newClientTransport(SocketAddress serverAddress, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
        return new CallCredentialsApplyingTransport(this.delegate.newClientTransport(serverAddress, options, channelLogger), options.getAuthority());
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.delegate.getScheduledExecutorService();
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCreds) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private class CallCredentialsApplyingTransport extends ForwardingConnectionClientTransport {
        private final String authority;
        private final ConnectionClientTransport delegate;
        private Status savedShutdownNowStatus;
        private Status savedShutdownStatus;
        private volatile Status shutdownStatus;
        private final AtomicInteger pendingApplier = new AtomicInteger(-2147483647);
        private final MetadataApplierImpl.MetadataApplierListener applierListener = new MetadataApplierImpl.MetadataApplierListener() { // from class: io.grpc.internal.CallCredentialsApplyingTransportFactory.CallCredentialsApplyingTransport.1
            @Override // io.grpc.internal.MetadataApplierImpl.MetadataApplierListener
            public void onComplete() {
                if (CallCredentialsApplyingTransport.this.pendingApplier.decrementAndGet() == 0) {
                    CallCredentialsApplyingTransport.this.maybeShutdown();
                }
            }
        };

        CallCredentialsApplyingTransport(ConnectionClientTransport delegate, String authority) {
            this.delegate = (ConnectionClientTransport) Preconditions.checkNotNull(delegate, "delegate");
            this.authority = (String) Preconditions.checkNotNull(authority, "authority");
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        protected ConnectionClientTransport delegate() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(final MethodDescriptor<?, ?> method, Metadata headers, final CallOptions callOptions) {
            CallCredentials creds = callOptions.getCredentials();
            if (creds == null) {
                creds = CallCredentialsApplyingTransportFactory.this.channelCallCredentials;
            } else if (CallCredentialsApplyingTransportFactory.this.channelCallCredentials != null) {
                creds = new CompositeCallCredentials(CallCredentialsApplyingTransportFactory.this.channelCallCredentials, creds);
            }
            if (creds != null) {
                MetadataApplierImpl applier = new MetadataApplierImpl(this.delegate, method, headers, callOptions, this.applierListener);
                if (this.pendingApplier.incrementAndGet() > 0) {
                    this.applierListener.onComplete();
                    return new FailingClientStream(this.shutdownStatus);
                }
                CallCredentials.RequestInfo requestInfo = new CallCredentials.RequestInfo() { // from class: io.grpc.internal.CallCredentialsApplyingTransportFactory.CallCredentialsApplyingTransport.2
                    @Override // io.grpc.CallCredentials.RequestInfo
                    public MethodDescriptor<?, ?> getMethodDescriptor() {
                        return method;
                    }

                    @Override // io.grpc.CallCredentials.RequestInfo
                    public SecurityLevel getSecurityLevel() {
                        return (SecurityLevel) MoreObjects.firstNonNull(CallCredentialsApplyingTransport.this.delegate.getAttributes().get(GrpcAttributes.ATTR_SECURITY_LEVEL), SecurityLevel.NONE);
                    }

                    @Override // io.grpc.CallCredentials.RequestInfo
                    public String getAuthority() {
                        return (String) MoreObjects.firstNonNull(callOptions.getAuthority(), CallCredentialsApplyingTransport.this.authority);
                    }

                    @Override // io.grpc.CallCredentials.RequestInfo
                    public Attributes getTransportAttrs() {
                        return CallCredentialsApplyingTransport.this.delegate.getAttributes();
                    }
                };
                try {
                    creds.applyRequestMetadata(requestInfo, (Executor) MoreObjects.firstNonNull(callOptions.getExecutor(), CallCredentialsApplyingTransportFactory.this.appExecutor), applier);
                } catch (Throwable t) {
                    applier.fail(Status.UNAUTHENTICATED.withDescription("Credentials should use fail() instead of throwing exceptions").withCause(t));
                }
                return applier.returnStream();
            } else if (this.pendingApplier.get() >= 0) {
                return new FailingClientStream(this.shutdownStatus);
            } else {
                return this.delegate.newStream(method, headers, callOptions);
            }
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ManagedClientTransport
        public void shutdown(Status status) {
            Preconditions.checkNotNull(status, "status");
            synchronized (this) {
                if (this.pendingApplier.get() < 0) {
                    this.shutdownStatus = status;
                    this.pendingApplier.addAndGet(Integer.MAX_VALUE);
                    if (this.pendingApplier.get() != 0) {
                        this.savedShutdownStatus = status;
                    } else {
                        super.shutdown(status);
                    }
                }
            }
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ManagedClientTransport
        public void shutdownNow(Status status) {
            Preconditions.checkNotNull(status, "status");
            synchronized (this) {
                if (this.pendingApplier.get() < 0) {
                    this.shutdownStatus = status;
                    this.pendingApplier.addAndGet(Integer.MAX_VALUE);
                } else if (this.savedShutdownNowStatus != null) {
                    return;
                }
                if (this.pendingApplier.get() != 0) {
                    this.savedShutdownNowStatus = status;
                } else {
                    super.shutdownNow(status);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeShutdown() {
            synchronized (this) {
                if (this.pendingApplier.get() != 0) {
                    return;
                }
                Status maybeShutdown = this.savedShutdownStatus;
                Status maybeShutdownNow = this.savedShutdownNowStatus;
                this.savedShutdownStatus = null;
                this.savedShutdownNowStatus = null;
                if (maybeShutdown != null) {
                    super.shutdown(maybeShutdown);
                }
                if (maybeShutdownNow != null) {
                    super.shutdownNow(maybeShutdownNow);
                }
            }
        }
    }
}