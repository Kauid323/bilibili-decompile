package io.ktor.http;

import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpProtocolVersion.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001a\u0010\r¨\u0006\u001c"}, d2 = {"Lio/ktor/http/HttpProtocolVersion;", "", "", ContentDisposition.Parameters.Name, "", "major", "minor", "<init>", "(Ljava/lang/String;II)V", "toString", "()Ljava/lang/String;", "component1", "component2", "()I", "component3", "copy", "(Ljava/lang/String;II)Lio/ktor/http/HttpProtocolVersion;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Ljava/lang/String;", "getName", "I", "getMajor", "getMinor", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpProtocolVersion {
    private final int major;
    private final int minor;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final HttpProtocolVersion HTTP_2_0 = new HttpProtocolVersion("HTTP", 2, 0);
    private static final HttpProtocolVersion HTTP_1_1 = new HttpProtocolVersion("HTTP", 1, 1);
    private static final HttpProtocolVersion HTTP_1_0 = new HttpProtocolVersion("HTTP", 1, 0);
    private static final HttpProtocolVersion SPDY_3 = new HttpProtocolVersion("SPDY", 3, 0);
    private static final HttpProtocolVersion QUIC = new HttpProtocolVersion("QUIC", 1, 0);

    public static /* synthetic */ HttpProtocolVersion copy$default(HttpProtocolVersion httpProtocolVersion, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = httpProtocolVersion.name;
        }
        if ((i4 & 2) != 0) {
            i2 = httpProtocolVersion.major;
        }
        if ((i4 & 4) != 0) {
            i3 = httpProtocolVersion.minor;
        }
        return httpProtocolVersion.copy(str, i2, i3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.major;
    }

    public final int component3() {
        return this.minor;
    }

    public final HttpProtocolVersion copy(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return new HttpProtocolVersion(str, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpProtocolVersion) {
            HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
            return Intrinsics.areEqual(this.name, httpProtocolVersion.name) && this.major == httpProtocolVersion.major && this.minor == httpProtocolVersion.minor;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.major) * 31) + this.minor;
    }

    /* compiled from: HttpProtocolVersion.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lio/ktor/http/HttpProtocolVersion$Companion;", "", "<init>", "()V", "", ContentDisposition.Parameters.Name, "", "major", "minor", "Lio/ktor/http/HttpProtocolVersion;", "fromValue", "(Ljava/lang/String;II)Lio/ktor/http/HttpProtocolVersion;", "", "value", "parse", "(Ljava/lang/CharSequence;)Lio/ktor/http/HttpProtocolVersion;", "HTTP_2_0", "Lio/ktor/http/HttpProtocolVersion;", "getHTTP_2_0", "()Lio/ktor/http/HttpProtocolVersion;", "HTTP_1_1", "getHTTP_1_1", "HTTP_1_0", "getHTTP_1_0", "SPDY_3", "getSPDY_3", "QUIC", "getQUIC", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpProtocolVersion getHTTP_2_0() {
            return HttpProtocolVersion.HTTP_2_0;
        }

        public final HttpProtocolVersion getHTTP_1_1() {
            return HttpProtocolVersion.HTTP_1_1;
        }

        public final HttpProtocolVersion getHTTP_1_0() {
            return HttpProtocolVersion.HTTP_1_0;
        }

        public final HttpProtocolVersion getSPDY_3() {
            return HttpProtocolVersion.SPDY_3;
        }

        public final HttpProtocolVersion getQUIC() {
            return HttpProtocolVersion.QUIC;
        }

        public final HttpProtocolVersion fromValue(String name, int major, int minor) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            return (Intrinsics.areEqual(name, "HTTP") && major == 1 && minor == 0) ? getHTTP_1_0() : (Intrinsics.areEqual(name, "HTTP") && major == 1 && minor == 1) ? getHTTP_1_1() : (Intrinsics.areEqual(name, "HTTP") && major == 2 && minor == 0) ? getHTTP_2_0() : new HttpProtocolVersion(name, major, minor);
        }

        public final HttpProtocolVersion parse(CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            List it = StringsKt.split$default(value, new String[]{"/", "."}, false, 0, 6, (Object) null);
            if (it.size() == 3) {
                String protocol = (String) it.get(0);
                String major = (String) it.get(1);
                String minor = (String) it.get(2);
                return fromValue(protocol, Integer.parseInt(major), Integer.parseInt(minor));
            }
            throw new IllegalStateException(("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: " + ((Object) value)).toString());
        }
    }

    public HttpProtocolVersion(String name, int major, int minor) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        this.name = name;
        this.major = major;
        this.minor = minor;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + '/' + this.major + ClassUtils.PACKAGE_SEPARATOR_CHAR + this.minor;
    }
}