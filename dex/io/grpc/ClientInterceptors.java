package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.2
        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> responseListener, Metadata headers) {
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
        public void sendMessage(Object message) {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }
    };

    private ClientInterceptors() {
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... interceptors) {
        return interceptForward(channel, Arrays.asList(interceptors));
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> interceptors) {
        List<? extends ClientInterceptor> copy = new ArrayList<>(interceptors);
        Collections.reverse(copy);
        return intercept(channel, copy);
    }

    public static Channel intercept(Channel channel, ClientInterceptor... interceptors) {
        return intercept(channel, Arrays.asList(interceptors));
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> interceptors) {
        Preconditions.checkNotNull(channel, "channel");
        for (ClientInterceptor interceptor : interceptors) {
            channel = new InterceptorChannel(channel, interceptor, null);
        }
        return channel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.ClientInterceptors$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class AnonymousClass1 implements ClientInterceptor {
        final /* synthetic */ ClientInterceptor val$interceptor;
        final /* synthetic */ MethodDescriptor.Marshaller val$reqMarshaller;
        final /* synthetic */ MethodDescriptor.Marshaller val$respMarshaller;

        AnonymousClass1(MethodDescriptor.Marshaller marshaller, MethodDescriptor.Marshaller marshaller2, ClientInterceptor clientInterceptor) {
            this.val$reqMarshaller = marshaller;
            this.val$respMarshaller = marshaller2;
            this.val$interceptor = clientInterceptor;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            final ClientCall<ReqT, RespT> interceptCall = this.val$interceptor.interceptCall(method.toBuilder(this.val$reqMarshaller, this.val$respMarshaller).build(), callOptions, next);
            return new PartialForwardingClientCall<ReqT, RespT>() { // from class: io.grpc.ClientInterceptors.1.1
                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<RespT> responseListener, Metadata headers) {
                    interceptCall.start(new PartialForwardingClientCallListener<WRespT>() { // from class: io.grpc.ClientInterceptors.1.1.1
                        @Override // io.grpc.ClientCall.Listener
                        public void onMessage(WRespT wMessage) {
                            InputStream bytes = AnonymousClass1.this.val$respMarshaller.stream(wMessage);
                            RespT message = method.getResponseMarshaller().parse(bytes);
                            responseListener.onMessage(message);
                        }

                        @Override // io.grpc.PartialForwardingClientCallListener
                        protected ClientCall.Listener<?> delegate() {
                            return responseListener;
                        }
                    }, headers);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.ClientCall
                public void sendMessage(ReqT message) {
                    InputStream bytes = method.getRequestMarshaller().stream(message);
                    interceptCall.sendMessage(AnonymousClass1.this.val$reqMarshaller.parse(bytes));
                }

                @Override // io.grpc.PartialForwardingClientCall
                protected ClientCall<?, ?> delegate() {
                    return interceptCall;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor interceptor, MethodDescriptor.Marshaller<WReqT> reqMarshaller, MethodDescriptor.Marshaller<WRespT> respMarshaller) {
        return new AnonymousClass1(reqMarshaller, respMarshaller, interceptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        /* synthetic */ InterceptorChannel(Channel x0, ClientInterceptor x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        private InterceptorChannel(Channel channel, ClientInterceptor interceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(interceptor, "interceptor");
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
            return this.interceptor.interceptCall(method, callOptions, this.channel);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        protected abstract void checkedStart(ClientCall.Listener<RespT> listener, Metadata metadata) throws Exception;

        protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> delegate) {
            this.delegate = delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        protected final ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
            try {
                checkedStart(responseListener, headers);
            } catch (Exception e2) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                responseListener.onClose(Status.fromThrowable(e2), new Metadata());
            }
        }
    }
}