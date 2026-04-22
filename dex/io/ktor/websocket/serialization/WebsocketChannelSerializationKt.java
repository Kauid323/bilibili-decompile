package io.ktor.websocket.serialization;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WebsocketChannelSerialization.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\n\u001a\u00020\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\n\u001a\u00020\t*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\n\u0010\u000e\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\u000f\u0010\u0010\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"T", "Lio/ktor/websocket/WebSocketSession;", Column.INVAL_VALUE, "data", "Lio/ktor/serialization/WebsocketContentConverter;", "converter", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", Column.INVAL_VALUE, "sendSerializedBase", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveDeserializedBase", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WebsocketChannelSerializationKt {
    @InternalAPI
    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession $this$sendSerializedBase, Object data, WebsocketContentConverter converter, Charset charset, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        sendSerializedBase($this$sendSerializedBase, data, typeInfo, converter, charset, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object sendSerializedBase(WebSocketSession $this$sendSerializedBase, Object obj, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        WebsocketChannelSerializationKt$sendSerializedBase$2 websocketChannelSerializationKt$sendSerializedBase$2;
        Object serialize;
        Frame serializedData;
        SendChannel<Frame> outgoing;
        if (continuation instanceof WebsocketChannelSerializationKt$sendSerializedBase$2) {
            websocketChannelSerializationKt$sendSerializedBase$2 = (WebsocketChannelSerializationKt$sendSerializedBase$2) continuation;
            if ((websocketChannelSerializationKt$sendSerializedBase$2.label & Integer.MIN_VALUE) != 0) {
                websocketChannelSerializationKt$sendSerializedBase$2.label -= Integer.MIN_VALUE;
                Object $result = websocketChannelSerializationKt$sendSerializedBase$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (websocketChannelSerializationKt$sendSerializedBase$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        websocketChannelSerializationKt$sendSerializedBase$2.L$0 = $this$sendSerializedBase;
                        websocketChannelSerializationKt$sendSerializedBase$2.label = 1;
                        serialize = websocketContentConverter.serialize(charset, typeInfo, obj, websocketChannelSerializationKt$sendSerializedBase$2);
                        if (serialize == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        serializedData = (Frame) serialize;
                        outgoing = $this$sendSerializedBase.getOutgoing();
                        websocketChannelSerializationKt$sendSerializedBase$2.L$0 = null;
                        websocketChannelSerializationKt$sendSerializedBase$2.label = 2;
                        if (outgoing.send(serializedData, websocketChannelSerializationKt$sendSerializedBase$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this$sendSerializedBase = (WebSocketSession) websocketChannelSerializationKt$sendSerializedBase$2.L$0;
                        ResultKt.throwOnFailure($result);
                        serialize = $result;
                        serializedData = (Frame) serialize;
                        outgoing = $this$sendSerializedBase.getOutgoing();
                        websocketChannelSerializationKt$sendSerializedBase$2.L$0 = null;
                        websocketChannelSerializationKt$sendSerializedBase$2.label = 2;
                        if (outgoing.send(serializedData, websocketChannelSerializationKt$sendSerializedBase$2) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        websocketChannelSerializationKt$sendSerializedBase$2 = new WebsocketChannelSerializationKt$sendSerializedBase$2(continuation);
        Object $result2 = websocketChannelSerializationKt$sendSerializedBase$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (websocketChannelSerializationKt$sendSerializedBase$2.label) {
        }
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession $this$receiveDeserializedBase, WebsocketContentConverter converter, Charset charset, Continuation<Object> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
        InlineMarker.mark(0);
        Object receiveDeserializedBase = receiveDeserializedBase($this$receiveDeserializedBase, typeInfo, converter, charset, continuation);
        InlineMarker.mark(1);
        return receiveDeserializedBase;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object receiveDeserializedBase(WebSocketSession $this$receiveDeserializedBase, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) {
        WebsocketChannelSerializationKt$receiveDeserializedBase$2 websocketChannelSerializationKt$receiveDeserializedBase$2;
        WebsocketContentConverter converter;
        TypeInfo typeInfo2;
        Charset charset2;
        Object receive;
        Frame frame;
        Object result;
        Frame frame2;
        TypeInfo typeInfo3;
        if (continuation instanceof WebsocketChannelSerializationKt$receiveDeserializedBase$2) {
            websocketChannelSerializationKt$receiveDeserializedBase$2 = (WebsocketChannelSerializationKt$receiveDeserializedBase$2) continuation;
            if ((websocketChannelSerializationKt$receiveDeserializedBase$2.label & Integer.MIN_VALUE) != 0) {
                websocketChannelSerializationKt$receiveDeserializedBase$2.label -= Integer.MIN_VALUE;
                Object $result = websocketChannelSerializationKt$receiveDeserializedBase$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (websocketChannelSerializationKt$receiveDeserializedBase$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        converter = websocketContentConverter;
                        typeInfo2 = typeInfo;
                        charset2 = charset;
                        ReceiveChannel<Frame> incoming = $this$receiveDeserializedBase.getIncoming();
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$0 = typeInfo2;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$1 = converter;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$2 = charset2;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.label = 1;
                        receive = incoming.receive(websocketChannelSerializationKt$receiveDeserializedBase$2);
                        if (receive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        frame = (Frame) receive;
                        if (converter.isApplicable(frame)) {
                            throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame.getFrameType().name(), (Throwable) null, frame, 2, (DefaultConstructorMarker) null);
                        }
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$0 = typeInfo2;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$1 = frame;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.L$2 = null;
                        websocketChannelSerializationKt$receiveDeserializedBase$2.label = 2;
                        result = converter.deserialize(charset2, typeInfo2, frame, websocketChannelSerializationKt$receiveDeserializedBase$2);
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        frame2 = frame;
                        typeInfo3 = typeInfo2;
                        if (typeInfo3.getType().isInstance(result)) {
                            if (result == null) {
                                KType kotlinType = typeInfo3.getKotlinType();
                                if (kotlinType == null || !kotlinType.isMarkedNullable()) {
                                    z = false;
                                }
                                if (z) {
                                    return null;
                                }
                                throw new WebsocketDeserializeException("Frame has null content", (Throwable) null, frame2, 2, (DefaultConstructorMarker) null);
                            }
                            throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(result.getClass()).getSimpleName(), (Throwable) null, frame2, 2, (DefaultConstructorMarker) null);
                        }
                        return result;
                    case 1:
                        converter = (WebsocketContentConverter) websocketChannelSerializationKt$receiveDeserializedBase$2.L$1;
                        typeInfo2 = (TypeInfo) websocketChannelSerializationKt$receiveDeserializedBase$2.L$0;
                        ResultKt.throwOnFailure($result);
                        charset2 = (Charset) websocketChannelSerializationKt$receiveDeserializedBase$2.L$2;
                        receive = $result;
                        frame = (Frame) receive;
                        if (converter.isApplicable(frame)) {
                        }
                        break;
                    case 2:
                        frame2 = (Frame) websocketChannelSerializationKt$receiveDeserializedBase$2.L$1;
                        typeInfo3 = (TypeInfo) websocketChannelSerializationKt$receiveDeserializedBase$2.L$0;
                        ResultKt.throwOnFailure($result);
                        result = $result;
                        if (typeInfo3.getType().isInstance(result)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        websocketChannelSerializationKt$receiveDeserializedBase$2 = new WebsocketChannelSerializationKt$receiveDeserializedBase$2(continuation);
        Object $result2 = websocketChannelSerializationKt$receiveDeserializedBase$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (websocketChannelSerializationKt$receiveDeserializedBase$2.label) {
        }
    }
}