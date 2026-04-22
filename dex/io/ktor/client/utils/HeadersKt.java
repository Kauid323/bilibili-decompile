package io.ktor.client.utils;

import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: headers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0006\u001a\u00020\u00052\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/http/Headers;", "buildHeaders", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Headers;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HeadersKt {
    public static /* synthetic */ Headers buildHeaders$default(Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.utils.HeadersKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit buildHeaders$lambda$0;
                    buildHeaders$lambda$0 = HeadersKt.buildHeaders$lambda$0((HeadersBuilder) obj2);
                    return buildHeaders$lambda$0;
                }
            };
        }
        return buildHeaders(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHeaders$lambda$0(HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Headers buildHeaders(Function1<? super HeadersBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        function1.invoke(headersBuilder);
        return headersBuilder.m3526build();
    }
}