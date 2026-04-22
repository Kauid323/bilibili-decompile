package io.ktor.client.plugins.sse;

import host.R;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultClientSSESession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {R.styleable.CameraView_cameraVideoSizeAspectRatio, 49, 98}, m = "parseEvent", n = {"this", "$this$parseEvent", UtilsKt.DATA_KEY, "comments", "curRetry", "lastEventId", "wasData", "wasComments", "this", "$this$parseEvent", UtilsKt.DATA_KEY, "comments", "curRetry", "lastEventId", "wasData", "wasComments", "this", "$this$parseEvent", UtilsKt.DATA_KEY, "comments", "eventType", "curRetry", "lastEventId", "wasData", "wasComments"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
public final class DefaultClientSSESession$parseEvent$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession$parseEvent$1(DefaultClientSSESession defaultClientSSESession, Continuation<? super DefaultClientSSESession$parseEvent$1> continuation) {
        super(continuation);
        this.this$0 = defaultClientSSESession;
    }

    public final Object invokeSuspend(Object obj) {
        Object parseEvent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        parseEvent = this.this$0.parseEvent(null, (Continuation) this);
        return parseEvent;
    }
}