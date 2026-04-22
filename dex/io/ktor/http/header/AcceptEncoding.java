package io.ktor.http.header;

import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AcceptEncoding.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/http/header/AcceptEncoding;", "Lio/ktor/http/HeaderValueWithParameters;", "", "acceptEncoding", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "", "qValue", "(Ljava/lang/String;D)V", "withQValue", "(D)Lio/ktor/http/header/AcceptEncoding;", "pattern", "", "match", "(Lio/ktor/http/header/AcceptEncoding;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getAcceptEncoding", "()Ljava/lang/String;", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AcceptEncoding extends HeaderValueWithParameters {
    private final String acceptEncoding;
    public static final Companion Companion = new Companion(null);
    private static final AcceptEncoding Gzip = new AcceptEncoding("gzip", null, 2, null);
    private static final AcceptEncoding Compress = new AcceptEncoding("compress", null, 2, null);
    private static final AcceptEncoding Deflate = new AcceptEncoding("deflate", null, 2, null);
    private static final AcceptEncoding Br = new AcceptEncoding("br", null, 2, null);
    private static final AcceptEncoding Zstd = new AcceptEncoding("zstd", null, 2, null);
    private static final AcceptEncoding Identity = new AcceptEncoding("identity", null, 2, null);
    private static final AcceptEncoding All = new AcceptEncoding("*", null, 2, null);

    public /* synthetic */ AcceptEncoding(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String acceptEncoding, List<HeaderValueParam> list) {
        super(acceptEncoding, list);
        Intrinsics.checkNotNullParameter(acceptEncoding, "acceptEncoding");
        Intrinsics.checkNotNullParameter(list, "parameters");
        this.acceptEncoding = acceptEncoding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String acceptEncoding, double qValue) {
        this(acceptEncoding, CollectionsKt.listOf(new HeaderValueParam("q", String.valueOf(qValue))));
        Intrinsics.checkNotNullParameter(acceptEncoding, "acceptEncoding");
    }

    /* compiled from: AcceptEncoding.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lio/ktor/http/header/AcceptEncoding$Companion;", "", "<init>", "()V", "", "Lio/ktor/http/header/AcceptEncoding;", "encodings", "", "mergeAcceptEncodings", "([Lio/ktor/http/header/AcceptEncoding;)Ljava/lang/String;", "Gzip", "Lio/ktor/http/header/AcceptEncoding;", "getGzip", "()Lio/ktor/http/header/AcceptEncoding;", "Compress", "getCompress", "Deflate", "getDeflate", "Br", "getBr", "Zstd", "getZstd", "Identity", "getIdentity", "All", "getAll", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AcceptEncoding getGzip() {
            return AcceptEncoding.Gzip;
        }

        public final AcceptEncoding getCompress() {
            return AcceptEncoding.Compress;
        }

        public final AcceptEncoding getDeflate() {
            return AcceptEncoding.Deflate;
        }

        public final AcceptEncoding getBr() {
            return AcceptEncoding.Br;
        }

        public final AcceptEncoding getZstd() {
            return AcceptEncoding.Zstd;
        }

        public final AcceptEncoding getIdentity() {
            return AcceptEncoding.Identity;
        }

        public final AcceptEncoding getAll() {
            return AcceptEncoding.All;
        }

        public final String mergeAcceptEncodings(AcceptEncoding... encodings) {
            Intrinsics.checkNotNullParameter(encodings, "encodings");
            return ArraysKt.joinToString$default(encodings, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    public final AcceptEncoding withQValue(double qValue) {
        if (Intrinsics.areEqual(String.valueOf(qValue), parameter("q"))) {
            return this;
        }
        return new AcceptEncoding(this.acceptEncoding, qValue);
    }

    public final boolean match(AcceptEncoding pattern) {
        boolean equals;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (Intrinsics.areEqual(pattern.acceptEncoding, "*") || StringsKt.equals(pattern.acceptEncoding, this.acceptEncoding, true)) {
            for (HeaderValueParam headerValueParam : pattern.getParameters()) {
                String patternName = headerValueParam.component1();
                String patternValue = headerValueParam.component2();
                if (Intrinsics.areEqual(patternName, "*")) {
                    if (Intrinsics.areEqual(patternValue, "*")) {
                        equals = true;
                    } else {
                        Iterable $this$any$iv = getParameters();
                        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                            Iterator<T> it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv = it.next();
                                    HeaderValueParam p = (HeaderValueParam) element$iv;
                                    if (StringsKt.equals(p.getValue(), patternValue, true)) {
                                        equals = true;
                                        break;
                                    }
                                } else {
                                    equals = false;
                                    break;
                                }
                            }
                        } else {
                            equals = false;
                        }
                    }
                } else {
                    String value = parameter(patternName);
                    if (Intrinsics.areEqual(patternValue, "*")) {
                        equals = value != null;
                    } else {
                        equals = StringsKt.equals(value, patternValue, true);
                    }
                }
                boolean matches = equals;
                if (!matches) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof AcceptEncoding) && StringsKt.equals(this.acceptEncoding, ((AcceptEncoding) other).acceptEncoding, true) && Intrinsics.areEqual(getParameters(), ((AcceptEncoding) other).getParameters());
    }

    public int hashCode() {
        String lowerCase = this.acceptEncoding.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        return hashCode + (getParameters().hashCode() * 31);
    }
}