package io.ktor.http.auth;

import faceverify.q;
import io.ktor.http.CodecsKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.parsing.ParseException;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.Hash;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpAuthHeader.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0004\u000f\u0010\u000e\u0011B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\n\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader;", "", "", "authScheme", "<init>", "(Ljava/lang/String;)V", "Lio/ktor/http/auth/HeaderValueEncoding;", "encoding", "render", "(Lio/ktor/http/auth/HeaderValueEncoding;)Ljava/lang/String;", "()Ljava/lang/String;", "toString", "Ljava/lang/String;", "getAuthScheme", "Companion", "Single", "Parameterized", "Parameters", "Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "Lio/ktor/http/auth/HttpAuthHeader$Single;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HttpAuthHeader {
    public static final Companion Companion = new Companion(null);
    private final String authScheme;

    public /* synthetic */ HttpAuthHeader(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String render();

    public abstract String render(HeaderValueEncoding headerValueEncoding);

    private HttpAuthHeader(String authScheme) {
        this.authScheme = authScheme;
        if (HttpAuthHeaderKt.access$getToken68Pattern$p().matches(this.authScheme)) {
            return;
        }
        throw new ParseException("Invalid authScheme value: it should be token, but instead it is " + this.authScheme, null, 2, null);
    }

    public final String getAuthScheme() {
        return this.authScheme;
    }

    /* compiled from: HttpAuthHeader.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Single;", "Lio/ktor/http/auth/HttpAuthHeader;", "", "authScheme", "blob", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "render", "()Ljava/lang/String;", "Lio/ktor/http/auth/HeaderValueEncoding;", "encoding", "(Lio/ktor/http/auth/HeaderValueEncoding;)Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getBlob", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Single extends HttpAuthHeader {
        private final String blob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Single(String authScheme, String blob) {
            super(authScheme, null);
            Intrinsics.checkNotNullParameter(authScheme, "authScheme");
            Intrinsics.checkNotNullParameter(blob, "blob");
            this.blob = blob;
            if (HttpAuthHeaderKt.access$getToken68Pattern$p().matches(this.blob)) {
                return;
            }
            throw new ParseException("Invalid blob value: it should be token68", null, 2, null);
        }

        public final String getBlob() {
            return this.blob;
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public String render() {
            return getAuthScheme() + ' ' + this.blob;
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public String render(HeaderValueEncoding encoding) {
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            return render();
        }

        public boolean equals(Object other) {
            return (other instanceof Single) && StringsKt.equals(((Single) other).getAuthScheme(), getAuthScheme(), true) && StringsKt.equals(((Single) other).blob, this.blob, true);
        }

        public int hashCode() {
            Hash hash = Hash.INSTANCE;
            String lowerCase = getAuthScheme().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String lowerCase2 = this.blob.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            return hash.combine(new Object[]{lowerCase, lowerCase2});
        }
    }

    /* compiled from: HttpAuthHeader.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "Lio/ktor/http/auth/HttpAuthHeader;", "", "authScheme", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "Lio/ktor/http/auth/HeaderValueEncoding;", "encoding", "<init>", "(Ljava/lang/String;Ljava/util/List;Lio/ktor/http/auth/HeaderValueEncoding;)V", "", "(Ljava/lang/String;Ljava/util/Map;Lio/ktor/http/auth/HeaderValueEncoding;)V", ContentDisposition.Parameters.Name, "value", "withParameter", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "withReplacedParameter", "render", "(Lio/ktor/http/auth/HeaderValueEncoding;)Ljava/lang/String;", "parameter", "(Ljava/lang/String;)Ljava/lang/String;", "encode", "(Ljava/lang/String;Lio/ktor/http/auth/HeaderValueEncoding;)Ljava/lang/String;", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "Lio/ktor/http/auth/HeaderValueEncoding;", "getEncoding", "()Lio/ktor/http/auth/HeaderValueEncoding;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Parameterized extends HttpAuthHeader {
        private final HeaderValueEncoding encoding;
        private final List<HeaderValueParam> parameters;

        /* compiled from: HttpAuthHeader.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HeaderValueEncoding.values().length];
                try {
                    iArr[HeaderValueEncoding.QUOTED_WHEN_REQUIRED.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[HeaderValueEncoding.QUOTED_ALWAYS.ordinal()] = 2;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[HeaderValueEncoding.URI_ENCODE.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Parameterized(String str, List list, HeaderValueEncoding headerValueEncoding, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i2 & 4) != 0 ? HeaderValueEncoding.QUOTED_WHEN_REQUIRED : headerValueEncoding);
        }

        public final List<HeaderValueParam> getParameters() {
            return this.parameters;
        }

        public final HeaderValueEncoding getEncoding() {
            return this.encoding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Parameterized(String authScheme, List<HeaderValueParam> list, HeaderValueEncoding encoding) {
            super(authScheme, null);
            Intrinsics.checkNotNullParameter(authScheme, "authScheme");
            Intrinsics.checkNotNullParameter(list, "parameters");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            this.parameters = list;
            this.encoding = encoding;
            Iterable $this$forEach$iv = this.parameters;
            for (Object element$iv : $this$forEach$iv) {
                HeaderValueParam it = (HeaderValueParam) element$iv;
                if (!HttpAuthHeaderKt.access$getToken68Pattern$p().matches(it.getName())) {
                    throw new ParseException("Parameter name should be a token", null, 2, null);
                }
            }
        }

        public /* synthetic */ Parameterized(String str, Map map, HeaderValueEncoding headerValueEncoding, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, map, (i2 & 4) != 0 ? HeaderValueEncoding.QUOTED_WHEN_REQUIRED : headerValueEncoding);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Parameterized(String authScheme, Map<String, String> map, HeaderValueEncoding encoding) {
            this(authScheme, (List) destination$iv$iv, encoding);
            Intrinsics.checkNotNullParameter(authScheme, "authScheme");
            Intrinsics.checkNotNullParameter(map, "parameters");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            Iterable $this$map$iv = map.entrySet();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Map.Entry it = (Map.Entry) item$iv$iv;
                destination$iv$iv.add(new HeaderValueParam((String) it.getKey(), (String) it.getValue()));
            }
        }

        public final Parameterized withParameter(String name, String value) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(value, "value");
            return new Parameterized(getAuthScheme(), CollectionsKt.plus(this.parameters, new HeaderValueParam(name, value)), this.encoding);
        }

        public final Parameterized withReplacedParameter(String name, String value) {
            HeaderValueParam headerValueParam;
            boolean replaced;
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(value, "value");
            List $this$indexOfFirst$iv = this.parameters;
            int index$iv = 0;
            Iterator<HeaderValueParam> it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                }
                Object item$iv = it.next();
                if (Intrinsics.areEqual(((HeaderValueParam) item$iv).getName(), name)) {
                    break;
                }
                index$iv++;
            }
            int firstIndex = index$iv;
            if (firstIndex == -1) {
                return withParameter(name, value);
            }
            boolean replaced2 = false;
            Iterable $this$mapNotNull$iv = this.parameters;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                HeaderValueParam it2 = (HeaderValueParam) element$iv$iv$iv;
                int firstIndex2 = firstIndex;
                if (!Intrinsics.areEqual(it2.getName(), name)) {
                    replaced = replaced2;
                    headerValueParam = it2;
                } else if (replaced2) {
                    boolean z = replaced2;
                    headerValueParam = null;
                    replaced = z;
                } else {
                    replaced = true;
                    headerValueParam = new HeaderValueParam(name, value);
                }
                if (headerValueParam != null) {
                    destination$iv$iv.add(headerValueParam);
                }
                replaced2 = replaced;
                firstIndex = firstIndex2;
            }
            List newParameters = (List) destination$iv$iv;
            return new Parameterized(getAuthScheme(), newParameters, this.encoding);
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public String render(final HeaderValueEncoding encoding) {
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            if (this.parameters.isEmpty()) {
                return getAuthScheme();
            }
            return CollectionsKt.joinToString$default(this.parameters, ", ", getAuthScheme() + ' ', (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.ktor.http.auth.HttpAuthHeader$Parameterized$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence render$lambda$4;
                    render$lambda$4 = HttpAuthHeader.Parameterized.render$lambda$4(HttpAuthHeader.Parameterized.this, encoding, (HeaderValueParam) obj);
                    return render$lambda$4;
                }
            }, 28, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence render$lambda$4(Parameterized this$0, HeaderValueEncoding $encoding, HeaderValueParam it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getName() + '=' + this$0.encode(it.getValue(), $encoding);
        }

        public final String parameter(String name) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            Iterable $this$firstOrNull$iv = this.parameters;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    HeaderValueParam it2 = (HeaderValueParam) element$iv;
                    if (Intrinsics.areEqual(it2.getName(), name)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            HeaderValueParam headerValueParam = (HeaderValueParam) element$iv;
            if (headerValueParam != null) {
                return headerValueParam.getValue();
            }
            return null;
        }

        private final String encode(String $this$encode, HeaderValueEncoding encoding) {
            switch (WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()]) {
                case 1:
                    return HeaderValueWithParametersKt.escapeIfNeeded($this$encode);
                case 2:
                    return HeaderValueWithParametersKt.quote($this$encode);
                case 3:
                    return CodecsKt.encodeURLParameter$default($this$encode, false, 1, null);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public String render() {
            return render(this.encoding);
        }

        public boolean equals(Object other) {
            return (other instanceof Parameterized) && StringsKt.equals(((Parameterized) other).getAuthScheme(), getAuthScheme(), true) && Intrinsics.areEqual(((Parameterized) other).parameters, this.parameters);
        }

        public int hashCode() {
            Hash hash = Hash.INSTANCE;
            String lowerCase = getAuthScheme().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return hash.combine(new Object[]{lowerCase, this.parameters});
        }
    }

    public String toString() {
        return render();
    }

    /* compiled from: HttpAuthHeader.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Companion;", "", "<init>", "()V", "", Parameters.Realm, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", Parameters.Charset, "Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "basicAuthChallenge", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "scheme", "Lio/ktor/http/auth/HttpAuthHeader;", "bearerAuthChallenge", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader;", "nonce", "", "domain", "opaque", "", "stale", q.KEY_ALGORITHM_CONFIG, "digestAuthChallenge", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Parameterized basicAuthChallenge(String realm, Charset charset) {
            Intrinsics.checkNotNullParameter(realm, Parameters.Realm);
            LinkedHashMap $this$basicAuthChallenge_u24lambda_u240 = new LinkedHashMap();
            $this$basicAuthChallenge_u24lambda_u240.put(Parameters.Realm, realm);
            if (charset != null) {
                $this$basicAuthChallenge_u24lambda_u240.put(Parameters.Charset, CharsetJVMKt.getName(charset));
            }
            return new Parameterized(AuthScheme.Basic, $this$basicAuthChallenge_u24lambda_u240, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ HttpAuthHeader bearerAuthChallenge$default(Companion companion, String str, String str2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            return companion.bearerAuthChallenge(str, str2);
        }

        public final HttpAuthHeader bearerAuthChallenge(String scheme, String realm) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            return new Parameterized(scheme, realm == null ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to(Parameters.Realm, realm)), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }

        public final Parameterized digestAuthChallenge(String realm, String nonce, List<String> list, String opaque, Boolean stale, String algorithm) {
            Intrinsics.checkNotNullParameter(realm, Parameters.Realm);
            Intrinsics.checkNotNullParameter(nonce, "nonce");
            Intrinsics.checkNotNullParameter(list, "domain");
            Intrinsics.checkNotNullParameter(algorithm, q.KEY_ALGORITHM_CONFIG);
            LinkedHashMap $this$digestAuthChallenge_u24lambda_u241 = new LinkedHashMap();
            $this$digestAuthChallenge_u24lambda_u241.put(Parameters.Realm, HeaderValueWithParametersKt.quote(realm));
            $this$digestAuthChallenge_u24lambda_u241.put("nonce", HeaderValueWithParametersKt.quote(nonce));
            if (!list.isEmpty()) {
                $this$digestAuthChallenge_u24lambda_u241.put("domain", HeaderValueWithParametersKt.quote(CollectionsKt.joinToString$default(list, ServerSentEventKt.SPACE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
            }
            if (opaque != null) {
                $this$digestAuthChallenge_u24lambda_u241.put("opaque", HeaderValueWithParametersKt.quote(opaque));
            }
            if (stale != null) {
                $this$digestAuthChallenge_u24lambda_u241.put("stale", stale.toString());
            }
            $this$digestAuthChallenge_u24lambda_u241.put(q.KEY_ALGORITHM_CONFIG, algorithm);
            return new Parameterized(AuthScheme.Digest, $this$digestAuthChallenge_u24lambda_u241, HeaderValueEncoding.QUOTED_WHEN_REQUIRED);
        }
    }

    /* compiled from: HttpAuthHeader.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Parameters;", "", "<init>", "()V", "", "Realm", "Ljava/lang/String;", "Charset", "OAuthCallback", "OAuthConsumerKey", "OAuthNonce", "OAuthToken", "OAuthTokenSecret", "OAuthVerifier", "OAuthSignatureMethod", "OAuthTimestamp", "OAuthVersion", "OAuthSignature", "OAuthCallbackConfirmed", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Parameters {
        public static final String Charset = "charset";
        public static final Parameters INSTANCE = new Parameters();
        public static final String OAuthCallback = "oauth_callback";
        public static final String OAuthCallbackConfirmed = "oauth_callback_confirmed";
        public static final String OAuthConsumerKey = "oauth_consumer_key";
        public static final String OAuthNonce = "oauth_nonce";
        public static final String OAuthSignature = "oauth_signature";
        public static final String OAuthSignatureMethod = "oauth_signature_method";
        public static final String OAuthTimestamp = "oauth_timestamp";
        public static final String OAuthToken = "oauth_token";
        public static final String OAuthTokenSecret = "oauth_token_secret";
        public static final String OAuthVerifier = "oauth_verifier";
        public static final String OAuthVersion = "oauth_version";
        public static final String Realm = "realm";

        private Parameters() {
        }
    }
}