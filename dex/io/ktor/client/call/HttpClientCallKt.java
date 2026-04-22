package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: HttpClientCall.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086H¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0004H\u0086H¢\u0006\u0004\b\u0002\u0010\u0005\u001a\"\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"T", "Lio/ktor/client/call/HttpClientCall;", "body", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientCallKt {
    public static final /* synthetic */ <T> Object body(HttpClientCall $this$body, Continuation<? super T> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object bodyNullable = $this$body.bodyNullable(typeInfo, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return bodyNullable;
    }

    public static final /* synthetic */ <T> Object body(HttpResponse $this$body, Continuation<? super T> continuation) {
        HttpClientCall call = $this$body.getCall();
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object bodyNullable = call.bodyNullable(typeInfo, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return bodyNullable;
    }

    public static final <T> Object body(HttpResponse $this$body, TypeInfo typeInfo, Continuation<? super T> continuation) {
        Object bodyNullable = $this$body.getCall().bodyNullable(typeInfo, continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return bodyNullable;
    }
}