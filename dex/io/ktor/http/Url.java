package io.ktor.http;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Url.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b>\u0018\u0000 L2\u00020\u0001:\u0001LBe\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b$\u0010\u0015R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010*R\u0019\u00103\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b7\u00106R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b8\u0010\u001aR\u001b\u0010<\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010\u0015R\u001b\u0010?\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u0010\u0015R\u001b\u0010B\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u0010\u0015R\u001d\u0010E\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u0010\u0015R\u001d\u0010H\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u00100\u001a\u0004\bG\u0010\u0015R\u001b\u0010K\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u00100\u001a\u0004\bJ\u0010\u0015¨\u0006M"}, d2 = {"Lio/ktor/http/Url;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "specifiedPort", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "user", "password", "", "trailingQuery", "urlString", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getHost", "I", "getSpecifiedPort", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "getFragment", "getUser", "getPassword", "Z", "getTrailingQuery", "()Z", "Ljava/util/List;", "getPathSegments", "()Ljava/util/List;", "getPathSegments$annotations", "()V", "rawSegments", "getRawSegments", "segments$delegate", "Lkotlin/Lazy;", "getSegments", "segments", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "getProtocol", "getPort", "port", "encodedPath$delegate", "getEncodedPath", "encodedPath", "encodedQuery$delegate", "getEncodedQuery", "encodedQuery", "encodedPathAndQuery$delegate", "getEncodedPathAndQuery", "encodedPathAndQuery", "encodedUser$delegate", "getEncodedUser", "encodedUser", "encodedPassword$delegate", "getEncodedPassword", "encodedPassword", "encodedFragment$delegate", "getEncodedFragment", "encodedFragment", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Url {
    public static final Companion Companion = new Companion(null);
    private final Lazy encodedFragment$delegate;
    private final Lazy encodedPassword$delegate;
    private final Lazy encodedPath$delegate;
    private final Lazy encodedPathAndQuery$delegate;
    private final Lazy encodedQuery$delegate;
    private final Lazy encodedUser$delegate;
    private final String fragment;

    /* renamed from: host  reason: collision with root package name */
    private final String f1977host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final URLProtocol protocolOrNull;
    private final List<String> rawSegments;
    private final Lazy segments$delegate;
    private final int specifiedPort;
    private final boolean trailingQuery;
    private final String urlString;
    private final String user;

    @Deprecated(message = "\n        `pathSegments` is deprecated.\n\n        This property will contain an empty path segment at the beginning for URLs with a hostname,\n        and an empty path segment at the end for the URLs with a trailing slash. If you need to keep this behaviour please\n        use [rawSegments]. If you only need to access the meaningful parts of the path, consider using [segments] instead.\n             \n        Please decide if you need [rawSegments] or [segments] explicitly.\n        ", replaceWith = @ReplaceWith(expression = "rawSegments", imports = {}))
    public static /* synthetic */ void getPathSegments$annotations() {
    }

    public Url(URLProtocol protocol, String host2, int specifiedPort, final List<String> list, Parameters parameters, String fragment, String user, String password, boolean trailingQuery, String urlString) {
        Intrinsics.checkNotNullParameter(host2, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        this.f1977host = host2;
        this.specifiedPort = specifiedPort;
        this.parameters = parameters;
        this.fragment = fragment;
        this.user = user;
        this.password = password;
        this.trailingQuery = trailingQuery;
        this.urlString = urlString;
        int i2 = this.specifiedPort;
        boolean z = false;
        if (i2 >= 0 && i2 < 65536) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("Port must be between 0 and 65535, or 0 if not set. Provided: " + this.specifiedPort).toString());
        }
        this.pathSegments = list;
        this.rawSegments = list;
        this.segments$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda0
            public final Object invoke() {
                List segments_delegate$lambda$1;
                segments_delegate$lambda$1 = Url.segments_delegate$lambda$1(list);
                return segments_delegate$lambda$1;
            }
        });
        this.protocolOrNull = protocol;
        URLProtocol uRLProtocol = this.protocolOrNull;
        this.protocol = uRLProtocol == null ? URLProtocol.Companion.getHTTP() : uRLProtocol;
        this.encodedPath$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda1
            public final Object invoke() {
                String encodedPath_delegate$lambda$3;
                encodedPath_delegate$lambda$3 = Url.encodedPath_delegate$lambda$3(list, this);
                return encodedPath_delegate$lambda$3;
            }
        });
        this.encodedQuery$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final Object invoke() {
                String encodedQuery_delegate$lambda$4;
                encodedQuery_delegate$lambda$4 = Url.encodedQuery_delegate$lambda$4(Url.this);
                return encodedQuery_delegate$lambda$4;
            }
        });
        this.encodedPathAndQuery$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda3
            public final Object invoke() {
                String encodedPathAndQuery_delegate$lambda$5;
                encodedPathAndQuery_delegate$lambda$5 = Url.encodedPathAndQuery_delegate$lambda$5(Url.this);
                return encodedPathAndQuery_delegate$lambda$5;
            }
        });
        this.encodedUser$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda4
            public final Object invoke() {
                String encodedUser_delegate$lambda$6;
                encodedUser_delegate$lambda$6 = Url.encodedUser_delegate$lambda$6(Url.this);
                return encodedUser_delegate$lambda$6;
            }
        });
        this.encodedPassword$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda5
            public final Object invoke() {
                String encodedPassword_delegate$lambda$7;
                encodedPassword_delegate$lambda$7 = Url.encodedPassword_delegate$lambda$7(Url.this);
                return encodedPassword_delegate$lambda$7;
            }
        });
        this.encodedFragment$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.Url$$ExternalSyntheticLambda6
            public final Object invoke() {
                String encodedFragment_delegate$lambda$8;
                encodedFragment_delegate$lambda$8 = Url.encodedFragment_delegate$lambda$8(Url.this);
                return encodedFragment_delegate$lambda$8;
            }
        });
    }

    public final String getHost() {
        return this.f1977host;
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getFragment() {
        return this.fragment;
    }

    public final String getUser() {
        return this.user;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final List<String> getPathSegments() {
        return this.pathSegments;
    }

    public final List<String> getRawSegments() {
        return this.rawSegments;
    }

    public final List<String> getSegments() {
        return (List) this.segments$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List segments_delegate$lambda$1(List $pathSegments) {
        if ($pathSegments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        int start = (!(((CharSequence) CollectionsKt.first($pathSegments)).length() == 0) || $pathSegments.size() <= 1) ? 0 : 1;
        int end = ((CharSequence) CollectionsKt.last($pathSegments)).length() == 0 ? CollectionsKt.getLastIndex($pathSegments) : CollectionsKt.getLastIndex($pathSegments) + 1;
        return $pathSegments.subList(start, end);
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final int getPort() {
        Integer valueOf = Integer.valueOf(this.specifiedPort);
        int it = valueOf.intValue();
        if (it == 0) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final String getEncodedPath() {
        return (String) this.encodedPath$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPath_delegate$lambda$3(List $pathSegments, Url this$0) {
        int pathStartIndex;
        if ($pathSegments.isEmpty() || (pathStartIndex = StringsKt.indexOf$default(this$0.urlString, '/', this$0.protocol.getName().length() + 3, false, 4, (Object) null)) == -1) {
            return "";
        }
        int pathEndIndex = StringsKt.indexOfAny$default(this$0.urlString, new char[]{'?', '#'}, pathStartIndex, false, 4, (Object) null);
        if (pathEndIndex == -1) {
            String substring = this$0.urlString.substring(pathStartIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        String substring2 = this$0.urlString.substring(pathStartIndex, pathEndIndex);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    public final String getEncodedQuery() {
        return (String) this.encodedQuery$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedQuery_delegate$lambda$4(Url this$0) {
        int queryStart = StringsKt.indexOf$default(this$0.urlString, '?', 0, false, 6, (Object) null) + 1;
        if (queryStart == 0) {
            return "";
        }
        int queryEnd = StringsKt.indexOf$default(this$0.urlString, '#', queryStart, false, 4, (Object) null);
        if (queryEnd == -1) {
            String substring = this$0.urlString.substring(queryStart);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        String substring2 = this$0.urlString.substring(queryStart, queryEnd);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    public final String getEncodedPathAndQuery() {
        return (String) this.encodedPathAndQuery$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPathAndQuery_delegate$lambda$5(Url this$0) {
        int pathStart = StringsKt.indexOf$default(this$0.urlString, '/', this$0.protocol.getName().length() + 3, false, 4, (Object) null);
        if (pathStart == -1) {
            return "";
        }
        int queryEnd = StringsKt.indexOf$default(this$0.urlString, '#', pathStart, false, 4, (Object) null);
        if (queryEnd == -1) {
            String substring = this$0.urlString.substring(pathStart);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        String substring2 = this$0.urlString.substring(pathStart, queryEnd);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedUser_delegate$lambda$6(Url this$0) {
        if (this$0.user == null) {
            return null;
        }
        if (this$0.user.length() == 0) {
            return "";
        }
        int usernameStart = this$0.protocol.getName().length() + 3;
        int usernameEnd = StringsKt.indexOfAny$default(this$0.urlString, new char[]{':', '@'}, usernameStart, false, 4, (Object) null);
        String substring = this$0.urlString.substring(usernameStart, usernameEnd);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPassword_delegate$lambda$7(Url this$0) {
        if (this$0.password == null) {
            return null;
        }
        if (this$0.password.length() == 0) {
            return "";
        }
        int passwordStart = StringsKt.indexOf$default(this$0.urlString, ':', this$0.protocol.getName().length() + 3, false, 4, (Object) null) + 1;
        int passwordEnd = StringsKt.indexOf$default(this$0.urlString, '@', 0, false, 6, (Object) null);
        String substring = this$0.urlString.substring(passwordStart, passwordEnd);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String getEncodedFragment() {
        return (String) this.encodedFragment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedFragment_delegate$lambda$8(Url this$0) {
        int fragmentStart = StringsKt.indexOf$default(this$0.urlString, '#', 0, false, 6, (Object) null) + 1;
        if (fragmentStart == 0) {
            return "";
        }
        String substring = this$0.urlString.substring(fragmentStart);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public String toString() {
        return this.urlString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Url url = (Url) other;
        return Intrinsics.areEqual(this.urlString, ((Url) other).urlString);
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }

    /* compiled from: Url.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "<init>", "()V", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}