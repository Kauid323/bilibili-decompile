package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.InternalConfigSelector;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ClientStreamListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

final class SubchannelChannel extends Channel {
    static final Status NOT_READY_ERROR = Status.UNAVAILABLE.withDescription("Subchannel is NOT READY");
    static final Status WAIT_FOR_READY_ERROR = Status.UNAVAILABLE.withDescription("wait-for-ready RPC is not supported on Subchannel.asChannel()");
    private static final FailingClientTransport notReadyTransport = new FailingClientTransport(NOT_READY_ERROR, ClientStreamListener.RpcProgress.REFUSED);
    private final CallTracer callsTracer;
    private final AtomicReference<InternalConfigSelector> configSelector;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    private final InternalSubchannel subchannel;
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ClientCallImpl.ClientStreamProvider() { // from class: io.grpc.internal.SubchannelChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> method, CallOptions callOptions, Metadata headers, Context context) {
            ClientTransport transport = SubchannelChannel.this.subchannel.getTransport();
            if (transport == null) {
                transport = SubchannelChannel.notReadyTransport;
            }
            Context origContext = context.attach();
            try {
                return transport.newStream(method, headers, callOptions);
            } finally {
                context.detach(origContext);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubchannelChannel(InternalSubchannel subchannel, Executor executor, ScheduledExecutorService deadlineCancellationExecutor, CallTracer callsTracer, AtomicReference<InternalConfigSelector> configSelector) {
        this.subchannel = (InternalSubchannel) Preconditions.checkNotNull(subchannel, "subchannel");
        this.executor = (Executor) Preconditions.checkNotNull(executor, "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(deadlineCancellationExecutor, "deadlineCancellationExecutor");
        this.callsTracer = (CallTracer) Preconditions.checkNotNull(callsTracer, "callsTracer");
        this.configSelector = (AtomicReference) Preconditions.checkNotNull(configSelector, "configSelector");
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        final Executor effectiveExecutor = callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor();
        if (callOptions.isWaitForReady()) {
            return new ClientCall<RequestT, ResponseT>() { // from class: io.grpc.internal.SubchannelChannel.2
                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<ResponseT> listener, Metadata headers) {
                    effectiveExecutor.execute(new Runnable() { // from class: io.grpc.internal.SubchannelChannel.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            listener.onClose(SubchannelChannel.WAIT_FOR_READY_ERROR, new Metadata());
                        }
                    });
                }

                @Override // io.grpc.ClientCall
                public void request(int numMessages) {
                }

                @Override // io.grpc.ClientCall
                public void cancel(String message, Throwable cause) {
                }

                @Override // io.grpc.ClientCall
                public void halfClose() {
                }

                @Override // io.grpc.ClientCall
                public void sendMessage(RequestT message) {
                }
            };
        }
        return new ClientCallImpl(methodDescriptor, effectiveExecutor, callOptions.withOption(GrpcUtil.CALL_OPTIONS_RPC_OWNED_BY_BALANCER, Boolean.TRUE), this.transportProvider, this.deadlineCancellationExecutor, this.callsTracer, this.configSelector.get());
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.subchannel.getAuthority();
    }
}