package facadeverify;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.performance.EntryPointKt;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class w implements Callable<x> {
    public static final HttpRequestRetryHandler n = new d0();
    public s a;
    public Context b;
    public u c;

    /* renamed from: d  reason: collision with root package name */
    public HttpUriRequest f1928d;

    /* renamed from: g  reason: collision with root package name */
    public CookieManager f1931g;

    /* renamed from: h  reason: collision with root package name */
    public AbstractHttpEntity f1932h;

    /* renamed from: i  reason: collision with root package name */
    public HttpHost f1933i;
    public URL j;
    public String k;
    public String m;

    /* renamed from: e  reason: collision with root package name */
    public HttpContext f1929e = new BasicHttpContext();

    /* renamed from: f  reason: collision with root package name */
    public CookieStore f1930f = new BasicCookieStore();
    public int l = 0;

    public w(s sVar, u uVar) {
        this.a = sVar;
        this.b = this.a.a;
        this.c = uVar;
    }

    public final void a() {
        HttpUriRequest httpUriRequest = this.f1928d;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    public final void b() {
        ArrayList<Header> b = this.c.b();
        if (b != null && !b.isEmpty()) {
            Iterator<Header> it = b.iterator();
            while (it.hasNext()) {
                f().addHeader(it.next());
            }
        }
        m.a((HttpRequest) f());
        f().addHeader("Connection", "Keep-Alive");
        f().addHeader("cookie", d().getCookie(this.c.b));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpResponse c() {
        HttpHost httpHost;
        HttpHost httpHost2;
        HttpParams params = e().getParams();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        HttpHost httpHost3 = null;
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null) {
                httpHost = new HttpHost(defaultHost, defaultPort);
                if (httpHost != null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                    httpHost3 = httpHost;
                }
                params.setParameter("http.route.default-proxy", httpHost3);
                httpHost2 = this.f1933i;
                if (httpHost2 == null) {
                    URL i2 = i();
                    this.f1933i = new HttpHost(i2.getHost(), h(), i2.getProtocol());
                    httpHost2 = this.f1933i;
                }
                if (h() == 80) {
                    httpHost2 = new HttpHost(i().getHost());
                }
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                HttpResponse execute = e().execute(httpHost2, (HttpRequest) this.f1928d, this.f1929e);
                HttpsURLConnection.setDefaultHostnameVerifier(defaultHostnameVerifier);
                return execute;
            }
        }
        httpHost = null;
        if (httpHost != null) {
        }
        httpHost3 = httpHost;
        params.setParameter("http.route.default-proxy", httpHost3);
        httpHost2 = this.f1933i;
        if (httpHost2 == null) {
        }
        if (h() == 80) {
        }
        HostnameVerifier defaultHostnameVerifier2 = HttpsURLConnection.getDefaultHostnameVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        HttpResponse execute2 = e().execute(httpHost2, (HttpRequest) this.f1928d, this.f1929e);
        HttpsURLConnection.setDefaultHostnameVerifier(defaultHostnameVerifier2);
        return execute2;
    }

    public final CookieManager d() {
        CookieManager cookieManager = this.f1931g;
        if (cookieManager != null) {
            return cookieManager;
        }
        this.f1931g = __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance();
        return this.f1931g;
    }

    public final m e() {
        return this.a.c;
    }

    public final HttpUriRequest f() {
        HttpUriRequest httpUriRequest = this.f1928d;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        AbstractHttpEntity abstractHttpEntity = this.f1932h;
        if (abstractHttpEntity == null) {
            u uVar = this.c;
            byte[] bArr = uVar.c;
            String a = uVar.a("gzip");
            if (bArr != null) {
                if (TextUtils.equals(a, "true")) {
                    this.f1932h = m.a(bArr, null);
                } else {
                    this.f1932h = new ByteArrayEntity(bArr);
                }
                this.f1932h.setContentType(this.c.f1924d);
            }
            abstractHttpEntity = this.f1932h;
        }
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(k());
            httpPost.setEntity(abstractHttpEntity);
            this.f1928d = httpPost;
        } else {
            this.f1928d = new HttpGet(k());
        }
        return this.f1928d;
    }

    public final String g() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        this.m = this.c.a("operationType");
        return this.m;
    }

    public final int h() {
        URL i2 = i();
        return i2.getPort() == -1 ? i2.getDefaultPort() : i2.getPort();
    }

    public final URL i() {
        URL url = this.j;
        if (url != null) {
            return url;
        }
        this.j = new URL(this.c.b);
        return this.j;
    }

    public final void j() {
        this.c.a();
    }

    public URI k() {
        String str = this.c.b;
        String str2 = this.k;
        if (str2 != null) {
            str = str2;
        }
        if (str != null) {
            return new URI(str);
        }
        throw new RuntimeException("url should not be null");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public x call() {
        try {
            if (d.a(this.b)) {
                j();
                b();
                this.f1929e.setAttribute("http.cookie-store", this.f1930f);
                e().a(n);
                long currentTimeMillis = System.currentTimeMillis();
                HttpResponse c = c();
                this.a.a(System.currentTimeMillis() - currentTimeMillis);
                List<Cookie> cookies = this.f1930f.getCookies();
                if (this.c.d()) {
                    d().removeAllCookie();
                }
                if (!cookies.isEmpty()) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getDomain() != null) {
                            d().setCookie(this.c.c(), cookie.getName() + "=" + cookie.getValue() + "; domain=" + cookie.getDomain() + (cookie.isSecure() ? "; Secure" : ""));
                            CookieSyncManager.getInstance().sync();
                        }
                    }
                }
                x a = a(c);
                if (((a == null || a.a() == null) ? -1L : a.a().length) == -1 && (a instanceof v)) {
                    try {
                        Long.parseLong(((v) a).b().a("Content-Length"));
                    } catch (Exception e2) {
                    }
                }
                String c2 = this.c.c();
                if (c2 != null && !TextUtils.isEmpty(g())) {
                    r0 = c2 + "#" + g();
                }
                return a;
            }
            throw new q(1, "The network is not available");
        } catch (Exception e3) {
            a();
            j();
            throw new q(0, e3 + "");
        } catch (NoHttpResponseException e4) {
            a();
            j();
            throw new q(5, e4 + "");
        } catch (q e5) {
            a();
            j();
            throw e5;
        } catch (NullPointerException e6) {
            a();
            int i2 = this.l;
            if (i2 < 1) {
                this.l = i2 + 1;
                return call();
            }
            throw new q(0, e6 + "");
        } catch (SocketTimeoutException e7) {
            a();
            j();
            throw new q(4, e7 + "");
        } catch (URISyntaxException e8) {
            throw new RuntimeException("Url parser error!", e8.getCause());
        } catch (UnknownHostException e9) {
            a();
            j();
            throw new q(9, e9 + "");
        } catch (SSLHandshakeException e10) {
            a();
            j();
            throw new q(2, e10 + "");
        } catch (SSLPeerUnverifiedException e11) {
            a();
            j();
            throw new q(2, e11 + "");
        } catch (SSLException e12) {
            a();
            j();
            throw new q(6, e12 + "");
        } catch (HttpHostConnectException e13) {
            a();
            j();
            throw new q(8, e13 + "");
        } catch (IOException e14) {
            a();
            j();
            throw new q(6, e14 + "");
        } catch (ConnectionPoolTimeoutException e15) {
            a();
            j();
            throw new q(3, e15 + "");
        } catch (ConnectTimeoutException e16) {
            a();
            j();
            throw new q(3, e16 + "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(v vVar, HttpResponse httpResponse) {
        Header contentType;
        String str;
        String[] split;
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split2 = firstHeader.getValue().split("=");
            if (split2.length >= 2) {
                for (int i2 = 0; i2 < split2.length; i2++) {
                    try {
                        if (CacheControl.MAX_AGE.equalsIgnoreCase(split2[i2])) {
                            int i3 = i2 + 1;
                            if (split2[i3] != null) {
                                try {
                                    Long.parseLong(split2[i3]);
                                    break;
                                } catch (Exception e2) {
                                }
                            } else {
                                continue;
                            }
                        }
                    } catch (NumberFormatException e3) {
                    }
                }
                contentType = httpResponse.getEntity().getContentType();
                if (contentType != null) {
                    str = null;
                } else {
                    String value = contentType.getValue();
                    HashMap hashMap = new HashMap();
                    for (String str2 : value.split(";")) {
                        String[] split3 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
                        hashMap.put(split3[0], split3[1]);
                    }
                    String str3 = (String) hashMap.get(HttpAuthHeader.Parameters.Charset);
                    str = (String) hashMap.get("Content-Type");
                }
                vVar.a(str);
                System.currentTimeMillis();
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            m.b(firstHeader2.getValue());
            System.currentTimeMillis();
        }
        contentType = httpResponse.getEntity().getContentType();
        if (contentType != null) {
        }
        vVar.a(str);
        System.currentTimeMillis();
    }

    public void a(HttpEntity httpEntity, long j, OutputStream outputStream) {
        if (outputStream != null) {
            InputStream a = m.a(httpEntity);
            httpEntity.getContentLength();
            try {
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = a.read(bArr);
                        if (read == -1 || this.c.a) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                        j();
                    }
                    outputStream.flush();
                    try {
                        a.close();
                        return;
                    } catch (IOException e2) {
                        return;
                    }
                } catch (Exception e3) {
                    throw new IOException("HttpWorker Request Error!" + e3.getLocalizedMessage());
                }
            } catch (Throwable th) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        }
        httpEntity.consumeContent();
        throw new IllegalArgumentException("Output stream may not be null");
    }

    @JvmStatic
    private static CookieManager __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance() {
        Application it;
        if (EntryPointKt.getBootOptEnable() && (it = BiliContext.application()) != null) {
            CookieSyncManager.createInstance(it);
            Log.e("WebViewGhost", "hook CookieManager getInstance");
        }
        CookieManager cookieManager = CookieManager.getInstance();
        Intrinsics.checkNotNull(cookieManager, "null cannot be cast to non-null type android.webkit.CookieManager");
        return cookieManager;
    }

    public x a(HttpResponse httpResponse) {
        Header[] allHeaders;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
        if (statusCode != 200) {
            if (!(statusCode == 304)) {
                throw new q(Integer.valueOf(httpResponse.getStatusLine().getStatusCode()), httpResponse.getStatusLine().getReasonPhrase());
            }
        }
        HttpEntity entity = httpResponse.getEntity();
        v vVar = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        vVar = null;
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, 0L, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    this.a.f1922f += System.currentTimeMillis() - currentTimeMillis;
                    this.a.f1920d += byteArray.length;
                    t tVar = new t();
                    for (Header header : httpResponse.getAllHeaders()) {
                        tVar.a.put(header.getName(), header.getValue());
                    }
                    vVar = new v(tVar, statusCode, reasonPhrase, byteArray);
                    a(vVar, httpResponse);
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e2) {
                        throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (entity == null) {
            httpResponse.getStatusLine().getStatusCode();
        }
        return vVar;
    }
}