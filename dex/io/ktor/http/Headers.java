package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Headers;", "Lio/ktor/util/StringValues;", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Headers extends StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Headers.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static boolean contains(Headers $this, String name) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.contains($this, name);
        }

        public static boolean contains(Headers $this, String name, String value) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(value, "value");
            return StringValues.DefaultImpls.contains($this, name, value);
        }

        public static void forEach(Headers $this, Function2<? super String, ? super List<String>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            StringValues.DefaultImpls.forEach($this, function2);
        }

        public static String get(Headers $this, String name) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.get($this, name);
        }
    }

    /* compiled from: Headers.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lio/ktor/http/Headers$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Lio/ktor/http/Headers;", "build", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Headers;", "Empty", "Lio/ktor/http/Headers;", "getEmpty", "()Lio/ktor/http/Headers;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Headers Empty = EmptyHeaders.INSTANCE;

        private Companion() {
        }

        public final Headers getEmpty() {
            return Empty;
        }

        public final Headers build(Function1<? super HeadersBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            function1.invoke(headersBuilder);
            return headersBuilder.m3526build();
        }
    }
}