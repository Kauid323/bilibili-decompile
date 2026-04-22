package facadeverify;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import io.grpc.internal.GrpcUtil;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;

public class c extends b {

    /* renamed from: g  reason: collision with root package name */
    public static AndroidHttpClient f1907g;
    public Context a;
    public String b;
    public HttpRequest c;

    /* renamed from: d  reason: collision with root package name */
    public HttpResponse f1908d;

    /* renamed from: e  reason: collision with root package name */
    public long f1909e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f1910f = -1;

    public c(String str, Context context) {
        this.a = context;
        this.b = str;
    }

    public void a() {
        InputStream content;
        this.f1909e = -1L;
        this.f1910f = -1L;
        HttpGet httpGet = this.c;
        if (httpGet != null) {
            try {
                if (httpGet instanceof HttpGet) {
                    httpGet.abort();
                } else if (httpGet instanceof HttpPost) {
                    ((HttpPost) httpGet).abort();
                }
            } catch (Throwable th) {
            }
            this.c = null;
        }
        HttpResponse httpResponse = this.f1908d;
        if (httpResponse != null) {
            try {
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (content = entity.getContent()) != null) {
                    content.close();
                }
            } catch (Throwable th2) {
            }
            this.f1908d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0072 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #4 {all -> 0x007d, blocks: (B:39:0x0068, B:41:0x0072), top: B:57:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        NetworkInfo activeNetworkInfo;
        String defaultHost;
        if (f1907g == null) {
            synchronized (c.class) {
                if (f1907g == null) {
                    try {
                        f1907g = AndroidHttpClient.newInstance("alipay", this.a);
                        HttpParams params = f1907g.getParams();
                        if (params != null) {
                            params.setParameter("http.connection.timeout", 30000);
                            params.setParameter("http.socket.timeout", 300000);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
        AndroidHttpClient androidHttpClient = f1907g;
        if (androidHttpClient != null) {
            try {
                HttpParams params2 = androidHttpClient.getParams();
                if (params2 != null) {
                    Context context = this.a;
                    HttpHost httpHost = null;
                    if (context != null) {
                        try {
                            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        } catch (Throwable th2) {
                        }
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0) {
                            try {
                                defaultHost = Proxy.getDefaultHost();
                                if (!TextUtils.isEmpty(defaultHost)) {
                                    httpHost = new HttpHost(defaultHost, Proxy.getDefaultPort());
                                }
                            } catch (Throwable th3) {
                            }
                        }
                        params2.setParameter("http.route.default-proxy", httpHost);
                    }
                    activeNetworkInfo = null;
                    if (activeNetworkInfo != null) {
                        defaultHost = Proxy.getDefaultHost();
                        if (!TextUtils.isEmpty(defaultHost)) {
                        }
                    }
                    params2.setParameter("http.route.default-proxy", httpHost);
                }
            } catch (Throwable th4) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(3:49|50|(1:52)(12:53|(3:7|(2:10|8)|11)|12|13|(8:45|46|(2:17|(1:19)(2:20|(9:22|(2:24|(1:26)(1:27))|28|29|30|31|32|33|34)))|44|31|32|33|34)|15|(0)|44|31|32|33|34))|3|(4:5|7|(1:8)|11)|12|13|(0)|15|(0)|44|31|32|33|34|(1:(1:39))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
        r3.f1908d = facadeverify.c.f1907g.execute(r5, r3.c, new org.apache.http.protocol.BasicHttpContext());
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[Catch: all -> 0x00bd, LOOP:0: B:13:0x0038->B:15:0x003e, LOOP_END, TryCatch #3 {all -> 0x00bd, blocks: (B:4:0x0005, B:7:0x0009, B:10:0x002a, B:12:0x0030, B:13:0x0038, B:15:0x003e, B:16:0x0056, B:26:0x0070, B:29:0x007b, B:32:0x0086, B:34:0x008c, B:41:0x00a1, B:44:0x00ad, B:8:0x001f), top: B:56:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[Catch: all -> 0x00bd, TRY_ENTER, TryCatch #3 {all -> 0x00bd, blocks: (B:4:0x0005, B:7:0x0009, B:10:0x002a, B:12:0x0030, B:13:0x0038, B:15:0x003e, B:16:0x0056, B:26:0x0070, B:29:0x007b, B:32:0x0086, B:34:0x008c, B:41:0x00a1, B:44:0x00ad, B:8:0x001f), top: B:56:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse a(byte[] bArr, Map<String, String> map) {
        URL url;
        a();
        if (bArr != null) {
            try {
            } catch (Throwable th) {
                a();
            }
            if (bArr.length != 0) {
                HttpPost httpPost = new HttpPost(this.b);
                httpPost.setEntity(new ByteArrayEntity(bArr));
                this.f1909e = bArr.length;
                this.c = httpPost;
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.c.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                b();
                HttpHost httpHost = null;
                if (!TextUtils.isEmpty(this.b)) {
                    try {
                        url = new URL(this.b);
                    } catch (Throwable th2) {
                    }
                    if (url != null) {
                        String host2 = url.getHost();
                        if (!TextUtils.isEmpty(host2)) {
                            String protocol = url.getProtocol();
                            if (!TextUtils.isEmpty(protocol)) {
                                int port = url.getPort();
                                if (port <= 0) {
                                    port = "https".equalsIgnoreCase(protocol) ? GrpcUtil.DEFAULT_PORT_SSL : 80;
                                }
                                try {
                                    httpHost = new HttpHost(host2, port, protocol);
                                } catch (Throwable th3) {
                                }
                                this.f1908d = f1907g.execute(httpHost, this.c);
                                return this.f1908d;
                            }
                        }
                    }
                    this.f1908d = f1907g.execute(httpHost, this.c);
                    return this.f1908d;
                }
                url = null;
                if (url != null) {
                }
                this.f1908d = f1907g.execute(httpHost, this.c);
                return this.f1908d;
            }
        }
        this.c = new HttpGet(this.b);
        if (map != null) {
            while (r4.hasNext()) {
            }
        }
        b();
        HttpHost httpHost2 = null;
        if (!TextUtils.isEmpty(this.b)) {
        }
        url = null;
        if (url != null) {
        }
        this.f1908d = f1907g.execute(httpHost2, this.c);
        return this.f1908d;
    }
}