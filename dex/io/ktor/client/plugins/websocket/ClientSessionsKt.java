package io.ktor.client.plugins.websocket;

import im.setting.UtilsKt;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.serialization.WebsocketChannelSerializationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: ClientSessions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0006\u0010\t\u001a\"\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u0000H\u0086H¢\u0006\u0004\b\n\u0010\f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "", UtilsKt.DATA_KEY, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "sendSerialized", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveDeserialized", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/serialization/WebsocketContentConverter;", "getConverter", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;)Lio/ktor/serialization/WebsocketContentConverter;", "converter", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClientSessionsKt {
    public static final WebsocketContentConverter getConverter(DefaultClientWebSocketSession $this$converter) {
        Intrinsics.checkNotNullParameter($this$converter, "<this>");
        WebSockets webSockets = (WebSockets) HttpClientPluginKt.pluginOrNull($this$converter.getCall().getClient(), WebSockets.Plugin);
        if (webSockets != null) {
            return webSockets.getContentConverter();
        }
        return null;
    }

    public static final Object sendSerialized(DefaultClientWebSocketSession $this$sendSerialized, Object data, TypeInfo typeInfo, Continuation<? super Unit> continuation) {
        WebsocketContentConverter converter = getConverter($this$sendSerialized);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object sendSerializedBase = WebsocketChannelSerializationKt.sendSerializedBase($this$sendSerialized, data, typeInfo, converter, ContentConverterKt.suitableCharset$default($this$sendSerialized.getCall().getRequest().getHeaders(), null, 1, null), continuation);
        return sendSerializedBase == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendSerializedBase : Unit.INSTANCE;
    }

    public static final /* synthetic */ <T> Object sendSerialized(DefaultClientWebSocketSession $this$sendSerialized, T t, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        sendSerialized($this$sendSerialized, t, typeInfo, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final <T> Object receiveDeserialized(DefaultClientWebSocketSession $this$receiveDeserialized, TypeInfo typeInfo, Continuation<? super T> continuation) {
        WebsocketContentConverter converter = getConverter($this$receiveDeserialized);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object receiveDeserializedBase = WebsocketChannelSerializationKt.receiveDeserializedBase($this$receiveDeserialized, typeInfo, converter, ContentConverterKt.suitableCharset$default($this$receiveDeserialized.getCall().getRequest().getHeaders(), null, 1, null), continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return receiveDeserializedBase;
    }

    public static final /* synthetic */ <T> Object receiveDeserialized(DefaultClientWebSocketSession $this$receiveDeserialized, Continuation<? super T> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object receiveDeserialized = receiveDeserialized($this$receiveDeserialized, typeInfo, continuation);
        InlineMarker.mark(1);
        return receiveDeserialized;
    }
}