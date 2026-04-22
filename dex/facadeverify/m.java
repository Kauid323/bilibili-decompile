package facadeverify;

import android.content.ContentResolver;
import android.net.SSLSessionCache;
import android.os.Looper;
import android.text.format.Time;
import com.tencent.smtt.sdk.TbsReaderView;
import facadeverify.p;
import io.grpc.internal.GrpcUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Security;
import java.util.regex.Matcher;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

public final class m implements HttpClient {
    public static String[] c = {"text/", "application/xml", "application/json"};

    /* renamed from: d  reason: collision with root package name */
    public static final HttpRequestInterceptor f1915d = new a();
    public final HttpClient a;
    public volatile d b;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class a implements HttpRequestInterceptor {
        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("This thread forbids HTTP requests");
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class b extends DefaultHttpClient {

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public class a extends DefaultRedirectHandler {
            public int a;

            public a(b bVar) {
            }

            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                int statusCode;
                this.a++;
                boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
                if (isRedirectRequested || this.a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
                    return isRedirectRequested;
                }
                return true;
            }
        }

        /* renamed from: facadeverify.m$b$b  reason: collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public class C0021b implements ConnectionKeepAliveStrategy {
            public C0021b(b bVar) {
            }

            public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                return 180000L;
            }
        }

        public b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
            super(clientConnectionManager, httpParams);
        }

        public ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
            return new C0021b(this);
        }

        public HttpContext createHttpContext() {
            BasicHttpContext basicHttpContext = new BasicHttpContext();
            basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
            basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
            basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
            return basicHttpContext;
        }

        public BasicHttpProcessor createHttpProcessor() {
            BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
            createHttpProcessor.addRequestInterceptor(m.f1915d);
            createHttpProcessor.addRequestInterceptor(new c(null));
            return createHttpProcessor;
        }

        public RedirectHandler createRedirectHandler() {
            return new a(this);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class c implements HttpRequestInterceptor {
        public /* synthetic */ c(a aVar) {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            d dVar = m.this.b;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class d {
    }

    public m(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        new IllegalStateException("AndroidHttpClient created and never closed");
        this.a = new b(clientConnectionManager, httpParams);
    }

    public static m a(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpClientParams.setAuthenticating(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        Object obj = null;
        Object[] objArr = {15000, null};
        try {
            Method declaredMethod = Class.forName("android.net.SSLCertificateSocketFactory").getDeclaredMethod("getHttpSocketFactory", Integer.TYPE, SSLSessionCache.class);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(null, objArr);
        } catch (ClassNotFoundException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (NoSuchMethodException e5) {
        } catch (InvocationTargetException e6) {
        }
        schemeRegistry.register(new Scheme("https", (SSLSocketFactory) obj, (int) GrpcUtil.DEFAULT_PORT_SSL));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        ConnManagerParams.setTimeout(basicHttpParams, 60000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
        Security.setProperty("networkaddress.cache.ttl", String.valueOf(-1));
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new m(threadSafeClientConnManager, basicHttpParams);
    }

    public static long b(String str) {
        int b2;
        int d2;
        int i2;
        p.a aVar;
        int i3;
        int i4;
        int i5;
        Matcher matcher = p.a.matcher(str);
        if (matcher.find()) {
            i2 = p.a(matcher.group(1));
            b2 = p.b(matcher.group(2));
            d2 = p.d(matcher.group(3));
            aVar = p.c(matcher.group(4));
        } else {
            Matcher matcher2 = p.b.matcher(str);
            if (matcher2.find()) {
                b2 = p.b(matcher2.group(1));
                int a2 = p.a(matcher2.group(2));
                p.a c2 = p.c(matcher2.group(3));
                d2 = p.d(matcher2.group(4));
                i2 = a2;
                aVar = c2;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (d2 >= 2038) {
            i4 = 0;
            i5 = 2038;
            i3 = 1;
        } else {
            i3 = i2;
            i4 = b2;
            i5 = d2;
        }
        Time time = new Time("UTC");
        time.set(aVar.c, aVar.b, aVar.a, i3, i4, i5);
        return time.toMillis(false);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) {
        return this.a.execute(httpUriRequest);
    }

    public ClientConnectionManager getConnectionManager() {
        return this.a.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.a.getParams();
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return this.a.execute(httpUriRequest, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.a.execute(httpHost, httpRequest);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.a.execute(httpHost, httpRequest, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) this.a.execute(httpUriRequest, responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) this.a.execute(httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) this.a.execute(httpHost, httpRequest, responseHandler);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) this.a.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public static void a(HttpRequest httpRequest) {
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }

    public void a(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.a.setHttpRequestRetryHandler(httpRequestRetryHandler);
    }

    public static InputStream a(HttpEntity httpEntity) {
        Header contentEncoding;
        String value;
        InputStream content = httpEntity.getContent();
        return (content == null || (contentEncoding = httpEntity.getContentEncoding()) == null || (value = contentEncoding.getValue()) == null || !value.contains("gzip")) ? content : new GZIPInputStream(content);
    }

    public static AbstractHttpEntity a(byte[] bArr, ContentResolver contentResolver) {
        if (bArr.length < 160) {
            return new ByteArrayEntity(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        return byteArrayEntity;
    }
}