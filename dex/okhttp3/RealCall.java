package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Interceptor;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
public final class RealCall implements Call {
    final OkHttpClient client;
    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    @Nullable
    NetworkBridgeInterceptor networkBridgeInterceptor;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout = new AsyncTimeout() { // from class: okhttp3.RealCall.1
        @Override // okio.AsyncTimeout
        protected void timedOut() {
            RealCall.this.cancel();
        }
    };

    private RealCall(OkHttpClient client, Request originalRequest, boolean forWebSocket) {
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = forWebSocket;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(client, forWebSocket);
        int realCallTimeoutMs = originalRequest.callTimeoutMillis();
        this.timeout.timeout(realCallTimeoutMs == 0 ? client.callTimeoutMillis() : realCallTimeoutMs, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RealCall newRealCall(OkHttpClient client, Request originalRequest, boolean forWebSocket) {
        RealCall call = new RealCall(client, originalRequest, forWebSocket);
        call.eventListener = client.eventListenerFactory().create(call);
        return call;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response result = getResponseWithInterceptorChain();
                if (result == null) {
                    throw new IOException("Canceled");
                }
                return result;
            } catch (IOException e) {
                IOException e2 = timeoutExit(e);
                this.eventListener.callFailed(this, e2);
                throw e2;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException timeoutExit(@Nullable IOException cause) {
        if (this.timeout.exit()) {
            InterruptedIOException e = new InterruptedIOException("timeout");
            if (cause != null) {
                e.initCause(cause);
            }
            return e;
        }
        return cause;
    }

    private void captureCallStackTrace() {
        Object callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.retryAndFollowUpInterceptor.setCallStackTrace(callStackTrace);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback responseCallback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(responseCallback));
    }

    @Override // okhttp3.Call
    public void cancel() {
        doCancle();
    }

    private void doCancle() {
        if (this.networkBridgeInterceptor != null && this.networkBridgeInterceptor.isBridged()) {
            this.networkBridgeInterceptor.cancel();
        } else {
            this.retryAndFollowUpInterceptor.cancel();
        }
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return doIsCanceled();
    }

    private boolean doIsCanceled() {
        if (this.networkBridgeInterceptor != null) {
            return this.networkBridgeInterceptor.isCanceled();
        }
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        AsyncCall(Callback responseCallback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = responseCallback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            if (Thread.holdsLock(RealCall.this.client.dispatcher())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                    if (1 != 0) {
                        return;
                    }
                } catch (RejectedExecutionException e) {
                    InterruptedIOException ioException = new InterruptedIOException("executor rejected");
                    ioException.initCause(e);
                    RealCall.this.eventListener.callFailed(RealCall.this, ioException);
                    this.responseCallback.onFailure(RealCall.this, ioException);
                    if (0 != 0) {
                        return;
                    }
                }
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                if (0 == 0) {
                    RealCall.this.client.dispatcher().finished(this);
                }
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            boolean signalledCallback = false;
            RealCall.this.timeout.enter();
            try {
                try {
                    Response response = RealCall.this.getResponseWithInterceptorChain();
                    signalledCallback = true;
                    this.responseCallback.onResponse(RealCall.this, response);
                } finally {
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (IOException e) {
                IOException e2 = RealCall.this.timeoutExit(e);
                if (!signalledCallback) {
                    RealCall.this.eventListener.callFailed(RealCall.this, e2);
                    this.responseCallback.onFailure(RealCall.this, e2);
                } else {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e2);
                }
            } catch (Throwable t) {
                RealCall.this.cancel();
                if (!signalledCallback) {
                    IOException canceledException = new IOException("canceled due to " + t);
                    this.responseCallback.onFailure(RealCall.this, canceledException);
                }
                throw t;
            }
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : "call") + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.addAll(this.client.interceptors());
        if (this.client.bridgeFactory != null) {
            this.networkBridgeInterceptor = this.client.bridgeFactory.create(this.client, this.forWebSocket);
            interceptors.add(this.networkBridgeInterceptor);
        }
        interceptors.add(this.retryAndFollowUpInterceptor);
        interceptors.add(new BridgeInterceptor(this.client.cookieJar()));
        interceptors.add(new CacheInterceptor(this.client.internalCache()));
        interceptors.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            interceptors.addAll(this.client.networkInterceptors());
        }
        interceptors.add(new CallServerInterceptor(this.forWebSocket));
        Interceptor.Chain chain = new RealInterceptorChain(interceptors, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        Response response = chain.proceed(this.originalRequest);
        if (isCanceled()) {
            Util.closeQuietly(response);
            throw new IOException("Canceled");
        }
        return response;
    }
}