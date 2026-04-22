package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0006\u001a#\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0001\u0010\t\u001aE\u0010\u0001\u001a\u00020\u000026\u0010\f\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b0\n\"\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b¢\u0006\u0004\b\u0001\u0010\r\u001a&\u0010\u0013\u001a\u00020\u00002\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/http/Headers;", "headersOf", "()Lio/ktor/http/Headers;", "", ContentDisposition.Parameters.Name, "value", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/Headers;", "", "values", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/Headers;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lio/ktor/http/Headers;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "headers", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Headers;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HeadersKt {
    public static final Headers headersOf() {
        return Headers.Companion.getEmpty();
    }

    public static final Headers headersOf(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        return new HeadersSingleImpl(name, CollectionsKt.listOf(value));
    }

    public static final Headers headersOf(String name, List<String> list) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "values");
        return new HeadersSingleImpl(name, list);
    }

    public static final Headers headersOf(Pair<String, ? extends List<String>>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return new HeadersImpl(MapsKt.toMap(ArraysKt.asList(pairArr)));
    }

    public static final Headers headers(Function1<? super HeadersBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        Headers.Companion companion = Headers.Companion;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        function1.invoke(headersBuilder);
        return headersBuilder.m3526build();
    }
}