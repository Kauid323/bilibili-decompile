package io.ktor.websocket.serialization;

import com.bilibili.game.service.exception.DownloadError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebsocketChannelSerialization.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 1, 1}, l = {96, DownloadError.NETWORK_SERVICE_FORBIDDEN}, m = "receiveDeserializedBase", n = {"typeInfo", "converter", "charset", "typeInfo", "frame"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class WebsocketChannelSerializationKt$receiveDeserializedBase$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebsocketChannelSerializationKt$receiveDeserializedBase$2(Continuation<? super WebsocketChannelSerializationKt$receiveDeserializedBase$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WebsocketChannelSerializationKt.receiveDeserializedBase(null, null, null, null, (Continuation) this);
    }
}