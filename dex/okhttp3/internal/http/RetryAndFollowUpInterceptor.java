package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient client, boolean forWebSocket) {
        this.client = client;
        this.forWebSocket = forWebSocket;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object callStackTrace) {
        this.callStackTrace = callStackTrace;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0160  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realChain;
        Response response;
        Request followUp;
        RealInterceptorChain realChain2;
        int followUpCount;
        Request request = chain.request();
        RealInterceptorChain realChain3 = (RealInterceptorChain) chain;
        Call call = realChain3.call();
        EventListener eventListener = realChain3.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        int followUpCount2 = 0;
        Request request2 = request;
        StreamAllocation streamAllocation2 = streamAllocation;
        Response priorResponse = null;
        while (!this.canceled) {
            try {
                Response response2 = realChain3.proceed(request2, streamAllocation2, null, null);
                if (0 != 0) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                }
                response = priorResponse != null ? response2.newBuilder().priorResponse(priorResponse.newBuilder().body(null).build()).build() : response2;
                try {
                    followUp = followUpRequest(response, streamAllocation2.route());
                } catch (IOException e) {
                    streamAllocation2.release();
                    throw e;
                }
            } catch (IOException e2) {
                realChain = realChain3;
                try {
                    boolean requestSendStarted = e2 instanceof ConnectionShutdownException ? false : true;
                    if (!recover(e2, streamAllocation2, requestSendStarted, request2)) {
                        throw e2;
                    }
                    if (0 != 0) {
                        streamAllocation2.streamFailed(null);
                        streamAllocation2.release();
                    }
                    realChain3 = realChain;
                } catch (Throwable th) {
                    e = th;
                    if (1 != 0) {
                        streamAllocation2.streamFailed(null);
                        streamAllocation2.release();
                    }
                    throw e;
                }
            } catch (RouteException e3) {
                realChain = realChain3;
                if (!recover(e3.getLastConnectException(), streamAllocation2, false, request2)) {
                    throw e3.getFirstConnectException();
                }
                if (0 != 0) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                }
                realChain3 = realChain;
            } catch (Throwable th2) {
                e = th2;
                if (1 != 0) {
                }
                throw e;
            }
            if (followUp == null) {
                streamAllocation2.release();
                return response;
            }
            Util.closeQuietly(response.body());
            int followUpCount3 = followUpCount2 + 1;
            if (followUpCount3 > 20) {
                streamAllocation2.release();
                throw new ProtocolException("Too many follow-up requests: " + followUpCount3);
            } else if (followUp.body() instanceof UnrepeatableRequestBody) {
                streamAllocation2.release();
                throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
            } else {
                if (sameConnection(response, followUp.url())) {
                    realChain2 = realChain3;
                    followUpCount = followUpCount3;
                    if (streamAllocation2.codec() != null) {
                        throw new IllegalStateException("Closing the body of " + response + " didn't close its backing stream. Bad interceptor?");
                    }
                } else {
                    streamAllocation2.release();
                    realChain2 = realChain3;
                    followUpCount = followUpCount3;
                    StreamAllocation streamAllocation3 = new StreamAllocation(this.client.connectionPool(), createAddress(followUp.url()), call, eventListener, this.callStackTrace);
                    this.streamAllocation = streamAllocation3;
                    streamAllocation2 = streamAllocation3;
                }
                request2 = followUp;
                priorResponse = response;
                followUpCount2 = followUpCount;
                realChain3 = realChain2;
            }
        }
        streamAllocation2.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl url) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (url.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        return new Address(url.host(), url.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(IOException e, StreamAllocation streamAllocation, boolean requestSendStarted, Request userRequest) {
        streamAllocation.streamFailed(e);
        if (this.client.retryOnConnectionFailure()) {
            return !(requestSendStarted && requestIsUnrepeatable(e, userRequest)) && isRecoverable(e, requestSendStarted) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private boolean requestIsUnrepeatable(IOException e, Request userRequest) {
        return (userRequest.body() instanceof UnrepeatableRequestBody) || (e instanceof FileNotFoundException);
    }

    private boolean isRecoverable(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        return e instanceof InterruptedIOException ? (e instanceof SocketTimeoutException) && !requestSendStarted : (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Request followUpRequest(Response userResponse, Route route) throws IOException {
        String location2;
        HttpUrl url;
        if (userResponse == null) {
            throw new IllegalStateException();
        }
        int responseCode = userResponse.code();
        String method = userResponse.request().method();
        switch (responseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case StatusLine.HTTP_TEMP_REDIRECT /* 307 */:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
                break;
            case 401:
                return this.client.authenticator().authenticate(route, userResponse);
            case 407:
                Proxy selectedProxy = route.proxy();
                if (selectedProxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, userResponse);
            case 408:
                if (this.client.retryOnConnectionFailure() && !(userResponse.request().body() instanceof UnrepeatableRequestBody)) {
                    if ((userResponse.priorResponse() == null || userResponse.priorResponse().code() != 408) && retryAfter(userResponse, 0) <= 0) {
                        return userResponse.request();
                    }
                    return null;
                }
                return null;
            case 503:
                if ((userResponse.priorResponse() == null || userResponse.priorResponse().code() != 503) && retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.request();
                }
                return null;
            default:
                return null;
        }
        if (!this.client.followRedirects() || (location2 = userResponse.header("Location")) == null || (url = userResponse.request().url().resolve(location2)) == null) {
            return null;
        }
        boolean sameScheme = url.scheme().equals(userResponse.request().url().scheme());
        if (sameScheme || this.client.followSslRedirects()) {
            Request.Builder requestBuilder = userResponse.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean maintainBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    requestBuilder.method("GET", null);
                } else {
                    RequestBody requestBody = maintainBody ? userResponse.request().body() : null;
                    requestBuilder.method(method, requestBody);
                }
                if (!maintainBody) {
                    requestBuilder.removeHeader("Transfer-Encoding");
                    requestBuilder.removeHeader("Content-Length");
                    requestBuilder.removeHeader("Content-Type");
                }
            }
            if (!sameConnection(userResponse, url)) {
                requestBuilder.removeHeader("Authorization");
            }
            return requestBuilder.url(url).build();
        }
        return null;
    }

    private int retryAfter(Response userResponse, int defaultDelay) {
        String header = userResponse.header("Retry-After");
        if (header == null) {
            return defaultDelay;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl followUp) {
        HttpUrl url = response.request().url();
        return url.host().equals(followUp.host()) && url.port() == followUp.port() && url.scheme().equals(followUp.scheme());
    }
}