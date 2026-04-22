package io.ktor.serialization;

import faceverify.q;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebsocketContentConverter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH¦@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/serialization/WebsocketContentConverter;", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "value", "Lio/ktor/websocket/Frame;", "serialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frame", "", "isApplicable", "(Lio/ktor/websocket/Frame;)Z", "ktor-serialization"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WebsocketContentConverter {
    Object deserialize(Charset charset, TypeInfo typeInfo, Frame frame, Continuation<Object> continuation);

    boolean isApplicable(Frame frame);

    Object serialize(Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super Frame> continuation);

    /* compiled from: WebsocketContentConverter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static Object serialize(WebsocketContentConverter $this, Charset charset, TypeInfo typeInfo, Object value, Continuation<? super Frame> continuation) {
            Intrinsics.checkNotNull(value);
            return $this.serialize(charset, typeInfo, value, continuation);
        }
    }
}