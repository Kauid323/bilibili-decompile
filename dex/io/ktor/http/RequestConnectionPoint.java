package io.ktor.http;

import com.xiaomi.mipush.sdk.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: RequestConnectionPoint.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\r\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004R\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0004R\u0014\u0010$\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u0014\u0010&\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0004¨\u0006'"}, d2 = {"Lio/ktor/http/RequestConnectionPoint;", "", "", "getScheme", "()Ljava/lang/String;", "scheme", "getVersion", Constants.VERSION, "", "getPort", "()I", "getPort$annotations", "()V", "port", "getLocalPort", "localPort", "getServerPort", "serverPort", "getHost", "getHost$annotations", "host", "getLocalHost", "localHost", "getServerHost", "serverHost", "getLocalAddress", "localAddress", "getUri", "uri", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "getRemoteHost", "remoteHost", "getRemotePort", "remotePort", "getRemoteAddress", "remoteAddress", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RequestConnectionPoint {

    /* compiled from: RequestConnectionPoint.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use localHost or serverHost instead")
        public static /* synthetic */ void getHost$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use localPort or serverPort instead")
        public static /* synthetic */ void getPort$annotations() {
        }
    }

    String getHost();

    String getLocalAddress();

    String getLocalHost();

    int getLocalPort();

    HttpMethod getMethod();

    int getPort();

    String getRemoteAddress();

    String getRemoteHost();

    int getRemotePort();

    String getScheme();

    String getServerHost();

    int getServerPort();

    String getUri();

    String getVersion();
}