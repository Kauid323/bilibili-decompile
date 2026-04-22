package io.ktor.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLBuilder.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0001RBm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u001fR(\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u001fR$\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u001fR(\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u001fR\"\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001c\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u001fR$\u0010\u000e\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u001fR(\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR*\u0010K\u001a\u00020J2\u0006\u0010%\u001a\u00020J8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\r\u001a\u00020J2\u0006\u0010%\u001a\u00020J8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010L\u001a\u0004\bQ\u0010N¨\u0006S"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "port", "user", "password", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "", "trailingQuery", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Z)V", "buildString", "()Ljava/lang/String;", "toString", "Lio/ktor/http/Url;", "build", "()Lio/ktor/http/Url;", "", "applyOrigin", "()V", "Ljava/lang/String;", "getHost", "setHost", "(Ljava/lang/String;)V", "Z", "getTrailingQuery", "()Z", "setTrailingQuery", "(Z)V", "value", "I", "getPort", "()I", "setPort", "(I)V", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "setProtocolOrNull", "(Lio/ktor/http/URLProtocol;)V", "getProtocol", "setProtocol", "encodedUser", "getEncodedUser", "setEncodedUser", "getUser", "setUser", "encodedPassword", "getEncodedPassword", "setEncodedPassword", "getPassword", "setPassword", "encodedFragment", "getEncodedFragment", "setEncodedFragment", "getFragment", "setFragment", "encodedPathSegments", "Ljava/util/List;", "getEncodedPathSegments", "()Ljava/util/List;", "setEncodedPathSegments", "(Ljava/util/List;)V", "getPathSegments", "setPathSegments", "Lio/ktor/http/ParametersBuilder;", "encodedParameters", "Lio/ktor/http/ParametersBuilder;", "getEncodedParameters", "()Lio/ktor/http/ParametersBuilder;", "setEncodedParameters", "(Lio/ktor/http/ParametersBuilder;)V", "getParameters", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class URLBuilder {
    public static final Companion Companion = new Companion(null);
    private static final Url originUrl = URLUtilsKt.Url(URLBuilderJvmKt.getOrigin(Companion));
    private String encodedFragment;
    private ParametersBuilder encodedParameters;
    private String encodedPassword;
    private List<String> encodedPathSegments;
    private String encodedUser;

    /* renamed from: host  reason: collision with root package name */
    private String f1976host;
    private ParametersBuilder parameters;
    private int port;
    private URLProtocol protocolOrNull;
    private boolean trailingQuery;

    public URLBuilder() {
        this(null, null, 0, null, null, null, null, null, false, 511, null);
    }

    public URLBuilder(URLProtocol protocol, String host2, int port, String user, String password, List<String> list, Parameters parameters, String fragment, boolean trailingQuery) {
        Intrinsics.checkNotNullParameter(host2, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f1976host = host2;
        this.trailingQuery = trailingQuery;
        this.port = port;
        this.protocolOrNull = protocol;
        this.encodedUser = user != null ? CodecsKt.encodeURLParameter$default(user, false, 1, null) : null;
        this.encodedPassword = password != null ? CodecsKt.encodeURLParameter$default(password, false, 1, null) : null;
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(fragment, false, false, null, 7, null);
        List<String> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.encodeURLPathPart(it));
        }
        this.encodedPathSegments = (List) destination$iv$iv;
        this.encodedParameters = UrlDecodedParametersBuilderKt.encodeParameters(parameters);
        this.parameters = new UrlDecodedParametersBuilder(this.encodedParameters);
    }

    public /* synthetic */ URLBuilder(URLProtocol uRLProtocol, String str, int i2, String str2, String str3, List list, Parameters parameters, String str4, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : uRLProtocol, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) == 0 ? str3 : null, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? Parameters.Companion.getEmpty() : parameters, (i3 & 128) == 0 ? str4 : "", (i3 & 256) == 0 ? z : false);
    }

    public final String getHost() {
        return this.f1976host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1976host = str;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final void setTrailingQuery(boolean z) {
        this.trailingQuery = z;
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int value) {
        boolean z = false;
        if (value >= 0 && value < 65536) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("Port must be between 0 and 65535, or 0 if not set. Provided: " + value).toString());
        }
        this.port = value;
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final void setProtocolOrNull(URLProtocol uRLProtocol) {
        this.protocolOrNull = uRLProtocol;
    }

    public final URLProtocol getProtocol() {
        URLProtocol uRLProtocol = this.protocolOrNull;
        return uRLProtocol == null ? URLProtocol.Companion.getHTTP() : uRLProtocol;
    }

    public final void setProtocol(URLProtocol value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.protocolOrNull = value;
    }

    public final String getEncodedUser() {
        return this.encodedUser;
    }

    public final void setEncodedUser(String str) {
        this.encodedUser = str;
    }

    public final String getUser() {
        String str = this.encodedUser;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setUser(String value) {
        this.encodedUser = value != null ? CodecsKt.encodeURLParameter$default(value, false, 1, null) : null;
    }

    public final String getEncodedPassword() {
        return this.encodedPassword;
    }

    public final void setEncodedPassword(String str) {
        this.encodedPassword = str;
    }

    public final String getPassword() {
        String str = this.encodedPassword;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setPassword(String value) {
        this.encodedPassword = value != null ? CodecsKt.encodeURLParameter$default(value, false, 1, null) : null;
    }

    public final String getEncodedFragment() {
        return this.encodedFragment;
    }

    public final void setEncodedFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encodedFragment = str;
    }

    public final String getFragment() {
        return CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, null, 15, null);
    }

    public final void setFragment(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(value, false, false, null, 7, null);
    }

    public final List<String> getEncodedPathSegments() {
        return this.encodedPathSegments;
    }

    public final void setEncodedPathSegments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.encodedPathSegments = list;
    }

    public final List<String> getPathSegments() {
        Iterable $this$map$iv = this.encodedPathSegments;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.decodeURLPart$default(it, 0, 0, null, 7, null));
        }
        return (List) destination$iv$iv;
    }

    public final void setPathSegments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        List<String> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.encodeURLPathPart(it));
        }
        this.encodedPathSegments = (List) destination$iv$iv;
    }

    public final ParametersBuilder getEncodedParameters() {
        return this.encodedParameters;
    }

    public final void setEncodedParameters(ParametersBuilder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParameters = value;
        this.parameters = new UrlDecodedParametersBuilder(value);
    }

    public final ParametersBuilder getParameters() {
        return this.parameters;
    }

    public final String buildString() {
        applyOrigin();
        String sb = ((StringBuilder) URLBuilderKt.access$appendTo(this, new StringBuilder(256))).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public String toString() {
        String sb = ((StringBuilder) URLBuilderKt.access$appendTo(this, new StringBuilder(256))).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public final Url build() {
        applyOrigin();
        return new Url(this.protocolOrNull, this.f1976host, this.port, getPathSegments(), this.parameters.build(), getFragment(), getUser(), getPassword(), this.trailingQuery, buildString());
    }

    private final void applyOrigin() {
        if ((this.f1976host.length() > 0) || Intrinsics.areEqual(getProtocol().getName(), "file")) {
            return;
        }
        this.f1976host = originUrl.getHost();
        if (this.protocolOrNull == null) {
            this.protocolOrNull = originUrl.getProtocolOrNull();
        }
        if (this.port == 0) {
            setPort(originUrl.getSpecifiedPort());
        }
    }

    /* compiled from: URLBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/URLBuilder$Companion;", "", "<init>", "()V", "Lio/ktor/http/Url;", "originUrl", "Lio/ktor/http/Url;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}