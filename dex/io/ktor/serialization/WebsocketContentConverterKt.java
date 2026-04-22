package io.ktor.serialization;

import faceverify.q;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Charsets;

/* compiled from: WebsocketContentConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0007\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00028\u00002\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\n\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0086H¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"T", "Lio/ktor/serialization/WebsocketContentConverter;", "value", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/websocket/Frame;", "serialize", "(Lio/ktor/serialization/WebsocketContentConverter;Ljava/lang/Object;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", q.KEY_RES_9_CONTENT, "deserialize", "(Lio/ktor/serialization/WebsocketContentConverter;Lio/ktor/websocket/Frame;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WebsocketContentConverterKt {
    public static /* synthetic */ Object serialize$default(WebsocketContentConverter $this$serialize_u24default, Object value, Charset charset, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object serialize = $this$serialize_u24default.serialize(charset, typeInfo, value, $completion);
        InlineMarker.mark(1);
        return serialize;
    }

    public static final /* synthetic */ <T> Object serialize(WebsocketContentConverter $this$serialize, T t, Charset charset, Continuation<? super Frame> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object serialize = $this$serialize.serialize(charset, typeInfo, t, continuation);
        InlineMarker.mark(1);
        return serialize;
    }

    public static /* synthetic */ Object deserialize$default(WebsocketContentConverter $this$deserialize_u24default, Frame content, Charset charset, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object deserialize = $this$deserialize_u24default.deserialize(charset, typeInfo, content, $completion);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return deserialize;
    }

    public static final /* synthetic */ <T> Object deserialize(WebsocketContentConverter $this$deserialize, Frame content, Charset charset, Continuation<? super T> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object deserialize = $this$deserialize.deserialize(charset, typeInfo, content, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return deserialize;
    }
}