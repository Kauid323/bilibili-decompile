package io.ktor.websocket.serialization;

import com.bilibili.freedata.ui.unicom.UnicomActivateFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebsocketChannelSerialization.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0}, l = {UnicomActivateFragment.ACTIVATE_OFFICAL, 56}, m = "sendSerializedBase", n = {"$this$sendSerializedBase"}, s = {"L$0"})
public final class WebsocketChannelSerializationKt$sendSerializedBase$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebsocketChannelSerializationKt$sendSerializedBase$2(Continuation<? super WebsocketChannelSerializationKt$sendSerializedBase$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WebsocketChannelSerializationKt.sendSerializedBase(null, null, null, null, null, (Continuation) this);
    }
}