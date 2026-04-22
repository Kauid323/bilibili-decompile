package io.ktor.client.request;

import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: RequestBody.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\t\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"T", "Lio/ktor/client/request/HttpRequestBuilder;", "body", "", "setBody", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;)V", "", "Lio/ktor/util/reflect/TypeInfo;", "bodyType", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;)V", "Lio/ktor/util/AttributeKey;", "BodyTypeAttributeKey", "Lio/ktor/util/AttributeKey;", "getBodyTypeAttributeKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RequestBodyKt {
    private static final AttributeKey<TypeInfo> BodyTypeAttributeKey;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TypeInfo.class);
        try {
            kType = Reflection.typeOf(TypeInfo.class);
        } catch (Throwable th) {
            kType = null;
        }
        BodyTypeAttributeKey = new AttributeKey<>("BodyTypeAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final AttributeKey<TypeInfo> getBodyTypeAttributeKey() {
        return BodyTypeAttributeKey;
    }

    public static final /* synthetic */ <T> void setBody(HttpRequestBuilder $this$setBody, T t) {
        Intrinsics.checkNotNullParameter($this$setBody, "<this>");
        if (t == null) {
            $this$setBody.setBody(NullBody.INSTANCE);
            Intrinsics.reifiedOperationMarker(4, "T");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                Intrinsics.reifiedOperationMarker(6, "T");
            } catch (Throwable th) {
            }
            $this$setBody.setBodyType(new TypeInfo(orCreateKotlinClass, (KType) null));
        } else if (t instanceof OutgoingContent) {
            $this$setBody.setBody(t);
            $this$setBody.setBodyType(null);
        } else {
            $this$setBody.setBody(t);
            Intrinsics.reifiedOperationMarker(4, "T");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                Intrinsics.reifiedOperationMarker(6, "T");
            } catch (Throwable th2) {
            }
            $this$setBody.setBodyType(new TypeInfo(orCreateKotlinClass2, (KType) null));
        }
    }

    public static final void setBody(HttpRequestBuilder $this$setBody, Object body, TypeInfo bodyType) {
        Intrinsics.checkNotNullParameter($this$setBody, "<this>");
        Intrinsics.checkNotNullParameter(bodyType, "bodyType");
        $this$setBody.setBody(body == null ? NullBody.INSTANCE : body);
        $this$setBody.setBodyType(bodyType);
    }
}